pipeline {
  agent any
  tools { 
        maven 'Maven_4_14_2'  
    }
   stages{
	    stage('CompileandRunSonarAnalysis') {
		    steps {	
			sh 'mvn clean verify sonar:sonar -Dsonar.projectKey=biometrics -Dsonar.organization=biometrics -Dsonar.host.url=https://sonarcloud.io -Dsonar.login=bdf6bf2ccd5923404b5ad33c562716c3f173ebda'
				}
	      } 
	     stage('RunSCAAnalysisUsingSnyk') {
		    steps {
			    withCredentials([string(credentialsId:'SNYK_TOKEN',variable:'SNYK_TOKEN')]) {
			     sh 'mvn snyk:test -fn'
			    }
			}
	      } 
	   
	   stage('Build') {
		steps {
			withDockerRegistry([credentialsId:"biometrics2022",url:'']) {
				script {
					app = docker.build("asg")
				}
			}

		}
	   }
	   stage('Push') {
		steps {
			script {
				docker.withRegistry('AWS ECR URL', 'ecr:us-west-2:aws-credentials') {
					app.push("latest")
				}
			 }
		 }
	  }
   }   
}
