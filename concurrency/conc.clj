(def total (ref 0))

(defn long-print [n interval message]
  (dotimes [_ n]
    (println message)
    (Thread/sleep interval))
  (dosync 
    (let [result (* n (count message))]
      (alter total + result))))

(let [t1 (future (long-print 10 200 "hello"))
      t2 (future (long-print 5  300 "world"))]
  (deref t1)
  (deref t2)
  (println @total))

