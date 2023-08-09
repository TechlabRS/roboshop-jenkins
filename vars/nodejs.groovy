def call() {
  pipeline {

    agent {
      node {
        label 'workstation'
      }
    }

    options {
      ansiColor('xterm')
    }


    stages {

      stage('Code Quality') {
        steps {
          sh 'ls -l'
          sh 'sonar-scanner -Dsonar.projectKey=${component} -Dsonar.host.url=http://172.31.85.185:9000 -Dsonar.login=admin -Dsonar.password=admin!1'
        }
      }

      stage('Unit Test Cases') {
        steps {
          sh 'echo Unit tests'
        }
      }

      stage('CheckMarx SAST Scan') {
        steps {
          sh 'echo Checkmarx Scan'
        }
      }

      stage('CheckMarx SCA Scan') {
        steps {
          sh 'echo Checkmarx SCA Scan'
        }
      }


    }

    post {
      always {
        cleanWs()
      }
    }

  }


}
