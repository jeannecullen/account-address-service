pipeline {
      agent any


      stages {
         stage('Build') {
            steps {
               sh 'gradle clean compileJava'
               sh './gradlew clean assemble'
            }
         }
         stage('Deploy'){
                    steps{
                        sh 'cf push account-address-service -p ./build/libs/account-address-service-0.0.1-SNAPSHOT.jar'
                    }
         }
      }
  }