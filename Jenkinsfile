pipeline{
    agent any
    stages{
        stage('Git-Checkout'){
            steps{
                echo "Checking out from git repo";
                git "https://github.com/itsRyuzaki/PJP2.0Repo.git"
            }
        }
        stage('Build'){
            steps{
                echo "Building the project";
		bat 'Batch_Files/checkVersion.bat'
            }
        }
         stage('Unit-Tests'){
            steps{
                echo "Running Junit-Tests";
		sh 'mvn test'
            }
        }
         stage('Install'){
            steps{
                echo "Installing the maven project";
		sh 'mvn install'
            }
        }
    }
}