# Aufgabenblock 1: Clojure Grundlagen

Die Aufgaben in dieser Einheit beziehen sich auf die Vorlesungsfolien __Clojure Grundlagen__.

Folgende Themen werden durch die Aufgaben abgedeckt:

  * Kontrollstrukturen
  * Schleifen
  * Ausdrücke


## 1. Prefix-Notation
Bitte wandeln Sie den folgenden mathematischen Ausdruck in einen gültigen Clojure-Ausdruck in _Prefix-Notation_ um: `42 / (3 + 3 * 3) * 4 - 11`.

---

```clojure
(- (* (/ 42 (+ (* 3 3) 3)) 4) 11)
```


## 2. Erste Schritte

Sie haben einen Nebenjob als Programmierer*in bei der _Abzock GmbH_, einem bekannten PlayStation 5-Scalper. Sie sollen ein kleines Clojure-Programm für die Preisgestaltung auf der Webseite der Firma schreiben.

  * Legen Sie ein Clojure-Skript `scalper.clj` an
  * Das Skript fragt (`read-line`) nach einem Produktnamen und nach einem Einkaufs-Preis p_E
  * Es gibt den Produktnamen mit Verkaufspreis (p_V) aus (`print` und `println`)
  * Es gilt p_V = max(2.5 x p_E, 995)

Hinweis: Verwenden Sie `Integer/parseInt` für die Umwandlung des Einkaufspreises und `max` für die Berechnung des Maximums.

```console
$ ./scalper.clj
Produktname:
PS5 digital edition
Einkauspreis:
440

Sonderangebot: PS5 digital edition für nur 1100.0 EUR
```

---
```clojure
#!/usr/bin/env -S clojure -M

(println "Produktname: ")
(def produkt (read-line))

(println "Einkauspreis:")
(def preis-einkauf (Integer/parseInt (read-line)))

(def preis-verkauf (max (* 2.5 preis-einkauf) 995))

(println "")
(print "Sonderangebot: ")
(println produkt "für nur" preis-verkauf "EUR")
```


## 3. Maps: Lagerverwaltung

Die Abzock GmbH ist sehr zufrieden mit Ihnen, sodass Sie jetzt die Lagerverwaltung optimieren sollen. Aktuell hat die Firma nur drei Artikel auf Lager: PlayStation 5 (10 Stück), Grafikkarten vom Typ GTX1090 (20 Stück) und Sonnenblumenöl (300 Flaschen). Verwenden Sie als Schlüssel die Keywords `:PS5`, `:GTX1090` und `:OEL`.

  * Legen Sie ein Clojure-Skript  `abzock-lager.clj` an
  * Implementieren Sie das Lager als Map im Programm mit den Keywords als Key und dem Bestand als Wert
  * Fragen Sie auf der Kommandozeile nach Warenabgängen
  * Ziehen Sie den Warenabgang vom Lager ab und geben Sie die neuen Bestände aus
  * Hinweis: Obwohl nicht sauber, dürfen Sie hier dasselbe Symbol mehrfach mit einem `def` überschreiben. Versuchen Sie nicht die Map mit `update` zu verändern, sondern entfernen Sie den Schlüssel und fügen Sie ihn danach mit dem neuen Bestand wieder ein.

```console
$ clj -M abzock-lager.clj
Lagerverwaltung Abzock GmbH
Welcher Artikel wurde geliefert:
PS5
Wieviel wurde ausgeliefert?
5

Neuer Lagerbestand
{:GTX1090 20, :OEL 300, :PS5 5}
```

---
```clojure
#!/usr/bin/env -S clojure -M

(def lager {
    :PS5      10
    :GTX1090  20
    :OEL     300
})

(println "Lagerverwaltung Abzock GmbH")
(println "Welcher Artikel wurde geliefert: ")
(def artikel (keyword (read-line)))
(println "Wieviel wurde ausgeliefert?")
(def menge (Integer/parseInt (read-line)))

(def bestand-alt (get lager artikel))
(def bestand-neu (- bestand-alt menge))

(def lager (dissoc lager artikel))
(def lager (assoc  lager artikel bestand-neu))

(println "")
(println "Neuer Lagerbestand")
(println lager)
```


## 4. Kontrolltrukturen: Lagerverwaltung, Teil 2

