pipeline {
    agent any


    stages {
        stage('Build') {
            steps {
                dir ('c:/Users/LukasAlksäter-MT23GB/.jenkins/workspace/Lukas Alksäter/TrailrunnerProject/src/test/java/se/iths')
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
                scripts (
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

                )
            }
           
        }
        stage('Run Robot and Post Test') {
            steps {
                echo 'roboting....'
            }
        }
    }
}