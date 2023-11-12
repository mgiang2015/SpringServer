# SpringServer project

Adapted from https://www.youtube.com/watch?v=ev3-y9G8N70


## Running this server

1. Pre-requisites

- (MySQL)[https://dev.mysql.com/doc/mysql-getting-started/en/]
- (Java 17)[https://www.oracle.com/java/technologies/downloads/] or later

2. Running the project

- Navigate to root folder
- Execute the following command `./gradlew bootRun`


## Building progress

1. This project dependency included JPA as a dependency. This requires some configuration.

2. In src/main/resources/application.properties, I added these few configuration:

    - spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver: Specifies driver class name because JPA supports multiple types of databases, each have their own driver. Take note that "com.mysql.jdbc.Driver" (without .cj) is deprecated.
    - spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect: Same reason as above. Specifying the syntax it should use to support MySQL. Note that "org.hibernate.dialect.MySQL8Dialect" (with specified SQL version) is deprecated.
    - pring.datasource.{url,username,password}: url, username and password of database
    - pring.jpa.hibernate.ddl-auto=update: Define the protocol taken when schema changes.
    - Warning displayed to set hibernate.transaction.jta.platform parameter. I didn't have time to research what it does, but here are some references 
    - Documentation: https://docs.jboss.org/hibernate/ogm/4.0/reference/en-US/html/ogm-configuration.html 
    - Values: https://docs.jboss.org/hibernate/orm/4.1/devguide/en-US/html_single/#services-JtaPlatform

3. You do not need Gradle for this. ```./gradlew bootRun``` is enough.

4. We will design this program following MVC (Model View Control) design pattern.

## Connecting to Database

### Entity

An entity is basically a schema definition. In `src/main/java/com/genuinecoder/springserver/model/employee`, we define the schema for employee in `Employee.java`.

- `@Entity` tag helps to point Springboot to schema definition
- `@Id` tag defines the primary key
- `@GeneratedValue(strategy = GenerationType.IDENTITY)` lets the field auto-increment for each object it creates
- `@Table(name = "employees")` helps to define the nam of table and allow auto creation.
employee

### Repository

A repository is basically an interface for the entity - what are the operations allowed with this schema. `@Repository` tag helps to define the interface as a repository.

SpringBoot provides `CrudRepository` interface. Any interface that extends this will inherit the CRUD methods that come out of the box with SpringBoot.

### DAO

DAO is a Data Access Object. Any read or writes to database goes through this object, it should be a singleton for each schema object. Defines how backend interacts with database through repository.employee

DAO can then be easily injected into any other class / objects that needs data about Employees.

### REST API

REST API is defined in the controller folder.

1. First we inject the `EmployeeDao` into the controller using `@Autowired` tag

2. Define `GET` handlers using `@GetMapping(URL)` tag and write a method for handling. Return results are automatically formatted to JSON for response.

3. Define `POST` handlers using `@PostMapping(URL)` tag and write a method for handling. Method must take in `@RequestBody Type name` for this program
