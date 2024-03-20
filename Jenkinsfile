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
                scripts {
                 post {
                    always{
                     jacoco (
                        execPattern: 'target/*.exec',
                        classPattern: 'target/classes',
                        sourcePatern: 'src/main/java',
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