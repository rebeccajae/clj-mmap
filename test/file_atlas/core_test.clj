(ns file-atlas.core-test
  (:require [clojure.test :refer :all]
            [file-atlas :refer :all]
            [clojure.java.io :as io]))

(defn file-generator [f]
  (spit "test.txt" "Hello, World!")
  (f)
  (io/delete-file "test.txt"))

(use-fixtures :once file-generator)

(deftest read-bytes
  (with-open [file (get-mmap "test.txt")]
    (let [should-be-hello (get-bytes file 0 5)
          hello-bytes (.getBytes "Hello")
          hello-decoded (String. should-be-hello "UTF-8")]
      (is (= (seq should-be-hello) (seq hello-bytes)))
      (is (= hello-decoded "Hello")))))

(deftest write-bytes
  (with-open [file (get-mmap "test.txt" :read-write)]
    (let [steve-bytes (.getBytes "Steve")]
      (put-bytes file steve-bytes 7)
      (is (= (slurp "test.txt") "Hello, Steve!")))))
