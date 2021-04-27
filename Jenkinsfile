pipeline {
    agent any
    stages {
        stage('Build Backend') {
            steps {
                shell 'mvn clean package -DskipTests=true'
            }
        }
        stage('Unit Tests') {
            steps {
                shell 'mvn test'
            }
        }
        stage ('Sonar Analysis') {
            environment {
                scannerHome = tool 'SONAR_SCANNER'
            }
            steps {
                withSonarQubeEnv('SONAR_LOCAL') {
                    shell "${scannerHome}/bin/sonar-scanner"
                }
            }
        }
        
    }
}

