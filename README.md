# Proceso de Formación - Iglesia Cristiana Fuente de Vida

## Descripción

Este proyecto es una aplicación web destinada a optimizar y centralizar el proceso de formación de la Iglesia Cristiana Fuente de Vida en Sogamoso, Boyacá. La aplicación facilita la gestión de inscripciones, control de asistencias, envío de contenidos y agendamientos, mejorando los tiempos y la experiencia de los usuarios.

## Características

- **Gestión de Usuarios**: Administración de diferentes tipos de usuarios (Administradores, Maestros, Estudiantes) con roles y permisos específicos.
- **Inscripciones**: Permite el registro de nuevos estudiantes y la administración de los inscritos.
- **Asistencia**: Registro y validación de asistencias para diferentes modalidades de clase (Presencial, Virtual, A Distancia).
- **Material de Estudio**: Gestión y descarga de contenidos en formato PDF.
- **Notificaciones**: Envío automático de notificaciones a los diferentes usuarios.

## Tecnologías Utilizadas

- **Backend**: Java con Spring Boot
- **Frontend**: Thymeleaf (inicialmente Angular, pero se decidió por Thymeleaf debido a la simplicidad y rapidez de implementación)
- **Base de Datos**: MySQL
- **Seguridad**: Spring Security con BCrypt para el almacenamiento seguro de contraseñas
- **Metodología**: SCRUM

## Estructura del Proyecto

- **Arquitectura de Tres Capas**:
  - **Capa de Presentación**: Thymeleaf
  - **Capa de Negocio**: Spring Boot Services
  - **Capa de Datos**: Repositorios JPA

## Instalación

1. Clona el repositorio:
    ```bash
    git clone https://github.com/tu_usuario/proyecto-formacion.git
    ```

2. Navega al directorio del proyecto:
    ```bash
    cd proyecto-formacion
    ```

3. Configura la base de datos MySQL y actualiza `application.properties` con tus credenciales:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/tu_base_de_datos
    spring.datasource.username=tu_usuario
    spring.datasource.password=tu_contraseña
    spring.jpa.hibernate.ddl-auto=update
    ```

4. Construye y ejecuta la aplicación:
    ```bash
    ./mvnw spring-boot:run
    ```

## Configuración Inicial

- **Roles y Usuarios**: Se recomienda crear los roles (ADMIN, TEACHER, STUDENT) y asignar usuarios a estos roles en la base de datos.

## Uso

1. **Acceder a la aplicación**:
    - Abre un navegador web y navega a `http://localhost:8080`

2. **Login**:
    - Los administradores, maestros y estudiantes pueden iniciar sesión y acceder a sus respectivos paneles.

3. **Administración**:
    - Los administradores pueden gestionar inscripciones, asistencias, contenidos y usuarios.

4. **Maestros**:
    - Los maestros pueden registrar y validar asistencias, así como revisar y retroalimentar talleres.

5. **Estudiantes**:
    - Los estudiantes pueden acceder a los materiales de estudio y registrar su asistencia.

## Desarrollo

### Diagramas de Caso de Uso

- **Administrador**:
  - Gestión de lecciones, maestros, estudiantes y contenidos.
  - Programación y agendamiento de clases.

- **Maestro**:
  - Registro y validación de asistencias.
  - Revisión y retroalimentación de talleres.

- **Estudiante**:
  - Registro de usuario y acceso a materiales de estudio.
  - Registro de asistencia a clases.


## Contacto

Para cualquier pregunta o sugerencia, por favor contacta a [tu_nombre] en [tu_email@dominio.com].

