
# ForoHud

![image](https://github.com/user-attachments/assets/a1d432e8-c742-460c-9723-437bd146b12c)


Este proyecto consiste en una API REST desarrollada con **Spring Boot** para la gestión de un foro. Actualmente, el proyecto está en proceso de desarrollo, y lo que se muestra a continuación corresponde a los módulos y funcionalidades ya implementados.

## Funcionalidades Implementadas

### 1. Gestión de Topicos
- Crear un nuevo topico.
- Listar todos los topicos.
- Obtener un topico por su ID.
- Actualizar un topico.
- Eliminar un topico.

### 2. Asociación con Cursos
Cada topico debe estar asociado a un curso existente en el sistema. Esto asegura que los mensajes del foro esten ordenados correctamente.

---

## Configuración del Proyecto

### Requisitos Previos
- **Java 17**
- **Maven**
- **Base de Datos H2** (configuración incluida para entorno de desarrollo, puedes usar otros motores de db)

### Instalación
1. Clona el repositorio:
   ```bash
   git clone <url-del-repositorio>
   cd ForoAPI
   ```
2. Configura las propiedades de la base de datos en el archivo `application.properties`:
   ```properties
   spring.datasource.url=jdbc:h2:mem:foro
   spring.datasource.username=sa
   spring.datasource.password=
   spring.h2.console.enabled=true
   spring.jpa.hibernate.ddl-auto=update
   ```
3. Ejecuta la aplicación:
   ```bash
   mvn spring-boot:run
   ```
4. Accede a la consola H2 (opcional):
   - URL: `http://localhost:8080/h2-console`
   - JDBC URL: `jdbc:h2:mem:foro`

---

## Estructura del Proyecto

### Paquetes Principales

- `com.challeng2.ForoHud.controller`: Controladores REST para manejar las solicitudes HTTP.
- `com.challeng2.ForoHud.service`: Lógica de negocio.
- `com.challeng2.ForoHud.domain`: Entidades y clases relacionadas con la base de datos.
- `com.challeng2.ForoHud.dto`: Objetos de transferencia de datos (DTO).

---

## Próximos Pasos
- Implementar autenticación y autorización.
- Añadir funcionalidades para las respuestas (tabla relacionada).
- Documentar la API con **Swagger**.



