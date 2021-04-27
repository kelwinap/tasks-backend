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
    }
}