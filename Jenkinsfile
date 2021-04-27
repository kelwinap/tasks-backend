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
                    shell "${scannerHome}/bin/sonar-scanner -e -Dsonar.projectKey=DeployBack -Dsonar.host.url=http://localhost:9000 -Dsonar.login=e14e6fffdfa5d3530860cac3c7c5a0a5faea2b35 -Dsonar.java.binaries=target -Dsonar.coverage.exclusions=**/.mvn/**,**/src/test/**,**/model/**,**Application.java"
                }
            }
        }
        
    }
}

