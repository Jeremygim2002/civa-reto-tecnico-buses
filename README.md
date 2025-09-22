# Sistema de Gestión de Buses

API REST para gestionar buses con frontend React.

## Estructura del Proyecto

```
backend/bus-api/
├── src/main/java/com/civa/retotecnico/buses/bus_api/
│   ├── controller/     # Controladores REST
│   ├── service/        # Lógica de negocio
│   ├── repository/     # Acceso a datos
│   ├── entity/         # Entidades JPA
│   ├── dto/           # DTOs
│   ├── mapper/        # Mappers Entity ↔ DTO
│   └── config/        # Configuraciones
└── frontend/
    ├── src/
    │   ├── components/    # Componentes React
    │   ├── services/      # API calls
    │   ├── types/         # TypeScript types
    │   └── config/        # Constantes
    └── package.json
```

## Arquitectura

**Patrón de Capas (Backend)**
- Controller → Service → Repository → Entity
- DTO Pattern para transferencia de datos
- Mapper Pattern para conversiones
- Repository Pattern para acceso a datos

## Tecnologías

**Backend:**
- Java 21
- Spring Boot 3.5.6
- Spring Data JPA
- Spring Security
- PostgreSQL (Supabase)
- Maven

**Frontend:**
- React 18
- TypeScript
- Vite
- Tailwind CSS v4

## Instalación y Ejecución

### Backend
```bash
cd backend/bus-api
./mvnw.cmd spring-boot:run
```

### Frontend
```bash
cd frontend
npm install
npm run dev
```

## Endpoints

**Base URL:** `http://localhost:8080`

- `GET /bus` - Lista buses (paginado)
- `GET /bus/{id}` - Bus por ID

**Autenticación:** Basic Auth (`admin` / `admin123`)