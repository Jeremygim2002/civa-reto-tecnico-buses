# API de Gestión de Buses

API REST para gestionar información de buses desarrollada con Spring Boot.

## 🏗️ Estructura del Proyecto

```
backend/bus-api/
├── src/main/java/com/civa/retotecnico/buses/bus_api/
│   ├── controller/     # Controladores REST
│   ├── service/        # Lógica de negocio
│   ├── repository/     # Acceso a datos
│   ├── entity/         # Entidades JPA
│   ├── dto/           # Objetos de transferencia de datos
│   ├── mapper/        # Conversores Entity ↔ DTO
│   └── config/        # Configuraciones
└── src/main/resources/
    ├── application.properties
    ├── data.sql       # Datos de prueba
    └── schema.sql     # Esquema de BD
```

## 🏛️ Arquitectura

**Patrón de Capas (Layered Architecture)**

```
┌─────────────────┐
│   Controller    │ ← Endpoints REST
├─────────────────┤
│    Service      │ ← Lógica de negocio
├─────────────────┤
│   Repository    │ ← Acceso a datos
├─────────────────┤
│    Entity       │ ← Modelo de datos
└─────────────────┘
```

**Componentes principales:**
- **Controller**: Maneja peticiones HTTP
- **Service**: Procesa lógica de negocio 
- **Repository**: Consultas a base de datos
- **Mapper**: Convierte Entity ↔ DTO
- **DTO**: Datos para la API

## 🎯 Patrones de Diseño

- **Repository Pattern**: Abstrae acceso a datos
- **DTO Pattern**: Separa modelo de datos del API
- **Dependency Injection**: Inyección de dependencias con Spring
- **Mapper Pattern**: Conversión de objetos

## 🚀 Ejecución

```bash
cd backend/bus-api
./mvnw.cmd spring-boot:run
```

**URL**: `http://localhost:8080`

## 🔐 Autenticación

**HTTP Basic Authentication**
- Usuario: `admin`
- Contraseña: `admin123`

## 📡 API Endpoints

### 1. Obtener todos los buses
```http
GET /bus?page=0&size=10&sort=createdAt,desc
Authorization: Basic admin:admin123
```

### 2. Obtener bus por ID
```http
GET /bus/{id}
Authorization: Basic admin:admin123
```

### Pruebas de API con Postman:
1. **Authorization** → Basic Auth
2. **Username**: `admin`
3. **Password**: `admin123`
4. **GET** `http://localhost:8080/bus`

## 🛠️ Tecnologías

- **Java 21**
- **Spring Boot 3.5.6**
- **Spring Data JPA**
- **Spring Security**
- **PostgreSQL** (Supabase)
- **Maven**

## 📊 Base de Datos

**PostgreSQL en Supabase:**
- Host: `aws-1-us-east-2.pooler.supabase.com:6543`
- Base de datos: `postgres`
- Usuario: `postgres.erauybasscflufufenkc`

**Modelo relacional:**
- `brand` (marcas): id, name
- `bus` (buses): id, number, plate, features, active, created_at, brand_id

**Datos de prueba**: 15 buses con 5 marcas (Volvo, Scania, Fiat, Mercedes-Benz, Man)