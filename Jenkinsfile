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
        stage('Sonar Analysis') {
            environment {
                scannerHome - tool 'SONAR_SCANNER'
            }
            steps {
                withSonarQubeEnv('SONAR_LOCAL') {
                    shell "${scannerHome}/bin/sonar-scanner -e -Dsonar.projectKey=DeployBack -Dsonar.host.url=http://localhost:9000 -Dsonar.login=9aff70a285e943b4b8e39a49bfa1a5196b23a81b -Dsonar.java.binaries=target -Dsonar.coverage.exclusions=**/mvn/**,**/model/**"
                }
            }
        }
        
    }
}

