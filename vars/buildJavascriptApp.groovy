def call(Map config=[:], Closure body) {
    node {
        git url: "https://github.com/sudhav29/Shared-lib-example"
        stage("Install") {
            sh "npm install"
        }
        stage("Test") {
            sh "npm test"
        }
        stage("Deploy") {
            if (config.deploy) {
                sh "npm publish"
            }
        }
        body()
    }
}