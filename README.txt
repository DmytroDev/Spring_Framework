How to build and deploy:
1/ Install nodeJS
2/ Run "npm i"



Programming and Markup Languages:
Java 8, JavaScript, SQL, HTML, CSS.

Java Frameworks and Technologies:
Spring Framework 4.2, JPA (Hibernate), JSP, JSTL, SQL, HTML, CSS, jQuery, Bootstrap.

Databases:
H2 as embedded DB.

Application/Web Servers:
Apache Tomcat 9.0.0.

SVC Tools:
Git

Building Tools:
Maven, Gulp.js



H2 url masks:
Remote
jdbc:h2:tcp://{host::localhost}[:{port::9092}]/{database::default}[;<;,user={user:param},password={password:param},{:identifier}={:param}>]

In-memory
jdbc:h2:mem:{database::default}?[;<;,{:identifier}={:param}>]

Embedded:
jdbc:h2:!(tcp://)[file:]{path}[;<;,user={user:param},password={password:param},{:identifier}={:param}>]


embedded (local) connection(URL)
jdbc:h2:~/sofwarestore

in-memmory (URL)
jdbc:h2:mem:softwarestore
