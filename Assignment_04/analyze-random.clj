#!/usr/bin/env -S clojure -M

; Test for Schlemihls generator

 (load-file "../srand-int.clj")

; Number of runs to sample random numbers
(def runs 100000000)
(def size 10000)

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

(defn map-to-relative
  "Maps the data in the given `array` to the relative deviation
  from an equal distribution."
  [rounds array]
  (let [size      (count array)
        expected  (/ rounds size)
        result     (map #(/ (- expected %) expected) array)]
    result))

(defn calc-rms
  "Calc the root mean square for the whole array"
  [array]
  (let [squares (reduce #(+ %1 (* %2 %2)) 0 array)]
    (Math/sqrt squares)))

; Test the standard generator
(def rand-array (create-data size runs rand-int))
(def rms-standard (calc-rms (map-to-relative runs rand-array)))
(println "RMS for standard generator: " rms-standard)

(def srand-array (create-data size runs srand-int))
(def rms-schlemihl (calc-rms (map-to-relative runs (create-data size runs srand-int))))
(println "RMS for Schlemihls generator: " rms-schlemihl)
