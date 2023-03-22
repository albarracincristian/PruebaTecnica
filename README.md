# Desafío Técnico - BeClever

_La empresa Clever Business cuenta con 3 sucursales distribuidas en diferentes países: Argentina, Brasil y España. En el último tiempo está teniendo problemas para el control del personal que ingresa y egresa día a día en sus instalaciones, por lo que decide contratar un sistema el cual le permita tener un control total del ingreso/egresos.
Para esto la empresa decide contratar tus servicios. Como encargado del desarrollo tu misión es crear una capa de servicios (API REST) que puedan ser consumidos por las diferentes plataformas que cuenta Clever Business (Mobile-Web)._

### Pre-requisitos 📋

*IDE Apache Netbeans version 17

*JDK version 17

*MySQL Server 8.0.32

*MySQL Workbennch 8.0.32

*Connector/J version 8.0.32

*Postman

*Visual Studio Code

## Comenzando 🚀

*Crear Base de Datos con los siguientes datos Hostname: localhost puerto: 3307 Contraseña: beclever

Agregar un nuevo Schema con el nombre a gusto y setear como Default o ejecutar el Query "use [nombre Schema elegido].

Ejecutar [Script](https://github.com/albarracincristian/PruebaTecnica/blob/main/Base%20de%20Datos-MySQL/Script_BD_Clever_Business.sql) del repositorio github Base de datos-MySQL.

[![Create-DB.png](https://i.postimg.cc/2yvtcfL6/Create-DB.png)](https://postimg.cc/0KkZjFfR)

*El proyecto esta creado con Spring Initializr Projet: Maven, Language: java, Spring Boot 3.0.4 con packaging: War Java: version 17

[![springinit.png](https://i.postimg.cc/yYrD74Dx/springinit.png)](https://postimg.cc/F73rx6gX)


### Instalación 🔧

*Clonar Repositorio y abrir el poyecto Maven con Apache NetBeans directorio "Back-End", al abrir esperar que se descarguen todos los complementos para el build

[![Abrirmaven.png](https://i.postimg.cc/V6C6RD1R/Abrirmaven.png)](https://postimg.cc/gXGmcyxX)

*Luego de abrir el proyecto asegurarnos que el Datasource contenga los siguientes datos de conexion con la base de datos:

[![aplication.png](https://i.postimg.cc/cCdvLfyB/aplication.png)](https://postimg.cc/VrHf7rNJ)


```
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://localhost:3307/beclever?serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=beclever
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
```
*Luego de lo anterior iniciar Springboot Run desde el Navigator y asegurarnos que haya compilado el proyecto con la leyenda : Tomcat started on port(s): 8080 (http) with context path ''

[![iniciacionspringboot.png](https://i.postimg.cc/TY7JB3g4/iniciacionspringboot.png)](https://postimg.cc/KRTTMF9P)

### Solicitudes en Postman para Test API 🔩

_Explica que verifican estas pruebas y por qué_

```
Da un ejemplo
```

