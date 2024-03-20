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
                dir('c:/Users/LukasAlksäter-MT23GB/.jenkins/workspace/Lukas Alksäter7TrailrunnerProject/src/test/java/se/iths')
                sh "mvn test"          
            }

        }

        stage('Post Test'){
            
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
        stage('Run Robot and Post Test') {
            steps {
                echo 'roboting....'
            }
        }
    }
}