(setf X (read)) ; Start and curr
(setf Y (read))
(loop
  (when (> X Y) (return))
  (format T "All positions change in year ~d~%" X)
  (setf X (+ X 60)))
