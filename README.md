# Coffee Order Simulator ☕

Console-based Java application to simulate coffee orders, developed to explore and practice DevOps principles — including CI/CD pipelines implemented with Jenkins and optional containerization using Docker.

## ✅ Key Features

- Object-oriented design with base class `Coffee` and subclasses: `Espresso`, `Latte`, `Cappuccino`
- Console menu for placing orders, viewing current order, and accessing order history
- Receipts saved to `current_order.txt`
- Order history (last 10 orders) saved to `history.txt` (password-protected: `1234`)
- Fully functional unit tests
- Build lifecycle managed with Maven
- Git branching strategy with `feature/`, `fix/`, `ci/`, and `docs/` prefixes, plus `develop` and `main` as base branches
- Jenkins pipeline configured for continuous delivery: automatic build, test, and package on push to `main`
- Optional Docker integration for running the application inside a container

## 🔧 Usage

### Compile and Run
```bash
mvn compile
mvn exec:java
```

### Run Tests
```bash
mvn test
```

### Package the Application
```bash
mvn package
```
- This generates a ```.jar``` file under target/. Run it with:
```bash
java -jar target/coffee-order-simulator-1.0-SNAPSHOT.jar
```

## 🔁 CI/CD Pipeline

A Jenkins pipeline was configured to automate the following steps:
- Clone the GitHub repository
- Compile the project using Maven
- Run unit tests
- Package the application into a `.jar` file
- Optionally build a Docker image (if a `Dockerfile` is found)

The pipeline uses Windows batch commands (`bat`) to support Windows environments.

## 🐳 Run with Docker (optional)

If you have Docker installed, you can run the application inside a container instead of using Maven. This is optional, and intended as a lightweight and portable way to run the app.

### 1. Build the Docker image (only once, if not already built)
```bash
docker build -t coffee-machine-simulator-app .
```
> This command creates a local image called `coffee-machine-simulator-app` using the included Dockerfile.

### 2. Run the container interactively
```bash
docker run -it coffee-machine-simulator-app
```
> The `-it` flag lets you interact with the console menu of the app.

## 🔀 Git Workflow
This project follows a Git Flow-like branching strategy with:
- `main` — production-ready
- `develop` — integration
- Feature branches: `feature/*`
- Bug fix branches: `fix/*`
- Documentation and CI branches: `docs/*`, `ci/*`

## 👨‍💻 Author
Victor Daniel Valencia Rios

## 📝 Note

This project is intended as a learning exercise and to demonstrate DevOps skills with Java, Maven, Jenkins, and Docker.