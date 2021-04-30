pipeline {
    agent any
    tools {
        maven 'Maven'
        jdk 'JDK 9'
    }

    stages {
        stage('Build') {

            steps {
                            sh '''
                                echo "PATH = ${PATH}"
                                echo "M2_HOME = ${M2_HOME}"
                            '''
                            sh 'mvn -B -DskipTests clean package'
                   }

        }
    }
}
