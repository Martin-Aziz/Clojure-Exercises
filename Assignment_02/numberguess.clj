;; Numberguess
;;
;; Ein einfaches Zahlenratespiel in Clojure.
;; Da wir loop und recur noch nicht verwenden wollen,
;; wird ein wenig getrickst.
;;
;;

; Maximale Zahl, die geraten werden kann
(def max-number 100)

(defn get-number
  "Liest eine Zahl von der Console zwischen 1 und `max-number`.
  `max-number` ist als globales Symbol definiert und muss der
  Funktion nicht übergeben werden."
  []
  (println "Bitte geben Sie eine Zahl zwischen 1 und" max-number "ein: ")
  (let [zahl (read)]
    (if (or (< zahl 1) (> zahl max-number))
          (get-number)  ; Zahl passt nicht, rufe mich selbst auf
          zahl)))       ; die eingelesene Zahl

(defn test-number
  "Vergleicht zwei Zahlen und gibt einen Hinweis-Text.
  Der Hinweistext erklärt, ob die Zahl `guess` größer, kleiner
  oder gleich zur Zahl `correct` ist."
  [correct guess]
  (cond (= correct guess) "Richtig"
        (< correct guess) "Zu groß"
        (> correct guess) "Zu klein"))

(defn game
  "Spielt das Spiel.
  Um hier loop und recur zu vermeiden, bekommt der Spieler maximal
  100 Versuche. Wurde der richtige Wert geraten, steigt die Funktion
  hart mit System.exit(0) aus. Nicht elegant, aber wirkungsvoll.
  Mehr Seiteneffekt kann man kaum bekommen."
  []
  (println "Willkommen beim besten Zahlenratespiel aller Zeiten")
  (let [correct-number (inc (rand-int max-number))]
    (dotimes [rounds 100]
      (let [guess (get-number)]
        (println (test-number correct-number guess))
        (if (= guess correct-number)
          (do
            (println "Super und Tschüss: Du hast" (inc rounds) "Runden gebraucht")
            (System/exit 0)))))
    (println "Ich habe keine Lust mehr - 100 Runden, du Looser")))

;; Spiel starten
(game)
