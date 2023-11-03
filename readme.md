## Getting Started

To get started with the project, follow these steps:

<h1>Standard run</h1>

1. Clone the repository to your local machine:

   ```bash
   git clone https://github.com/krzysztofkluczynski/spring-backend.git

2. Open a terminal or command prompt and navigate to the project directory.
3. Run the application using the following command:

   ```bash
   mvn spring-boot:run
   ```

<h1> Run from pre-generated jar file </h1>

   ```bash
   java -jar target/spring-backend-0.0.1-SNAPSHOT.jar 
   ```

<h1> Docker run </h1>

   ```bash
   docker build -t spring-boot-docker:spring-docker .
   docker image ls
   docker run -p 8080:8080 spring-boot-docker:spring-docker .
   ```

<h1>To run tests</h1>

   ```bash
   mvn test
   ````

<h1> To build a jar file </h1> 

   ```bash
    mvn package
   ```
