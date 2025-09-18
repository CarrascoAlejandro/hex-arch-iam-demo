# Hexagonal Architecture IAM Demo

This project demonstrates a complete Identity and Access Management (IAM) system built using Hexagonal Architecture (also known as Ports and Adapters architecture). The system manages users and their privileges in a clean, maintainable, and testable way.

## 🎯 Project Overview

The IAM demo showcases how to implement a robust access control system following hexagonal architecture principles, with clear separation between business logic and infrastructure concerns.

### Key Features

- **User Management**: Create and manage user accounts
- **Privilege Management**: Define and manage system privileges
- **Privilege Assignment**: Assign and revoke privileges to/from users
- **RESTful API**: Complete REST API for all operations
- **Data Persistence**: JPA-based data persistence layer
- **Comprehensive Testing**: Unit tests with Mockito for business logic

## 🏗️ Architecture

The project follows Hexagonal Architecture with the following layers:

```
📦 Hexagonal Architecture
├── 🎯 Domain Layer (Core Business Logic)
│   ├── Models (User, Privilege)
│   ├── Business Logic (UserBl, PrivilegeBl)
│   ├── Input Ports (Use Cases)
│   └── Output Ports (Repository Interfaces)
├── 🔌 Infrastructure Layer (Adapters)
│   ├── Input Adapters (REST Controllers, DTOs)
│   └── Output Adapters (JPA Repositories, Entities)
└── 🛡️ Shared Layer
    └── Exception Handling
```

### Domain Models

#### User
- Unique identifier
- Username (unique)
- Email (unique)
- Associated privileges

#### Privilege
- Unique identifier
- Name (unique)
- Resource key for permission identification
- Description

## 🚀 Expected Final Result

When fully implemented, this system will provide:

### 1. REST API Endpoints

#### User Management
- `POST /users` - Create a new user
- `GET /users/{id}` - Get user by ID
- `GET /users/by-username/{username}` - Get user by username
- `GET /users/by-email/{email}` - Get user by email
- `GET /users` - List all users

#### Privilege Management
- `POST /privileges` - Create a new privilege
- `GET /privileges/{id}` - Get privilege by ID
- `GET /privileges/by-name/{name}` - Get privilege by name
- `GET /privileges/by-resource/{resourceKey}` - Get privilege by resource key
- `GET /privileges` - List all privileges

#### Privilege Assignment
- `POST /users/{userId}/privileges/{privilegeId}` - Assign privilege to user
- `DELETE /users/{userId}/privileges/{privilegeId}` - Remove privilege from user

### 2. Data Persistence & Database Portability
- JPA entities with proper relationships
- Repository implementations with CRUD operations
- Database schema for users and privileges with many-to-many relationship
- **Multi-Database Support**: Easy switching between MySQL and PostgreSQL
- **Docker Infrastructure**: Containerized database setup with automated initialization
- **Database-specific optimizations**: Tailored schemas and data types for each DBMS

### 3. Business Logic
- Domain rules validation
- User creation with duplicate checking
- Privilege management with business constraints
- Privilege assignment/revocation logic

### 4. Error Handling
- Consistent error responses across all endpoints
- Proper HTTP status codes
- Comprehensive exception handling

### 5. Testing & API Validation
- Unit tests for all business logic components
- Mocked dependencies for isolated testing
- High test coverage for core functionality
- **API Testing Infrastructure**: Complete REST Client test suite for VSCode
- **Automated API Testing**: Bruno collection with AI agent compatibility
- **Multi-environment support**: Test configurations for different deployment targets

## 📋 TODO Checklist

### ✅ GitHub Issues Created
All TODOs have been converted to GitHub issues for better tracking and collaboration.

