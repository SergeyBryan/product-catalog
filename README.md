Here’s a comprehensive README based on the details you’ve shared about your "product-category" project:

```markdown
# Product Category Management System

## Project Title
**Product Category**

## Introduction
The **Product Category** project is a GraphQL-based system built with Spring Boot and Java. It is designed to manage products, their associated categories, models, and media. The system currently supports managing photos for products, with the potential to extend to videos and other media types in the future. The application supports features like managing categories, models, and product pricing.

This system is built using Spring Boot's GraphQL module and is backed by PostgreSQL. It provides an easy-to-use API for querying product and category data.

## Table of Contents
1. [Installation](#installation)
2. [Usage](#usage)
3. [Features](#features)
4. [Dependencies](#dependencies)
5. [Configuration](#configuration)
6. [Documentation](#documentation)
7. [Examples](#examples)
8. [Troubleshooting](#troubleshooting)
9. [Contributors](#contributors)
10. [License](#license)

## Installation

### Prerequisites
To run the **Product Category** system locally, ensure you have the following installed:
- Java 21 or higher
- Maven
- PostgreSQL

### Steps to Install
1. Clone this repository:
   ```bash
   git clone <repository_url>
   ```

2. Navigate into the project directory:
   ```bash
   cd products_catalog
   ```

3. Build the project using Maven:
   ```bash
   mvn clean install
   ```

4. Create a PostgreSQL database and update the connection details in `application.properties`.

5. Start the application:
   ```bash
   mvn spring-boot:run
   ```

### Configuration
The application connects to a PostgreSQL database, and you should configure the database connection in `application.properties`. Example:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/products_catalog
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.datasource.driver-class-name=org.postgresql.Driver
```

## Usage

### GraphQL Endpoints
The system exposes a GraphQL endpoint for managing products and categories. You can use any GraphQL client to interact with the system. By default, the GraphQL endpoint is available at:
```bash
http://localhost:8080/graphql
```

### Example Queries
#### 1. Fetch All Categories
```graphql
query {
  categories {
    id
    name
    description
  }
}
```

#### 2. Fetch Product Details by ID
```graphql
query {
  product(id: 1) {
    id
    name
    price
    media {
      url
    }
  }
}
```

#### 3. Create a New Product
```graphql
mutation {
  createProduct(input: {name: "New Product", price: 99.99}) {
    id
    name
    price
  }
}
```

## Features
- **Category Management**: Manage product categories and assign products to categories.
- **Model Management**: Organize products under different models.
- **Media Management**: Associate photos with products.
- **Pricing**: Manage product pricing.
- **GraphQL API**: Easy-to-use GraphQL interface for querying and mutating data.
- **Liquibase Integration**: Database schema management with Liquibase.

## Dependencies

### Core Dependencies
- **Spring Boot**: For building the application with a production-ready setup.
- **Spring Data JDBC**: Used for interacting with the PostgreSQL database.
- **Spring GraphQL**: Enables the integration of GraphQL in the Spring Boot application.
- **Liquibase**: For database migrations.
- **PostgreSQL**: Relational database used for storing products and categories.

### Development Dependencies
- **Lombok**: Provides boilerplate code reduction.
- **MapStruct**: For mapping between DTOs and entities.
- **JUnit / Testcontainers**: For unit testing and integration testing with a PostgreSQL container.

## Configuration
The application configuration is stored in `application.properties`. Some key configuration properties:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/products_catalog
spring.datasource.username=your_username
spring.datasource.password=your_password
```

## Documentation

This project uses **GraphQL** to expose its API for interacting with the system. For a detailed guide on how to use the GraphQL API, refer to the official [GraphQL documentation](https://graphql.org/learn/).

## Examples

Here are some practical examples of using the GraphQL API:

### 1. Retrieve all categories:
```graphql
query {
  categories {
    id
    name
    description
  }
}
```

### 2. Add a new product:
```graphql
mutation {
  createProduct(input: {name: "Product Name", price: 100.0}) {
    id
    name
    price
  }
}
```

### 3. Query product details:
```graphql
query {
  product(id: 1) {
    name
    price
    media {
      url
    }
  }
}
```

## Troubleshooting

1. **Database Connection Issues**: Ensure that your PostgreSQL database is running and that the connection details are correctly configured in `application.properties`.
2. **GraphQL Errors**: Check the GraphQL query syntax. Make sure all required fields are provided in queries or mutations.
3. **PostgreSQL Version**: Ensure that the PostgreSQL version matches the one compatible with the `postgresql` JDBC driver used.

## Contributors

- **Your Name** (Lead Developer)  
- **Contributor Name** (Contributor)  
- **Contributor Name** (Contributor)

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
```

### Key Points:
- The **Project Title** and **Introduction** sections provide a brief description of the system and its core functionality.
- The **Installation** and **Usage** sections provide clear steps for setup and usage of the system.
- The **Features** section highlights what the system can do, focusing on its core functionality.
- The **Dependencies** section lists the key dependencies used in the project.
- The **Configuration** section explains how to configure the PostgreSQL connection.
- The **Documentation** section gives information about the GraphQL API.

If you need to modify any specific section or need more details added, feel free to let me know!
