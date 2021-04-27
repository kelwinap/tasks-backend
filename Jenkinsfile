pipeline {
    agent any
    stages {
        stage('Build Backend') {
            steps {
                shell 'mvn clean package -DskipTests=true'
            }
        }
    }
}