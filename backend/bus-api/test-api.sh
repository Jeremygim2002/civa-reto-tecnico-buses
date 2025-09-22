#!/bin/bash
# Script para probar la API de Buses
# Requiere curl instalado

BASE_URL="http://localhost:8080"
USER="admin:admin123"

echo "🚀 TESTING BUS API ENDPOINTS"
echo "================================"
echo ""

echo "📋 1. GET /bus - Obtener todos los buses (página 0, tamaño 5)"
curl -u $USER -s "$BASE_URL/bus?page=0&size=5&sort=createdAt,desc" | jq '.' || echo "Error: Verifique que jq esté instalado o use curl sin jq"
echo ""
echo ""

echo "🔍 2. GET /bus/1 - Obtener bus específico por ID"
curl -u $USER -s "$BASE_URL/bus/1" | jq '.' || echo "Error: Verifique que jq esté instalado o use curl sin jq"
echo ""
echo ""

echo "🔍 3. GET /bus/search/number - Buscar buses por número"
curl -u $USER -s "$BASE_URL/bus/search/number?q=BUS&page=0&size=3" | jq '.' || echo "Error: Verifique que jq esté instalado o use curl sin jq"
echo ""
echo ""

echo "🔍 4. GET /bus/search/plate - Buscar buses por placa"
curl -u $USER -s "$BASE_URL/bus/search/plate?q=ABC&page=0&size=3" | jq '.' || echo "Error: Verifique que jq esté instalado o use curl sin jq"
echo ""
echo ""

echo "❌ 5. Prueba sin autenticación (debería fallar con 401)"
curl -s "$BASE_URL/bus" | jq '.' || echo "Error: Verifique que jq esté instalado o use curl sin jq"
echo ""
echo ""

echo "❌ 6. Prueba con ID inexistente (debería fallar con 404)"
curl -u $USER -s "$BASE_URL/bus/999" | jq '.' || echo "Error: Verifique que jq esté instalado o use curl sin jq"
echo ""
echo ""

echo "❌ 7. Prueba con parámetros inválidos (debería fallar con 400)"
curl -u $USER -s "$BASE_URL/bus?page=0&size=100&sort=invalid,desc" | jq '.' || echo "Error: Verifique que jq esté instalado o use curl sin jq"
echo ""
echo ""

echo "✅ Pruebas completadas!"
echo "🌐 Swagger UI: $BASE_URL/swagger-ui"
echo "📄 API Docs: $BASE_URL/api-docs"