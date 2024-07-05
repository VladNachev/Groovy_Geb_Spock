
# Groovy_Geb_Spock

The project is made for training purposes. Goal: test automation with Groovy in combination with Spock framework and Geb (Gebish) for browser automation. 

The project is based on the design pattern of Page Objet Model and Page Factory. It contains some very basics tests.

Used technologies:
- **Groovy**
- **Spock**
- **Geb**
- **Gradle**

### Clone the repository
\`\`\`sh
git clone https://github.com/VladNachev/Groovy_Geb_Spock.git
\`\`\`

### Build the project
\`\`\`sh
./gradlew clean build
\`\`\`

## Running Tests

To run the entire test suite:
\`\`\`sh
./gradlew test
\`\`\`

To run a specific test:
\`\`\`sh
./gradlew test --tests "path.to.your.TestClass"
\`\`\`

## Test Reports

After running the tests, you can find the test reports in:
\`\`\`
build/reports/tests/test/index.html
\`\`\`

## Project Structure

\`\`\`
Groovy_Geb_Spock/
├── src/
│   ├── main/
│   │   └── groovy/
│   └── test/
│       └── groovy/
│           ├── pageObjects/
│           │   ├── CheckoutPage.groovy
│           │   ├── CheckoutStepTwoPage.groovy
│           │   ├── CheckoutCompletePage.groovy
│           │   ├── InventoryPage.groovy
│           │   ├── SwagLabsHomePage.groovy
│           ├── specs/
│           │   ├── BaseSpec.groovy
│           │   ├── OrderSpec.groovy
│           │   ├── CartSpec.groovy
│           │   ├── LoginSpec.groovy
├── build.gradle
├── gradle.properties
└── settings.gradle
\`\`\`

## TO DO
To add more and various tests