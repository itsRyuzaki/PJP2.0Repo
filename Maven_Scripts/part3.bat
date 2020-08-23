@ECHO OFF
:: This batch helps to extract & save the build logs to a file instead of console output
ECHO Please wait...copying the logs to file
cd ..
call mvn clean install > ./Maven_Scripts/buildLogs.txt
cd maven_Scripts
ECHO Done! Output saved to buildLogs.txt
PAUSE