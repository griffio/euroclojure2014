(defproject euroclojure "0.1.0-SNAPSHOT"
  :description "Euroclojure 2014 sample codes"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [ring-middleware-format "0.5.0"]
                 [metosin/compojure-api "0.21.0"]
                 [metosin/ring-http-response "0.6.2"]
                 [metosin/ring-swagger-ui "2.1.5-M2"]]
  :uberjar-name "server.jar"
  :profiles {:uberjar {:resource-paths ["swagger-ui"]}
             :simple {:ring {:handler euroclojure.simple/app}}
             :simple-api {:ring {:handler euroclojure.simple-api/app}}
             :swagger-api {:ring {:handler euroclojure.swagger-api/app}}
             :dev {:dependencies [[javax.servlet/servlet-api "2.5"]]
                   :plugins [[lein-ring "0.9.4"]]}}
  :aliases {"simple"      ["with-profile" "simple" "ring" "server"]
            "simple-api"  ["with-profile" "simple-api" "ring" "server"]
            "swagger-api" ["with-profile" "swagger-api" "ring" "server"]})
