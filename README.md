# spring-boot-gwt
Example application using Spring-Boot 2.0.0, Jersey, & GWT 2.8.2.

## Quick Start

    mvn clean package
 
From first terminal:
 
    mvn spring-boot:run
    
From second terminal:

    mvn gwt:codeserver
    
From third terminal:

    gulp watch --envName dev --srcDir src/main/webapp --buildDir target/frontend --outDir target/classes/static

    
Open [http://localhost:8080/index.html](http://localhost:8080/index.html) in your browser.
