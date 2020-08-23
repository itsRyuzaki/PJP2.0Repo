@ECHO OFF
:: This batch file helps to use local copy of maven within the project.
ECHO Please wait...installing the JAR in local repository
cd ..
call mvn install:install-file -Dfile="E:\e-learning\Practical\PJP2\dateTimeCalculator\target\dateTimeCalculator-0.0.1-SNAPSHOT.jar" -DgroupId="com.sapient.week2" -DartifactId="dateTimeCalculator" -Dversion="0.0.1-SNAPSHOT" -Dpackaging="jar"
cd maven_Scripts
ECHO Done! Installed in the local repo.
PAUSE