Die Lagerverwaltung aus der letzten Übung funktioniert gut, allerdings können die Bestände hier unter 0 fallen. Dies wollen Sie in einer nächsten Version korrigieren:

  * Kopieren Sie das Clojure-Skript der letzten Übung und nennen Sie die Kopie `abzock-lager-2.clj`
  * Ändern Sie es so ab, dass Abgänge nur verbucht werden, wenn noch ausreichend Lagerbestand vorhanden ist
  * Reicht der Lagerbestand nicht aus, beleidigen Sie den Benutzer und buchen den Abgang nicht

```console
Lagerverwaltung Abzock GmbH
Welcher Artikel wurde geliefert:
PS5
Wie viel wurde ausgeliefert?
30
Nicht genug Artikel vorhanden, du unwissendes Frischfleisch

Neuer Lagerbestand
{:PS5 10, :GTX1090 20, :OEL 300}
```

```console
Lagerverwaltung Abzock GmbH
Welcher Artikel wurde geliefert:
PS5
Wie viel wurde ausgeliefert?
10

Neuer Lagerbestand
{:GTX1090 20, :OEL 300, :PS5 0}
```

---
```clojure
#!/usr/bin/env -S clojure -M

(def lager {
    :PS5      10
    :GTX1090  20
    :OEL     300
})

(println "Lagerverwaltung Abzock GmbH")
(println "Welcher Artikel wurde geliefert: ")
(def artikel (keyword (read-line)))
(println "Wieviel wurde ausgeliefert?")
(def menge (Integer/parseInt (read-line)))

(def bestand-alt (get lager artikel))
(def bestand-neu (- bestand-alt menge))

(if (< bestand-neu 0)
  (println "Nicht genug Artikel vorhanden, du unwissendes Frischfleisch")
  (do
    (def lager (dissoc lager artikel))
    (def lager (assoc  lager artikel bestand-neu))))

(println "")
(println "Neuer Lagerbestand")
(println lager)
```


## 5. Map und Reduce: Gewinnermittlung für die Abzock GmbH

Nachdem die Abzock GmbH wirklich goldene Zeiten gesehen hat, möchte die Firma einen besseren Überblick über die Einnahmen haben. Die Geschäftsführer möchten sich nämlich von dem Gewinn Teslas kaufen und damit vollkommen sinnlos in der Gegend herumfahren und dabei rufen "Eure Armut kotzt uns an".

Dank Ihrer unermüdlichen Arbeit, liegen die Verkaufsdaten der Firma bereits in Clojure Datenstrukturen vor.

```clojure{Verkaufte Stückzahlen}
(def verkaeufe-stueckzahlen {
    :PS5      [ 10, 5, 8, 13, 22, 42, 110 ],
    :GTX1090  [ 5, 7, 11, 54, 90 ],
    :OEL      [ 10, 44, 100, 343, 66, 52, 23 ]})
```

```clojure{Verkaufspreise}
(def verkaufspreise {
    :PS5      1239,
    :GTX1090  1699,
    :OEL      9 })
```

Schreiben Sie ein Clojure-Skript `abzock-gewinn.clj`:

  * Berechnen Sie die Einnahmen jedes einzelnen Verkaufs
  * Berechnen Sie die Summer der Einnahmen pro Produkt
  * Geben Sie das Ergebnis mit `println` aus
  * Verwenden Sie `doseq`, `map` und `reduce`

```console{Ausgabe des Programms}
Gewinnermittlung Abzock GmbH
:PS5 260190 EUR
:GTX1090 283733 EUR
:OEL 5742 EUR
```

---
```clojure
#!/usr/bin/env -S clojure -M

(def verkaeufe-stueckzahlen {
    :PS5      [ 10, 5, 8, 13, 22, 42, 110 ],
    :GTX1090  [ 5, 7, 11, 54, 90 ],
    :OEL      [ 10, 44, 100, 343, 66, 52, 23 ]})

(def verkaufspreise {
    :PS5      1239,
    :GTX1090  1699,
    :OEL      9 })

(println "Gewinnermittlung Abzock GmbH")

(defn summiere [stueckzahlen preise]
    (doseq [[key values] stueckzahlen]
      (println key
               (reduce + (map #(* % (key preise)) values))
               "EUR")))

(summiere verkaeufe-stueckzahlen verkaufspreise)
```


