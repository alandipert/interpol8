(ns interpol8
  "Ruby-style string interpolation"
  (:use [clojure.walk :only (postwalk)])
  (:require [clojure.string :as string]))

(defmacro i
  "Interpolates Clojure data surrounded by #{} in the template
string:

  Example:

  (let [x 10]
    \"x is #{x}\")
  ;=> \"x is 10\""
  [template]
  {:pre [(string? template)]}
  (let [re #"#\{(.*?)\}"]
    (if-let [matches (re-seq re template)]
      `(format ~(string/replace template re "%s")
               ~@(map (comp read-string second) matches))
      template)))

(defmacro interpolating
  "Walks body and interpolates all strings.

  Example:

  (interpolating
    (def x 10)
    (let [y 20]
      \"x is #{x} and y is #{y}\"))"
  [& body]
  `(do ~@(postwalk #(if (string? %) `(i ~%) %) body)))