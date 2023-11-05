pipeline {
    agent any

    stages {
        stage('build') {
            steps {
                // Replace this with your build commands
                sh 'echo "Building the application"'
            }
        }

        stage('test') {
            steps {
                // Replace this with your test commands
                sh 'echo "Running tests"'
            }
        }

        stage('deploy') {
            steps {
                // Replace this with your deployment commands
                sh 'echo "Deploying the application"'
            }
        }
    }

    post {
        success {
            // Actions to perform if the pipeline succeeds
            echo 'Pipeline succeeded!'
        }
        failure {
            // Actions to perform if the pipeline fails
            echo 'Pipeline failed!'
        }
    }
}
