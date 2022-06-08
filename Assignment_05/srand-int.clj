;; Psst...
;; Super secure and mathematically correct random number generator
;;
;; (c) Schlemihl

(defn srand-int [max]
    "Generate a new random number between 0 and `max` (exlusive)"
    (let [a (int (rand max))
          b (int (rand max))]
        (int (/ (+ a b) 2))))
