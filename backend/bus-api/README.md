# 🚀 Bus Management API - Guía de Pruebas

## ✅ Código Revisado y Limpiado

### 📋 **Patrón Repository Implementado Correctamente:**
- ✅ **Controller** → **Service** → **Repository** → **Database**
- ✅ Inyección de dependencias correcta
- ✅ Separación clara de responsabilidades
- ✅ Interfaces definidas apropiadamente
- ✅ Métodos no utilizados eliminados

### 🏗️ **Estructura Final (Arquitectura por Capas):**
```
📁 controller/          # Endpoints REST
├── BusController.java

📁 service/             # Lógica de negocio  
├── BusService.java     # Interface
└── impl/BusServiceImpl.java

📁 repository/          # Acceso a datos
├── BusRepository.java
└── BrandRepository.java

📁 entity/              # Entidades JPA
├── Bus.java
└── Brand.java

📁 dto/                 # Objetos de transferencia
├── BusDto.java
├── PageBusDto.java
└── ErrorDto.java

📁 mapper/              # Conversión Entity ↔ DTO
└── BusMapper.java

📁 config/              # Configuraciones
├── SecurityConfig.java
├── OpenApiConfig.java
└── GlobalExceptionHandler.java

📁 exception/           # Excepciones personalizadas
├── ResourceNotFoundException.java
└── InvalidParameterException.java
```

## 🚀 **Cómo Ejecutar y Probar**

### 1. **Configurar Base de Datos PostgreSQL:**
```sql
CREATE DATABASE busesdb;
-- El schema.sql y data.sql se ejecutan automáticamente
```

### 2. **Variables de Entorno (Opcional):**
```bash
export SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/busesdb
export SPRING_DATASOURCE_USERNAME=postgres
export SPRING_DATASOURCE_PASSWORD=password
export APP_CORS_ALLOWED_ORIGIN=http://localhost:5173
```

### 3. **Ejecutar la Aplicación:**
```bash
# Desarrollo
mvn spring-boot:run -Dspring-boot.run.profiles=dev

# O simplemente
mvn spring-boot:run
```

### 4. **Credenciales de Autenticación:**
- **Usuario:** `admin`
- **Contraseña:** `admin123`

## 🧪 **Endpoints Disponibles**

### 📋 **GET /bus** - Lista paginada de buses
```bash
curl -u admin:admin123 "http://localhost:8080/bus?page=0&size=10&sort=createdAt,desc"
```

**Parámetros:**
- `page`: Número de página (0-based, default: 0)
- `size`: Tamaño de página (max: 50, default: 10)  
- `sort`: Ordenamiento (default: createdAt,desc)
  - Campos permitidos: `id`, `number`, `plate`, `createdAt`, `active`, `brand.name`

### 🔍 **GET /bus/{id}** - Bus específico
```bash
curl -u admin:admin123 "http://localhost:8080/bus/1"
```

### 🔎 **GET /bus/search/number** - Buscar por número
```bash
curl -u admin:admin123 "http://localhost:8080/bus/search/number?q=BUS&page=0&size=5"
```

### 🔎 **GET /bus/search/plate** - Buscar por placa
```bash
curl -u admin:admin123 "http://localhost:8080/bus/search/plate?q=ABC&page=0&size=5"
```

## 🧪 **Scripts de Prueba Automatizados**

### Windows:
```cmd
test-api.bat
```

### Linux/Mac:
```bash
chmod +x test-api.sh
./test-api.sh
```

## 📊 **Respuesta JSON Ejemplo**

### Lista paginada:
```json
{
  "content": [
    {
      "id": 1,
      "number": "BUS-001",
      "plate": "ABC-123",
      "createdAt": "2023-09-21T10:30:00",
      "features": "Air conditioning, WiFi, USB charging ports, 45 seats",
      "active": true,
      "brandId": 1,
      "brandName": "Volvo"
    }
  ],
  "number": 0,
  "size": 10,
  "totalElements": 15,
  "totalPages": 2,
  "first": true,
  "last": false,
  "empty": false
}
```

### Error 404:
```json
{
  "timestamp": "2023-09-21T10:30:00",
  "status": 404,
  "error": "Not Found",
  "message": "Bus not found with id: 999",
  "path": "/bus/999"
}
```

## 📖 **Documentación Automática**

- **Swagger UI:** http://localhost:8080/swagger-ui
- **OpenAPI JSON:** http://localhost:8080/api-docs

## 🔒 **Seguridad Implementada**

- ✅ HTTP Basic Authentication obligatorio
- ✅ CORS configurado para frontend
- ✅ CSRF deshabilitado (API stateless)
- ✅ Respuestas 401 con WWW-Authenticate header
- ✅ Cache-Control: no-cache en todas las respuestas

## ✨ **Características Implementadas**

- ✅ Paginación y ordenamiento
- ✅ Validaciones de parámetros
- ✅ Búsqueda por texto
- ✅ Manejo global de errores
- ✅ Logs estructurados
- ✅ Documentación automática
- ✅ Base de datos con seeds de ejemplo
- ✅ Arquitectura en capas completa