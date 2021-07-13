# Spring Swagger
REST API documentation using swagger

# Required Dependency
```xml
<dependency>
  <groupId>io.springfox</groupId>
  <artifactId>springfox-boot-starter</artifactId>
  <version>3.0.0</version>
</dependency>
```

# Custom Configuration

First create a configuration class.

```java
@Configuration
public class SwaggerConfiguration {
}
```

Second, create a bean Docket. In this Docket class, you can configure the base package to scan controllers using method APIs.
And in this configuration you can customize the path do you want to build into swagger documentation.

```java
@Bean
public Docket api() {
  return new Docket(DocumentationType.SWAGGER_2)
    .select()
    .apis(RequestHandlerSelectors.any())
    .paths(PathSelectors.any())
    .build();
}
```

Third, you can customize the swagger information using ApiInfo class.

```java
@Bean
public Docket api() {
  return new Docket(DocumentationType.SWAGGER_2)
    .select()
    .apis(RequestHandlerSelectors.any())
    .paths(PathSelectors.any())
    .build()
    .apiInfo(apiInfo());
}

private ApiInfo apiInfo() {
  return new ApiInfoBuilder()
    .title("Test Spring Swagger")
    .description("This is description swagger")
    .version("0.0.1")
    .contact(new Contact("Contact Name", "http://www.test.com", "test@test.com"))
    .build();
}
```