### 🎯 Domain Layer - Input Ports
- [*] [#1 Define User Management Use Case Operations](https://github.com/CarrascoAlejandro/hex-arch-iam-demo/issues/1)
  - Create User operation
  - Find User by Username or Email operation
- [ ] [#2 Define Privilege Management Use Case Operations](https://github.com/CarrascoAlejandro/hex-arch-iam-demo/issues/2)
  - Create Privilege operation
  - Find Privilege by Name or Resource Key operation
  - List All Privileges operation
- [ ] [#3 Define Privilege Assignment Use Case Operations](https://github.com/CarrascoAlejandro/hex-arch-iam-demo/issues/3)
  - Assign Privilege to User operation
  - Remove Privilege from User operation

### 🎯 Domain Layer - Output Ports
- [ ] [#4 Define User Repository Port Operations](https://github.com/CarrascoAlejandro/hex-arch-iam-demo/issues/4)
  - Save User operation
  - Find User by ID operation
  - Find User by Username or Email operation
  - List All Users operation
- [ ] [#5 Define Privilege Repository Port Operations](https://github.com/CarrascoAlejandro/hex-arch-iam-demo/issues/5)
  - Save Privilege operation
  - Find Privilege by ID operation
  - Find Privilege by Name or Resource Key operation
  - List All Privileges operation

### 🎯 Domain Layer - Business Logic
- [ ] [#6 Implement User Business Logic](https://github.com/CarrascoAlejandro/hex-arch-iam-demo/issues/6)
  - UserManagementUseCase implementation
  - PrivilegeAssignmentUseCase implementation
  - Business rules validation
- [ ] [#7 Implement Privilege Business Logic](https://github.com/CarrascoAlejandro/hex-arch-iam-demo/issues/7)
  - PrivilegeManagementUseCase implementation
  - Business rules validation

### 🔌 Infrastructure Layer - Input Adapters
- [ ] [#8 Implement User REST Controller](https://github.com/CarrascoAlejandro/hex-arch-iam-demo/issues/8)
  - User management endpoints
  - Privilege assignment endpoints
- [ ] [#9 Implement Privilege REST Controller](https://github.com/CarrascoAlejandro/hex-arch-iam-demo/issues/9)
  - Privilege management endpoints
- [ ] [#10 Create REST DTOs and Mapping Infrastructure](https://github.com/CarrascoAlejandro/hex-arch-iam-demo/issues/10)
  - Request/Response DTOs for User and Privilege
  - Create/Update DTOs
  - Mapping between domain models and DTOs
  - Input validation

### 🔌 Infrastructure Layer - Output Adapters
- [ ] [#11 Implement JPA Persistence Layer](https://github.com/CarrascoAlejandro/hex-arch-iam-demo/issues/11)
  - JPA entities for User and Privilege
  - JPA repositories
  - Repository adapter implementations
  - Entity mapping to domain models

### 🛡️ Shared Layer
- [ ] [#12 Implement Global Exception Handler](https://github.com/CarrascoAlejandro/hex-arch-iam-demo/issues/12)
  - Consistent error responses
  - Exception mapping to HTTP status codes
  - Error logging

### 🧪 Testing
- [ ] [#13 Implement Unit Tests with Mockito](https://github.com/CarrascoAlejandro/hex-arch-iam-demo/issues/13)
  - Unit tests for UserBl
  - Unit tests for PrivilegeBl
  - Mocked repository dependencies
  - High test coverage

### 🗄️ Database Infrastructure
- [ ] [#14 Create Database Schema Files (MySQL & PostgreSQL)](https://github.com/CarrascoAlejandro/hex-arch-iam-demo/issues/14)
  - Create crebas.sql for MySQL with optimized syntax and data types
  - Create crebas.sql for PostgreSQL with optimized syntax and data types
  - Include Users, Privileges, and User_Privileges tables
  - Add proper indexes and foreign key constraints
- [ ] [#15 Create Database Seed Data Files](https://github.com/CarrascoAlejandro/hex-arch-iam-demo/issues/15)
  - Create init.sql for MySQL with sample users and privileges
  - Create init.sql for PostgreSQL with sample users and privileges
  - Include realistic test data for development and testing
- [ ] [#16 Create Docker Compose with Multi-Database Support](https://github.com/CarrascoAlejandro/hex-arch-iam-demo/issues/16)
  - Docker Compose file with MySQL and PostgreSQL containers
  - Automatic loading of database structure and initial data
  - Environment-specific configuration for easy database switching
  - Volume mapping for data persistence

### 🔧 API Testing Infrastructure  
- [ ] [#17 Create REST Client Tests for VSCode](https://github.com/CarrascoAlejandro/hex-arch-iam-demo/issues/17)
  - HTTP files compatible with REST Client VSCode extension
  - Complete test coverage for all API endpoints
  - Test cases for success and error scenarios
  - Environment variables for different deployment targets
- [ ] [#18 Create Bruno API Collection with AI Agent Support](https://github.com/CarrascoAlejandro/hex-arch-iam-demo/issues/18)
  - Bruno collection with all API endpoints
  - Automated test assertions for response validation
  - Collection setup optimized for AI agent execution
  - Error detection and reporting mechanisms

## 🛠️ Technology Stack

- **Java 17+**
- **Spring Boot** - Application framework
- **Spring Data JPA** - Data persistence
- **Spring Web** - REST API
- **MySQL/PostgreSQL** - Database options (demonstrating portability)
- **Docker & Docker Compose** - Containerization and multi-database setup
- **JUnit 5** - Testing framework
- **Mockito** - Mocking framework
- **Maven** - Build tool
- **REST Client Extension** - VSCode API testing
- **Bruno** - API testing and collection management

## � Database Portability Demonstration

One of the key benefits of hexagonal architecture is the ability to easily switch between different infrastructure components. This project demonstrates this principle by supporting both MySQL and PostgreSQL:

### Database Support
- **MySQL**: Optimized schema and data types for MySQL
- **PostgreSQL**: Optimized schema and data types for PostgreSQL
- **Easy Switching**: Change database with simple configuration updates
- **Docker Setup**: Both databases available through Docker Compose

### File Structure
```
src/main/resources/db/
├── mysql/
│   ├── crebas.sql    # MySQL-optimized schema
│   └── init.sql      # MySQL sample data
└── postgresql/
    ├── crebas.sql    # PostgreSQL-optimized schema
    └── init.sql      # PostgreSQL sample data
```

## �🚦 Getting Started

1. **Clone the repository**
   ```bash
   git clone https://github.com/CarrascoAlejandro/hex-arch-iam-demo.git
   cd hex-arch-iam-demo
   ```

2. **Build the project**
   ```bash
   ./mvnw clean compile
   ```

3. **Run tests** (when implemented)
   ```bash
   ./mvnw test
   ```

4. **Run the application** (when implemented)
   ```bash
   ./mvnw spring-boot:run
   ```

## 📝 Implementation Progress

Track the implementation progress by checking off completed GitHub issues. Each issue contains detailed requirements and acceptance criteria for the specific component.

## 🤝 Contributing

1. Pick an issue from the [GitHub Issues](https://github.com/CarrascoAlejandro/hex-arch-iam-demo/issues)
2. Create a feature branch
3. Implement the functionality following hexagonal architecture principles
4. Add comprehensive tests
5. Submit a pull request

## 📚 Architecture Benefits

This hexagonal architecture implementation provides:

- **Testability**: Easy to unit test business logic in isolation
- **Flexibility**: Can swap infrastructure components without affecting business logic
- **Maintainability**: Clear separation of concerns and dependencies
- **Scalability**: Easy to add new features and adapters
- **Clean Code**: Following SOLID principles and clean architecture guidelines

---

---

## 📋 Additional Task Details

### Database Infrastructure Tasks

#### #14 - Database Schema Files (MySQL & PostgreSQL)
**Purpose**: Demonstrate database portability in hexagonal architecture

**Requirements**:
- Create `src/main/resources/db/mysql/crebas.sql` with MySQL-optimized schema
- Create `src/main/resources/db/postgresql/crebas.sql` with PostgreSQL-optimized schema
- Include Users, Privileges, and User_Privileges tables with proper relationships
- Add indexes and constraints optimized for each database type

#### #15 - Database Seed Data Files  
**Purpose**: Provide realistic test data for both database systems

**Requirements**:
- Create `src/main/resources/db/mysql/init.sql` with sample data for MySQL
- Create `src/main/resources/db/postgresql/init.sql` with sample data for PostgreSQL
- Include realistic users, privileges, and assignments for testing
- Ensure data compatibility with respective database schemas

#### #16 - Docker Compose Multi-Database Setup
**Purpose**: Containerized environment showcasing database switching capability

**Requirements**:
- Docker Compose file with MySQL and PostgreSQL containers
- Automatic loading of schema and seed data on container startup
- Environment-specific configuration for easy database switching
- Volume mapping for data persistence during development

### API Testing Infrastructure Tasks

#### #17 - REST Client Tests for VSCode
**Purpose**: Complete API testing suite for development workflow

**Requirements**:
- Create `http/` folder with `.http` files compatible with REST Client extension
- Cover all API endpoints: users, privileges, and privilege assignments
- Include test cases for success scenarios, validation errors, and edge cases
- Environment variables for different deployment targets (local, staging, etc.)

**File Structure**:
```
http/
├── users.http           # User management endpoints
├── privileges.http      # Privilege management endpoints
├── assignments.http     # Privilege assignment endpoints
├── environment.http     # Environment variables
└── README.md           # Usage instructions
```

#### #18 - Bruno API Collection with AI Agent Support
**Purpose**: Automated API testing with AI agent compatibility for error detection

**Requirements**:
- Complete Bruno collection covering all API endpoints
- Automated test assertions for response validation
- Collection optimized for AI agent execution and error reporting
- Pre-request scripts for test data setup
- Post-request scripts for cleanup and validation

**Features**:
- Environment management for different deployment stages
- Automated test data generation
- Response validation with detailed assertions
- Error detection and reporting mechanisms
- AI agent-friendly collection structure for automated testing

## 🔄 Database Switching Example

Once implemented, switching between databases will be as simple as:

```bash
# Development with MySQL
docker-compose up mysql -d
export SPRING_PROFILES_ACTIVE=mysql
./mvnw spring-boot:run

# Development with PostgreSQL  
docker-compose up postgresql -d
export SPRING_PROFILES_ACTIVE=postgresql
./mvnw spring-boot:run
```

This demonstrates the power of hexagonal architecture - the business logic remains completely unchanged while the infrastructure adapts to different database systems.

*This project serves as a comprehensive example of implementing hexagonal architecture in a real-world scenario, focusing on IAM functionality that's commonly needed in enterprise applications.*