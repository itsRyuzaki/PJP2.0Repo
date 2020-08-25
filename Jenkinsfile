pipeline{
    agent any
    stages{
        stage('Git-Checkout'){
            steps{
                echo "Checking out from git repo";
                git branch: 'Week2-Assignment1', url:"https://github.com/itsRyuzaki/PJP2.0Repo.git"
            }
        }
        stage('Build'){
            steps{
                echo "Building the project";
	        dir('Batch_Files') {
			bat 'build.bat'
		}		
            }
        }
         stage('Unit-Tests'){
            steps{
                echo "Running Junit-Tests";
		dir('Batch_Files') {
			bat 'tests.bat'
		}
            }
        }
         stage('Install'){
            steps{
                echo "Installing the maven project";
		dir('Batch_Files') {
			bat 'install.bat'
		}
            }
        }
    }
}
