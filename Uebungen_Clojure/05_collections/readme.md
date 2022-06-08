# Aufgabenblock 5: Collections


## 1. reduce
Schreiben Sie eine Funktion `prod-reduce`, die eine beliebige Zahl von Werten multipliziert, die ihr als Vektor oder Sequenz übergeben werden. Verwenden Sie für die Implementierung die `reduce`-Funktion und __keine__ Rekursion. 

```clojure
(defn prod-reduce
  "Berechnet das Produkt einer Reihe von Zahlen `zahlen` unter
  Verwendung von reduce."
  [zahlen]
  ; ----> hier Ihr Code <----
)
```



## 2. mapping und cycle
Schreiben Sie eine Funktion `map-cycle`, welche durch eine übergebene Menge von Zahlen wiederholt läuft. Die Übergabe erfolgt als _Vararg-Argument_. Die Zahlen werden dann mal Zwei genommen und es wird jeweils 1 abgezogen (z.B. 5 -> 10 - 1 = 9). Aus dem Ergebnis werden dann n-Werte, gesteuert über den ersten Parameter, zurückgegeben. 

```clojure
(defn map-cycle
  "Erzeugt eine unendliche Sequenz der Zahlen `zahlen`
  und berechnet für jede Zahl deren Doppeltes und zieht 
  1 ab. Vom Ergebnis werden `n` Elemente zurück
  gegeben."
  [n & zahlen]
  ; ----> hier Ihr Code <----
)
```



## 3. take-while
Schreiben Sie eine Funktion `below-zero`, welche einen Vektor oder eine Sequenz übergeben bekommt. Die Funktion soll einen neuen Vektor (oder Sequenz) mit denselben Elementen zurückgeben, diese endet aber vor dem ersten Element das `>= 0` ist. 

```clojure
(defn below-zero
  "Läuft über `data` und gibt die Elemente bis zum ersten
   Auftreten eines Wertes >= 0 zurück."
  [data]
  ; ----> hier Ihr Code <---- 
)
```



## 4. filter
Schreiben Sie eine Funktion `filter-positive`, welche eine Liste oder Sequenz übergeben bekommt. Die Funktion soll eine neue Liste (oder Sequenz) mit denselben Elemente zurückgeben, aber alle Elemente `> 0` ausfiltern. 

```clojure
(defn filter-positive
    "Läuft über `data` und gibt die Elemente, deren Wert < 0 ist zurück."
    [data]
    ; ----> hier Ihr Code <----
)
```



