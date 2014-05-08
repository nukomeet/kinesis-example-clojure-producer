(ns kinesis-example-clojure-producer.core
  (:require [amazonica.aws.kinesis :as k]))

(defn uuid []
  (str (java.util.UUID/randomUUID)))

(defn now [] (java.util.Date.))

(defn put []
  (let [data {:name "any data"
              :created_at (now)}]
    (k/put-record "kinesis_stream" data uuid)))

(defn -main
  []
  (loop [x 0]
    (when (< x 1000)
      (do (println x)
        (put)
        (recur (inc x))))))
