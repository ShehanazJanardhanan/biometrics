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
		sh 'mvn snyk:test -fn'
		}
      } 
  }
}
