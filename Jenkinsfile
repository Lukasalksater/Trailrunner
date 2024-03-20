pipeline {
    agent any


    stages {
        stage('Build') {
            steps {
                sh "mvn compile"
            }
        }
        stage('Test') {
            steps {
                sh "mvn test"
            }
        }
        stage('Post Test') {
           post {
                always {
                    junit '**/TEST*.xml'
                }
           }
        }
        stage('Run Robot and Post Test') {
            steps {
                echo 'roboting....'
            }
        }
    }
}