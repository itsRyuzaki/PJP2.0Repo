@ECHO OFF
:: This batch file makes maven work without internet
ECHO Please wait...fetching files from local repository
cd ..
call mvn dependency:go-offline
call mvn clean install -o
cd maven_Scripts
ECHO Done! 
PAUSE