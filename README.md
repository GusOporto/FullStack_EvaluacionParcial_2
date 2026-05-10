Desarrollo Fullstack Evaluacion Parcial 2

# Sistema de Gestión de RRHH - Microservicio de Colaboradores

### Descripción del Proyecto:   
Este proyecto forma parte de una arquitectura distribuida orientada a la gestión de capital humano. Su objetivo principal es administrar la información de los Colaboradores y sus relaciones (con sucursales,Regiones, Comunas,etc.), asegurando la integridad referencial y aplicando reglas de negocio requeridas.


### Integrantes del Equipo

**Gustavo Oporto:**   
- Desarrollo de clases Colaborador, Región, Comuna y Sucursal.
- Implementación de ScriptSQL para poblar tablas mediante archivo data.sql.

**Benjamin Saavedra:**   
- Desarrollo de clases Cargo…

**Krishna Benimelis:**   
- Desarrollo de clases Area…

## Funcionalidades Implementadas

### Siguiendo las convenciones REST y el patrón CSR:

- **CRUD Completo:** Gestión de Colaboradores y  Sucursales con persistencia real en MySQL.   
- **Búsquedas Avanzadas:** Endpoints semánticos para filtrar a los Colaboradores por RUN, Sucursal, Comuna y Región.   
- **Validación de Datos:** Implementación de Bean Validation (JSR 380) para asegurar la integridad de RUNs, correos y fechas.   
- **Manejo de Errores:** Sistema centralizado de excepciones mediante @ControllerAdvice para respuestas HTTP coherentes.   
- **Trazabilidad:** Logs estructurados con SLF4J en todas las capas del microservicio.   

## Tecnologías Utilizadas

- Java 17 y Spring Boot 3.x.   
- Spring Data JPA / Hibernate para la persistencia real.
- MySQL como motor de base de datos relacional.
- Lombok para la reducción de código boilerplate.
- Maven para la gestión de dependencias.

## Requisitos Previos e Instalación

1. **Base de Datos:** Crear una base de datos en MySQL llamada **db_rrhh** (el repositorio cuenta con **createDatabaseIfNotExist=true** en **application.properties** para crear la base de datos si no existe).
2. **Configuración:** Ajustar el archivo **src/main/resources/application.properties** con tus credenciales de MySQL. **(el archivo viene con las credenciales por defecto).**
3. **Ejecución**  
4. **Poblado Inicial:** El sistema utiliza un archivo **data.sql** que se ejecuta automáticamente al iniciar (se ha agregado **spring.sql.init.mode=always** en **application.properties** para cargar las tablas antes de ser pobladas).

## Arquitectura de Código

### El proyecto respeta estrictamente el patrón Controller-Service-Repository (CSR):   
- **Controller:** Orquesta las solicitudes **REST** y maneja los **ResponseEntity.**   
- **Service:** Contiene la lógica de negocio y las transformaciones a **DTOs.**   
- **Repository:** Gestiona el acceso a datos mediante **JpaRepository** e incluye **querys personalizadas.**   
- **Model/Entity:** Define la estructura relacional y las restricciones de integridad.  
