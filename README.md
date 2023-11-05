# SpringServer project

Adapted from https://www.youtube.com/watch?v=ev3-y9G8N70

## Setting up

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