@ECHO OFF
:: This batch file shows a table of available phase, plugins and goals.
ECHO Please wait....tabulating the list.
cd ..
call mvn fr.jcgay.maven.plugins:buildplan-maven-plugin:list
ECHO Done!
cd Maven_Scripts
PAUSE
