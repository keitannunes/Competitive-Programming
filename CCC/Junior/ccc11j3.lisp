
(let ((c 2) (A (read)) (B (read)))
  (loop
    (let ((temp (- A B)))
      (when (> B A) (return))
      ;(print temp)
      (setf A B)
      (setf B temp)
      (incf c)
      )
    )
  (print c)
  )

