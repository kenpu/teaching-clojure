(defmacro infix [code]
  (if (list? code)
    (condp = (count code)
      3 (let [[a op b] code] 
          `(~op (infix ~a) (infix ~b)))
      code)
    code))

(println (infix (1 + 2)))
(println (infix (1 + (3 * 5))))
