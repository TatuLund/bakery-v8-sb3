# Vaadin 8 Demo project using Spring Boot 3.2

Vaadin 8 Extended Maintenance provides possibility to use Spring Boot 3.2 with Vaadin 8. This application demonstrates the setup.

# Running the project

`mvn spring-boot:run`

Wait for the application to start

Open http://localhost:8080/ to view the application.

Default credentials are admin@vaadin.com/admin for admin access and
barista@vaadin.com/barista for normal user access.

# Running the project as an executable jar

The project is configured to automatically make the build artifact runnable using `java -jar`.
By default you can thus also run the project by executing the war file:
```
java -jar target/my-bakery-1.0-SNAPSHOT.war
```

If you want to produce a `jar` file instead of a `war` file, change the packaging type in `pom.xml` to `<packaging>jar</packaging>`.

# Developing the project

The project can be imported into the IDE of your choice as a Maven project

The views are created using Vaadin Designer. To edit the views visually,
you need to install the Vaadin Designer plug-in.

In Eclipse, open Marketplace, search for "vaadin" and install Vaadin
Designer 2.x

In IntelliJ, go to "Preferences" -> "Plugins" -> "Browse Repositories",
search for "Vaadin Designer 2" and install "Vaadin Designer"

# License

The code in this repository is distributed under Apache 2 license, but commercial Vaadin dependencies are used and you need a license to use those.

Vaadin 8.27.0 requires a paid Vaadin 8 Extended Maintenance subscription.

A paid Pro subscription is required for using Chart and Designer products.
