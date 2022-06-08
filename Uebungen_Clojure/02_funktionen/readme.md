# Aufgabenblock 2: Clojure Funktionen


## 1. Multi-Arity-Funktion
Schreiben Sie eine Funktion `my-average`, welche das arithmetische Mittel von 2, 4 oder 6 Zahlen bestimmen kann. Verwenden Sie __keine__ Varag-Funktion, sondern programmieren Sie eine _Multi-Arity-Funktion_.

```clojure
(defn my-average
; ----> hier Ihr Code <----
)
```



## 2. Funktion als Rückgabewert
Schreiben Sie eine Funktion `plus-n-fn`, welche einen Parameter `n` nimmt und eine neue Funktion zurückliefert, die ebenfalls einen Parameter akzeptiert. Diese neue Funktion addiert den Übergabewert zu `n`. 

```clojure
(defn plus-n-fn
  "Liefert eine Funktion zurück, die genau ein
  Argument nimmt und dieses Argument zu
  `n` addiert."
  [n]
  ; ----> hier Ihr Code <----
  
)
```



## 3. apply und Funktionen als Übergabewerte
Schreiben Sie eine Funktion `triple-apply`, der man eine Funktion und beliebig viele weitere Argumente übergeben kann. Die Funktion wird dreimal mit den Argumenten ausgeführt und die Ergebnisse werden addiert, bevor sie zurückgegeben werden. 

```clojure
(defn triple-apply
  "Wendet die Funktion `f` dreimal hintereinander auf die Argumente 
  `args` an und gibt die Summe der Ergebnisse zurück."
  [f & args]
  ; ----> hier Ihr Code <----
)
```


## 4. Vor- und Nachbedingung
Gegeben Sie die folgende Funktion `sqrt`. Versehen Sie die Funktion mit einer Vor- und Nachbedingung, um den Aufruf mit ungültigen Werten (`n <= 0`) und auf einen positiven Rückgabewert (`> 0`) zu testen. 

```clojure
(defn sqrt [n]
  ; ----> hier Ihr Code <----
  (Math/sqrt n))
```



