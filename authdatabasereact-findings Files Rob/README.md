# ReactJS + Spring Boot + MySQL + Security Demo

## To build this project
- have MySQL installed and op and running
- edit application.properties
```
spring.datasource.url=jdbc:mysql://localhost:3306/yourdatabase
spring.datasource.username=root
spring.datasource.password=

# enable the line below to let Spring create the tables for you
#spring.jpa.hibernate.ddl-auto=create
```
- build the project with Maven
```
mvn clean package
```


## Start your own project
If you want to build your own project from scratch follow this 

We will integrate reactJS as below in the Spring project folder
```
auth (or your project name)
+- src
| +- main
| +- reactjs
| +- test
```

1. Create Spring Boot project with dependencies:
- Spring Web
- Spring Security
- MySql Driver

2. Open terminal in /project/src folder.

   to check if you are in the right folder, type :
   
   ```
   ls -al

   You should see something as:

   total 0
   drwxr-xr-x   5 your_name  wheel  160 Nov 10 13:40 .
   drwxr-xr-x  13 your_name  wheel  416 Nov 11 12:23 ..
   drwxr-xr-x   4 your_name  wheel  128 Nov  7 14:48 main
   drwxr-xr-x   3 your_name  wheel   96 Nov  7 14:48 test
   ```

3. Create React Project
```
    npx create-react-app reactjs
```
    
4. Add bootstrap
I used bootstrap in this project so if you want to follow..
```$xslt
cd reactjs
npm install react-bootstrap bootstrap
```

##If you want to do a test drive from here:

1. Build the reactJS app

```$xslt
#make sure you are in the reactJS folder then run

npm run build
```

2. Copy the reactJS build files to src/main/resources/static

Later we will use a few Maven plugin's to automate this. For now do it manually so you now what happens.

In Spring there is a static folder under the resources folder. The folder can serve static files.  
Copy all the files and directory's from the reactJS/build folder to the static folder of Spring.
Note there is also a static folder in the reactJS build. 


3. Build the project with Maven
use the command
```$xslt
mvn clean package
```
to build the project. The package command will copy the files from the Static folder to the Target folder

4. Start the project and login
Now you can start  the project from your IDE or run the .jar file.
See the output from the mvn clean package for the location of the .jar
```$xslt
java -jar /projectfolder/demoproject/target/demoproject-0.0.1-SNAPSHOT.jar
```
watch the output of the console to see a line with the generated password like:
```$xslt
Using generated security password: 9552ba56-3cc7-422c-b78e-b5a4f2bce36e
```
open a browser and go to :
```$xslt
localhost://8080
```
You will see the default login of spring. Now you can use the default user user with the password from the console.
After a successful login you will see the standard ReactJS logo

---
---
#In this project you can find example of:


## Integration of ReactJS with a Spring Boot backend
How this works in short:
In ReactJS the project is build with NPM run build. This creates a build directory with the compiled project. 
The starting point for ReactJS is the index.html file. This file loads the necessary scripts to run the App and starts running the index.js file.

The content of the build directory is placed in the Static folder of Spring. I have done this manually for now but it is possible to automate this with 
two Maven plugins.. Now we have a entry point for our Web App

In the security configuration of Spring we include a setting :  

 ```
   .....
  .and()
  .formLogin()
  .loginPage("/index.html")
  .loginProcessingUrl("/login")
   .successForwardUrl("/loginSucces");
 ```
 
In React we start with a Login Form. On Submit the Input fields UserName and Password are posted to /login
After successful validation in Spring we get forwarded to /loginSuccess. From there we can redirect the logged in user to
there landing page
---

## Integration of MySql and use multiple related tables.

User
Role
Privilege

User has a ManyToMany relation to Role
Role has a ManyToMany relation to Privilege

The relation is setup in the model Class of the table like:
```
@Entity
public class User implements UserDetails {

...

 @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;     // Dit geeft een overzicht van de rechten van de user
                                        // De user krijgt een of meer Rollen
                                        // Iedere Rol bestaat weer uit een of meer Privilages
...
```
in the application.properties are a few lines add for the configuration of MySQL

```
spring.datasource.url=jdbc:mysql://localhost:3306/database
spring.datasource.username=root
spring.datasource.password=secret

spring.jpa.hibernate.ddl-auto=create
```
The create setting will automatically create the tables with all Fields and Primary and Foreign Keys
To support the ManyToMANY relations there are two extra tables created


## Setup security 

---

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.2.1.RELEASE/maven-plugin/)
* [Spring Security](https://docs.spring.io/spring-boot/docs/2.2.1.RELEASE/reference/htmlsingle/#boot-features-security)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.2.1.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications)
* [JDBC API](https://docs.spring.io/spring-boot/docs/2.2.1.RELEASE/reference/htmlsingle/#boot-features-sql)

### Guides
The following guides illustrate how to use some features concretely:

* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Accessing Relational Data using JDBC with Spring](https://spring.io/guides/gs/relational-data-access/)
* [Managing Transactions](https://spring.io/guides/gs/managing-transactions/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)


