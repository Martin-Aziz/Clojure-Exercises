# Assignment: Kann ich dem Zufallsgenerator trauen?

*Fällig: 15.05.2022* / [Musterlösung](solution/)

Während Sie mit der Linie 1 durch Mannheim cruisen, denn Auto fahren Sie wegen des Klimas nicht mehr, spricht Sie ein seltsamer Typ mit langem Trenchcoat und einem schwarzen Schlapphut an: "Hey, du... Pssst..." Sie erwarten jetzt eigentlich, dass er versucht Ihnen Marihuana zu verkaufen - was Sie natürlich dankend ablehnen würden, so kurz vor der Legalisierung kaufen Sie doch nicht mehr in der Straßenbahn, sondern bald in der Apotheke. Aber nein: er bietet Ihnen einen brandneuen Zufallszahlengenerator an, der von amerikanischen Wissenschaftlern entwickelt wurde und als extrem sicher gilt. Um den Kerl loszuwerden, geben Sie ihm eine Ihrer Wegwerf-E-Mail-Adressen und steigen an der nächsten Station aus.

<img src="schlemihl.jpg" width="200">

Tatsächlich bekommen Sie am nächsten Tag eine E-Mail, in der ein Zufallszahlengenerator mit der Funktion `srand-int` enthalten ist.

  * [srand-int.clj](srand-int.clj)

Jetzt ist Ihr Interesse geweckt. Vielleicht hat der Typ ja doch etwas Interessantes gefunden.

Sie öffnen Ihren Editor und fangen an die Frage, ob `srand-int` wirklich zufällige Zahlen liefert, zu untersuchen.

**Ziel**: Ziel dieses Assignments ist es, in Clojure mit größeren Mengen von Daten in Vektoren und Sequenzen zu arbeiten.


## Zufall analysieren

### Beschreibung des Programms

Sie sollen zeigen, ob die von `srand-int` generierten Zahlen wirklich vollkommen zufällig sind. Um die Mühe eines mathematischen Beweises zu sparen, wählen Sie einen statistischen Ansatz und testen die Daten auf Gleichverteilung.

Um Ihren Ansatz zu testen, benutzen Sie zuerst den in Clojure eingebauten Zufallszahlengenerator `rand-int` und danach die Funktion `srand-int`.

Schreiben Sie ein Clojure-Skript `analyze-random.clj`, dass wie folgt vorgeht:

  1. Berechnen Sie 100000000 Zufallszahlen im Bereich von 0-9999.
  2. Speichern Sie, wie häufig jede Zahl gezogen wurde in einem Vektor.
  3. Normieren Sie die Daten im Vektor so, dass die prozentuale Abweichung (positiv wie negativ) vom Ideal einer Gleichverteilung für jede Zahl gespeichert ist.
  4. Berechnen Sie über alle Elemente des Vektors die Wurzel aus der Summe der Quadrate der Elemente.
  5. Geben Sie das Ergebnis für die beiden Zufallsgeneratoren aus.

*Zu welchem Urteil kommen Sie bezüglich der Qualität des Zufallszahlengenerators aus der Straßenbahn?*

### Beispiel

Zum besseren Verständnis der Methode ein Beispiel für den Zahlenbereich 0-3 und 12 Ziehungen: gezogene Zufallszahlen: `3, 0, 3, 3, 0, 0, 3, 1, 0, 3, 3, 2`


|Zahl| Häufigkeit | erwartet | abs Abw. | rel Abw. |    ^2 |
|----|------------|----------|----------|----------|-------|
|  0 |          4 |        3 |       +1 |    0.333 | 0.111 |
|  1 |          1 |        3 |       -2 |   -0.666 | 0.444 |
|  2 |          1 |        3 |       -2 |   -0.666 | 0.444 |
|  3 |          6 |        3 |       +3 |    1.000 | 1.000 |

Der Fehler des Generators ergibt sich dann als sqrt(0.111 + 0.444 + 0.444 + 1.000) = 1.4139

### Clojure-Features

Bitte verwenden Sie die folgenden Clojure-Features in Ihrem Programm:

  * Laden von anderen Dateien mit `(load-file "...")`
  * `loop` und `recur`
  * `let`
  * `map` und `reduce`
  * Kommentieren Sie Ihre Funktionen!


### Abgabe


Laden Sie den Quelltext Ihres fertigen Programms in Ihr Git-Repository zur Vorlesung hoch. Wählen Sie eine geeignete Verzeichnisstruktur, um auch weitere Lösungen dort ablegen zu können.