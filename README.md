# interpol8

`interpol8` is a small library for doing Ruby-style string
interpolation.

[![Build Status](https://secure.travis-ci.org/alandipert/interpol8.png?branch=master)](http://travis-ci.org/alandipert/interpol8)

## Usage

Add this to your `project.clj` if you're using [Leiningen](https://github.com/technomancy/leiningen/):

```clojure
[alandipert/interpol8 "0.0.2"]
```

Then, in the namespace you want string interpolation in:

```clojure
(ns your-ns
  (:use [interpol8 :only (interpolating)]))

(interpolating
  (def foo 10)
  (defn doit []
    (let [bar 20]
      "foo is #{foo} and bar is #{bar}")))

(println (doit)) ; "foo is 10 and bar is 20"
```

## License

Copyright (C) 2012 Alan Dipert

Distributed under the Eclipse Public License, the same as Clojure.
