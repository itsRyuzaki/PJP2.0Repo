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
            }
        }
         stage('Unit-Tests'){
            steps{
                echo "Building the project";
            }
        }
    }
}