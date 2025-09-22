@echo off
REM Script para probar la API de Buses en Windows
REM Solo los 2 endpoints requeridos

set BASE_URL=http://localhost:8080
set USER=admin:admin123

echo 🚀 TESTING BUS API - SOLO 2 ENDPOINTS REQUERIDOS
echo ===================================================
echo.

echo 📋 1. GET /bus - Obtener todos los buses (página 0, tamaño 5)
curl -u %USER% -s "%BASE_URL%/bus?page=0&size=5&sort=createdAt,desc"
echo.
echo.

echo 🔍 2. GET /bus/1 - Obtener bus específico por ID
curl -u %USER% -s "%BASE_URL%/bus/1"
echo.
echo.

echo ❌ 3. Prueba sin autenticación (debería fallar con 401)
curl -s "%BASE_URL%/bus"
echo.
echo.

echo ❌ 4. Prueba con ID inexistente (debería fallar con 404)
curl -u %USER% -s "%BASE_URL%/bus/999"
echo.
echo.

echo ✅ Pruebas completadas!
echo 📊 API corriendo en: %BASE_URL%

pause