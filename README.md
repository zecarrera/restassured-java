# restassured-java

## Summary
This repo contains an example API testing framework using Java and the following tools:
- RestAssured - API test library
- JUnit5 - Test runner
- Gradle - Build tool
- GitHub actions - CI tool

## Running tests 

### Locally

Running from the terminal:

```shell 
./gradlew build to build project
./gradlew test to run tests
```

### Pipeline

Tests are automatically triggered using GitHub actions when:

- PR is raised/updated
- Once a day at 12:00PM

Workflow also allows for manually triggering.

Test report is uploaded as an artifact, once tests finish.

## Application under test  
Tests are written against the [MERN-ecommerce](https://github.com/zecarrera/mern-ecommerce/tree/master)
