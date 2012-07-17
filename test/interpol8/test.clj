(ns interpol8.test
  (:use clojure.test
        interpol8))

(deftest lexical-interpolation
  (testing "that let bindings interpolate correctly")
  (let [x 10]
    (is (= "x is totally 10" (i "x is totally #{x}")))))


(deftest var-interpolation
  (testing "that vars interpolate correctly")
  (def y 10)
  (is (= "y is 10, for reals" (i "y is #{y}, for reals"))))

(deftest interpolating-works
  (interpolating
   (def z 100)
   (let [x 10
         y 20]
     (is (= "1001020" "#{z}#{x}#{y}")))))