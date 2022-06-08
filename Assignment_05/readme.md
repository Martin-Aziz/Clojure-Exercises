# Assignment: Gelangweilte Affen oder wie werde ich reich

*Fällig: 21.05.2022* / [Musterlösung](solution/)

Nachdem Sie erfolgreich nachweisen konnten, dass der Zufallszahlengenerator von dem zwielichtigen Typen aus der Straßenbahn wirklich nichts taugt, erfahren Sie, dass er ihn bereits erfolgreich an eine Gruppe von Crypto-Bros im Silicon Valley verkauft hat. Das kaputte Teil wird also tatsächlich eingesetzt.

<img src="ape.jpg" width="300">

Das ist Ihre Chance: Wenn Sie wüssten, welchen Bias der Zufallszahlengenerator hat, könnten Sie dieses Wissen vielleicht nutzen, um die Algorithmen auszutricksen, die dafür benutzt werden, die Crypto-Affen-Tokens zu erzeugen. Sie könnten reich werden!

Wie findet man am einfachsten heraus, welche Schwächen ein Zufallszahlengenerator hat? Man erzeugt ein Bild mit der Häufigkeitsverteilung. Aber kein einfaches Histogramm - das kann ja jeder - sondern ein Bild, in dem jedes Pixel der Häufigkeit entspricht. Vielleicht können Sie ja sogar dieses Bild als NFT verkaufen?

### Beschreibung des Programms

Schreiben Sie ein kleines Clojure-Skript `draw-random.clj`, das die erzeugten Zufallszahlen als PNG-Bild darstellt:

  * Machen Sie die Abmessungen des Bildes im Programm über Konstanten einstellbar
  * Fangen Sie mit 100x100 Pixeln an
  * Berechnen Sie viele Zufallszahlen zwischen 0 und der Anzahl der Pixel - 1. Wir sprechen hier von wirklich vielen Zahlen, z.B. 100000000 Stück.
  * Färben Sie die Pixel entsprechend der Häufigkeit der Zufallszahlen mit dem jeweiligen Wert ein.
  * Das Bild soll ein Graustufenbild im PNG-Format sein.
  * Die Farbe jedes Pixel entspricht der Häufigkeit, dass die Zahl gezogen wurde. Je häufiger, desto heller.

*Hinweis*: Da es nur 255 Graustufen gibt, Sie aber mehr Werte haben, müssen Sie die Häufigkeit der Zahlen auf die Graustufenskala mappen. Nehmen Sie dazu einfach den Maximalwert über alle Zahlen und dividieren Sie alle Elemente durch diesen Wert und nehmen Sie das Ergebnis mal 255.

Für die einfache Erzeugung von PNG-Bilder in Clojure bietet es sich an, auf die Klasse `java.awt.image.BufferedImage` zurückzugreifen. Das Speichern erfolgt über `ImageIO/write`. Da die Klasse `BufferedImage` die Farben als RGB-Werte bekommt, müssen Sie die Graustufen entsprechend auf die drei Bytes verteilen. Aus dem Graustufenwert `0xAB` wird dann `0xABABAB`.

Speichern Sie das Bild des eingebaugten Zufallszahlengenerators von Clojure in einer Datei `clojure-random.png` ab.

Nachdem Sie ein Bild mit Clojures Zufallszahlengenerator erzeugt haben, erzeugen Sie ein weiteres Bild mit dem [Generator von Schlemihl](srand-int.clj). Speichern Sie dieses Bild in einer Datei `schlemihl-random.png` ab.

Vergleichen Sie die beiden Bilder. Was fällt Ihnen auf?

Die Bilder sind Teil der Abgabe.


### Noch ein Zufallszahlengenerator

Sie haben die Schwäche des Zufallszahlengenerators gefunden! Ganz stolz gehen Sie an die Hochschule und wollen Ihren Mitstudierenden in PR3 davon erzählen. Und, wen sehe Sie vor der Tür stehen?

<img src="schlemihl.jpg" width="200">

Lauert Ihnen der Typ eventuell auf? Sie wissen es nicht. Er versucht Ihnen, einen weiteren Zufallszahlengenerator mit der vielversprechenden Funktion `super-secret-rand-int` anzudrehen. Um ihn loszuwerden, nehmen Sie das Ding und eilen schnell weiter in die Mathematikvorlesung - Ihr triviales Lieblingsfach.

[super-secret-rand-int.clj](super-secret-rand-int.clj)

Da Sie ja jetzt alles zusammen haben, erzeugen Sie auch von dem neuen Generator ein Bild (`secret-random.png`) nach demselben Verfahren. Was sehen Sie?

Das Bild ist Teil der Abgabe.

### Abgabe


Laden Sie den Quelltext Ihres fertigen Programms in Ihr Git-Repository zur Vorlesung hoch. Wählen Sie eine geeignete Verzeichnisstruktur, um auch weitere Lösungen dort ablegen zu können.