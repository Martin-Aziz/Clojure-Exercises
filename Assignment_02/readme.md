# Assignment: Zahlenraten

*Fällig: 01.05.2022* / [Musterlösung](solution/)

Endlich: Präsenzbetrieb! Wieder den Duft von schlecht gelüfteten Hörsälen und Schlangestehen für das "leckere" Mensaessen -- wie haben Sie das in den Corona-Semestern vermisst. Sie sitzen in einer Mathematik-Vorlesung und versuchen zum 100. Mal eine PlayStation 5 bei Amazon zu ergattern. Keine Chance. Zu teuer oder vergriffen. Grafikkarte: Fehlanzeige. Da kommen Sie auf die geniale Idee: "Wer braucht schon Horizon Forbidden West, wenn er sich selbst ein Spiel programmieren kann?" Immerhin sind Sie doch schon fast fertig mit dem Studium und damit hoch-kompetent für die Entwicklung eines Spiels.

Gesagt getan: Sie setzen sich vor den Rechner und schreiben das nächste Blockbuster-Spiel: _Zahlenraten_. Da Sie gerade eine Vorlesung zur funktionalen Programmierung hören, entwickeln Sie das Spiel in Clojure.

**Ziel**: Ziel dieses Assignments ist es, erste Schritte mit Clojure zu machen und die Syntax kennenzulernen. Als Test Ihrer Kenntnisse werden Sie ein ganz, ganz einfaches Spiel programmieren.


## Umgebung aufsetzen

Zuerst müssen Sie die Clojure-Umgebung installieren, damit Sie in der Lage sind, Clojure-Programme auszuführen. Weiterhin benötigen wir _git_, um Übungen herunter und hochzuladen. An der Hochschule finden Sie alle benötigten Werkzeuge im bwLehrPool.


## Zahlenraten entwickeln

### Beschreibung des Programms

Schreiben Sie ein einfaches Zahlenraten-Spiel (`zahlenraten.clj`) in Clojure mit folgenden Eigenschaften:

  * Das Spiel zieht zufällig eine Zahl zwischen 1 und 100, die der Benutzer erraten soll.
  * Der Benutzer wird aufgefordert eine Zahl zwischen 1 und 100 einzugeben.
  * Hat er die richtige Zahl geraten, beendet sich das Programm und zeigt die Anzahl der Versuche an.
  * Hat er die Zahl nicht geraten, sagt ihm das Programm, ob die Zahl zu groß oder zu klein war und nimmt die nächste Eingabe entgegen.
  * Hat der Spieler nach 100 Versuchen nicht richtig geraten, soll das Programm ihn heftig beleidigen und sich beenden.
  * Die maximale Zahl soll im Programm einfach zu ändern sein (d.h. verwenden Sie ein globales Symbol mit `def`)

Eine beispielhafte Session mit dem Programm sieht dann wie folgt aus:

```console
$ clj -M zahlenraten.clj
Willkommen beim Zahlenraten...
Bitte geben Sie eine Zahl ein: 50
Zu groß
Bitte geben Sie eine Zahl ein: 25
Zu groß
Bitte geben Sie eine Zahl ein: 12
Zu klein
Bitte geben Sie eine Zahl ein: 20
Zu groß
Bitte geben Sie eine Zahl ein: 16
Zu klein
Bitte geben Sie eine Zahl ein: 18
Zu klein
Bitte geben Sie eine Zahl ein: 19
Richtig nach 7 Versuchen.
```

### Clojure-Features

Bitte verwenden Sie die folgenden Clojure-Features in Ihrem Programm:

  * Globales Symbol für die maximale Zahl (`def`)
  * Zerlegung des Programms in einzelne Funktionen (`defn`)
  * "Lokale Variablen" mit `let`
  * Kontrollstrukturen mit `if` und/oder `cond`
  * Eingaben mit `read`
  * Ausgaben mit `println`

Für das Ziehen der Zufallszahl können Sie die Funktion `rand-int` benutzen. Denken Sie daran, dass diese Funktion Zufallszahlen von `0` bis `max - 1` liefert, ein `inc` oder `+ 1` vermeidet also viel Frust.

Um die Lösung einfach zu halten und Seiteneffekte zu vermeiden, beenden Sie das Programm einfach mit `(System/exit 0)`, wenn richtig geraten wurde. Dies ist ein Hack, aber der ist hiermit ausdrücklich freigegeben, um Ihnen viel Kopfzerbrechen zu ersparen.


### Abgabe


Laden Sie den Quelltext Ihres fertigen Programms in Ihr Git-Repository zur Vorlesung hoch. Wählen Sie eine geeignete Verzeichnisstruktur, um auch weitere Lösungen dort ablegen zu können.