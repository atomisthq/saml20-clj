(defproject atomist/saml20-clj "0.1.14-SNAPSHOT"
  :description "Basic SAML 2.0 library for SSO."
  :url "https://github.com/k2n/saml20-clj"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :source-paths ["src"]
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [clj-time "0.11.0"]
                 [ring "1.4.0"]
                 [org.apache.santuario/xmlsec "2.0.4"]
                 [compojure "1.5.0"]
                 [org.opensaml/opensaml "2.6.4"]
                 [org.clojure/data.xml "0.0.7"]
                 [org.clojure/data.codec "0.1.0"]
                 [org.clojure/data.zip "0.1.1"]
                 [org.vlacs/helmsman "1.0.0-alpha5"]]
  :pedantic :warn
  :profiles {:dev {:source-paths ["dev" "test"]
                   :dependencies [[org.clojure/tools.namespace "0.2.10"]
                                  [org.clojure/tools.nrepl "0.2.3"]
                                  [hiccup "1.0.5"]
                                  [http-kit "2.1.18"]]}}

  :repositories ^:replace [["clojars" {:url "https://clojars.org/repo"}]
                           ["central" {:url "https://repo1.maven.org/maven2/" :snapshots false}]
                           ["releases" {:url "https://sforzando.jfrog.io/sforzando/libs-release-local"
                                        :username [:gpg :env/mvn_artifactorymavenrepository_user]
                                        :password [:gpg :env/mvn_artifactorymavenrepository_pwd]}]
                           ["plugins" {:url "https://sforzando.jfrog.io/sforzando/plugins-release"
                                       :username [:gpg :env/mvn_artifactorymavenrepository_user]
                                       :password [:gpg :env/mvn_artifactorymavenrepository_pwd]}]]

  :release-tasks [["vcs" "assert-committed"]
                  ["change" "version" "leiningen.release/bump-version" "release"]
                  ["vcs" "commit"]
                  ["vcs" "tag" "--no-sign"]
                  ["change" "version" "leiningen.release/bump-version"]
                  ["vcs" "commit"]
                  ["vcs" "push"]])
