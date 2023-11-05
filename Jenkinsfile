pipeline {
    agent any

    stages {
        stage('build') {
            steps {
                // Replace this with your build commands
                sh 'echo "Building the application - test"'
                sh 'mvn clean install'
            }
        }

        stage('test') {
            steps {
                // Replace this with your test commands
                sh 'echo "Running tests - test"'
                sh 'mvn test"'
            }
        }

        stage('deploy') {
            steps {
                // Replace this with your deployment commands
                sh 'echo "Deploying the application - test"'
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
