@echo off
echo ================================
echo   Bus API - Compilacion y Ejecucion
echo ================================

echo.
echo [1/4] Descargando Maven...
if not exist "apache-maven" (
    powershell -Command "Invoke-WebRequest -Uri 'https://archive.apache.org/dist/maven/maven-3/3.9.6/binaries/apache-maven-3.9.6-bin.zip' -OutFile 'maven.zip'"
    powershell -Command "Expand-Archive -Path 'maven.zip' -DestinationPath '.'"
    ren apache-maven-3.9.6 apache-maven
    del maven.zip
)

echo.
echo [2/4] Configurando Maven...
set MAVEN_HOME=%CD%\apache-maven
set PATH=%MAVEN_HOME%\bin;%PATH%

echo.
echo [3/4] Compilando proyecto...
call apache-maven\bin\mvn.cmd clean compile

echo.
echo [4/4] Ejecutando aplicacion...
call apache-maven\bin\mvn.cmd spring-boot:run

pause