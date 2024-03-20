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
                echo 'Testing..'
            }
        }
        stage('Post Test') {
            steps {
                echo 'posting....'
            }
        }
        stage('Run Robot and Post Test') {
            steps {
                echo 'roboting....'
            }
        }
    }
}