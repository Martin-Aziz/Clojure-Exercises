#!/usr/bin/env -S clojure -M

(load-file "../super-secret-rand-int.clj")
(load-file "../srand-int.clj")

(import javax.imageio.ImageIO)
(import java.io.File)
(import java.io.FileWriter)
(import java.awt.image.BufferedImage)

(def width 100)
(def height 100)

; Number of runs to sample random numbers
(def runs 100000000)
(def size (* width height))

(defn create-data
  "Creates a vector with the absoulte number of random numbers
  created by the generator function `rnd`.  The vector has the
  size `size` and there are `rounds` invocations to the random
  function."
  [size rounds rnd]
  (loop [result (into [] (repeat size 0)) i 0]
    (if (>= i rounds)
      result
      (let [number     (rnd size)
            old-value  (nth result number)
            new-result (assoc result number (inc old-value))]
        (recur new-result (inc i))))))

(defn map-to-grayscale
  "Maps the data in the given `array` to a grayscale value
  in the range 0-255."
  [array]
  (let [size      (count array)
        max       (apply max array)
        factor    (/ 255 max)
        result    (map #(int (* % factor)) array)]
    result))

(defn grayscale-to-rgb
  "Converts a grayscale value into an RGB value.
  The alpha channel is not taken into account."
  [grayscale]
  (bit-or (bit-shift-left grayscale 0)
          (bit-shift-left grayscale 8)
          (bit-shift-left grayscale 16)))

(defn array-to-image
  "Converts the array `array` with grayscale values into
  a PNG image with the dimensions `width` and `height` and
  stores it using the filename `filename`."
  [array width height filename]
  (let [image  (BufferedImage. width height BufferedImage/TYPE_BYTE_GRAY)
        length (count array)]
    (loop [pos 0]
      (if (>= pos length)
        (do
          (let [file (File. filename)]
            (ImageIO/write image "PNG" file)))
          (let [x (rem pos width)
                y (quot pos width)
                p (nth array pos)]
            (.setRGB image x y (grayscale-to-rgb p))
            (recur (inc pos)))))))

; Helper function to keep calls short
(def create-img-data (partial create-data size runs))

; Render the data
(println "Drawing standard random generator")
(def rand-array   (create-img-data rand-int))
(def clojure-gs (into [] (map-to-grayscale rand-array)))
(array-to-image clojure-gs width height "clojure-random.png")

(println "Drawing 1st secret random generator")
(def srand-array  (create-img-data srand-int))
(def schlemihl-gs (into [] (map-to-grayscale srand-array)))
(array-to-image schlemihl-gs width height "schlemihl-random.png")

(println "Drawing 2nd secret random generator")
(def super-rand-array (create-img-data super-secret-rand-int))
(def secret-gs (into [] (map-to-grayscale super-rand-array)))
(array-to-image secret-gs width height "super-secret-rand-int.png")
