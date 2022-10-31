(defproject com.tradeswell/clostache "1.6.0-SNAPSHOT"
  :min-lein-version "2.0.0"
  :description "{{ mustache }} for Clojure"
  :url "http://github.com/fhd/clostache"
  :license {:name "GNU Lesser General Public License 2.1"
            :url "http://www.gnu.org/licenses/lgpl-2.1.txt"
            :distribution :repo}
  :dependencies [[org.clojure/clojure "1.11.1"]]
  :profiles {:dev {:dependencies [[org.clojure/data.json "2.4.0"]
                                  [jline/jline "3.0.0.M1"]]
                   :resource-paths ["test-resources"]}
             :1.11 {:dependencies [[org.clojure/clojure "1.11.1"]]}}

  :release-tasks [["vcs" "assert-committed"]
                  ["change" "version"
                   "leiningen.release/bump-version" "release"]
                  ["vcs" "commit"]
                  ["vcs" "tag" "--no-sign"]
                  ["deploy"]]

  :repositories ^:replace [["snapshots" {:url "https://tradeswell.jfrog.io/artifactory/tw-maven-snapshots-only"
                                         :username [:env/jfrog_user :gpg]
                                         :password [:env/jfrog_access_token :gpg]}]
                           ["releases" {:url "https://tradeswell.jfrog.io/artifactory/tw-maven"
                                        :username [:env/jfrog_user :gpg]
                                        :password [:env/jfrog_access_token :gpg]
                                        :sign-releases false}]]

  :aliases {"all" ["with-profile" "dev:dev,1.11"]}
  :global-vars {*warn-on-reflection* true})
