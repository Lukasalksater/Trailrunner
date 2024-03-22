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
                 echo "posting test"
            }
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
        stage('Run Robot and Post Test') {
            steps {
                sh "python -m robot Selenium"
       
            }

            post {

                always {
                     
                            robot outputPath: 'c:/Users/LukasAlksäter-MT23GB/.jenkins/workspace/Lukas Alksäter/Selenium', 'passThreshold: 80', 'unstableThreshold: 70', 'onlyCritical: false'

                    
                }
            }
        }
    }
}