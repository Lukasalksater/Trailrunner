pipeline {
    agent any


    stages {
        stage('Build') {
            steps {

                sh "mvn clean"
                sh "mvn compile"
            }
        }
        stage('Test') {
            steps {
                
                sh "mvn test"          
            }

        }

        stage('Post Test'){
            steps {
                script {
                 post {
                    always{
                     jacoco (
                        execPattern: 'target/*.exec',
                        classPattern: 'target/classes',
                        sourcePattern: 'src/main/java',
                        exclusionPattern: 'src/test'
                    )
                    junit '**/TEST*.xml'
                }
            }

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