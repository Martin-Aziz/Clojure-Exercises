;; Schnick-Schnack-Schnuck (Rock - Paper - Scissors)
;;
;; (c) 2022 Thomas Smits
;;

(defn compare-move
  "Vergleicht die Züge zweier Spieler miteinander.
  Die Züge der beiden Spieler (`a` und `b`) werden als
  Keyword übergeben. Das Ergebnis ist ein Vektor mit
  dem Punkten für die Spieler.

  Gültige Eingaben sind: :SCISSORS; :PAPER und :ROCK.
  Andere Schlüsselworte führen in eine Endlosschleife!"
  [a b]
  (cond
    (= a b)                               [ 0, 0 ]
    (and (= a :SCISSORS) (= b :PAPER))    [ 1, 0 ]
    (and (= a :ROCK)     (= b :SCISSORS)) [ 1, 0 ]
    (and (= a :PAPER)    (= b :ROCK))     [ 1, 0 ]
    :else (into [] (reverse (compare-move b a)))))

(defn input-to-symbol
  "Konvertiert einen String mit der Eingabe für den
  gewählten Zug in ein Keyword"
  [a]
  (cond
    (or (= a "R") (= a "r")) :ROCK
    (or (= a "P") (= a "p")) :PAPER
    (or (= a "S") (= a "s")) :SCISSORS
    :else                    nil))

(defn update-points
  "Aktualisiert die Punkte der Spieler."
  [[points-a-total points-b-total]  ; Parameter A
   [points-a points-b]] ; Parameter B
   [(+ points-a-total points-a) (+ points-b-total points-b)])

(defn player-move
  "Liest den Input des Spielers und gibt den Zug zurück."
  []
  (println "Dein Zug ([r]rock, [p]aper, [s]cissors)?")
  (-> (read-line) input-to-symbol))

(defn computer-move
  "Lässt den Computer einen zufälligen Zug machen."
  []
  (first (shuffle [:SCISSORS :PAPER :ROCK])))

(defn bewertung
  [[points-computer points-player]]
  (cond
    (= points-computer points-player) "Unentschieden"
    (< points-computer points-player) "Du hast gewonnen"
    (> points-computer points-player) "Der Computer hat gewonnen"))

(defn one-round
  "Spielt eine Runde"
  [round points]
  (let [computer (computer-move)
        player   (player-move)]
    (let [result (compare-move computer player)]
      (println "Runde" round ": Du" player "- Computer" computer "->" (bewertung result))
      (update-points points result))))

(defn endergebnis
  "Gibt das Endergebnis des Spiels aus"
  [[points-a points-b]]
  (str (bewertung [ points-a points-b ]) " - Du " points-b " Punkt(e), Computer " points-a " Punkt(e)"))

(println "Willkommen bei Schnick-Schnack-Schnuck")

(let [final (one-round 3 (one-round 2 (one-round 1 [0 0])))]
  (println)
  (println (endergebnis final)))
