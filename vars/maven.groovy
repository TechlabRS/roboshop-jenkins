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

      stage('Code Compile') {
        steps {
          sh 'echo Code Compile'
        }
      }

      stage('Code Quality') {
        steps {
          sh 'echo Code QUality'
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