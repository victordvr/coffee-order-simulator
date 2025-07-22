# Coffee Order Simulator ☕

Console-based Java application to simulate coffee orders, focusing on core DevOps practices.

## ✅ Key Features

- OOP design: base class `Coffee`, subclasses `Espresso`, `Latte`, `Cappuccino`
- Console menu: create order, view current order, and access order history
- Order receipt saved to `current_order.txt`
- Order history shows last 10 orders (**password: `1234`**). It is saved to `history.txt`
- Unit testing: 9 passing + 3 failing (intentional)
- Maven used for build and test lifecycle
- Git branching strategy with PRs and conflict resolution

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

### Package App (optional)
```bash
mvn package -DskipTests
```
- Tests are skipped intentionally due to 3 designed-to-fail unit tests.
- This will generate a ```.jar``` file under target/. Run it with:
```bash
java -jar target/coffee-order-simulator-1.0-SNAPSHOT.jar
```

## 🔀 Git Workflow
Branches include:
- `develop`, `main`
- `feature/add-base-classes`, `feature/add-latte`, `feature/add-cappuccino`
- `test/unit-tests` (contains failing tests)
- `docs/readme`

## 👨‍💻 Author
Victor Daniel Valencia Rios
