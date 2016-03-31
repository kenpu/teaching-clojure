(defn long-print [n interval message]
  (dotimes [_ n]
    (println message)
    (Thread/sleep interval))
  (* n (count message)))

(def c1 (future (long-print 10 200 "Hello")))
(def c2 (future (long-print 5  300 "hello world")))

(println (+ @c1 @c2))

(println "================")

