
# Groovy_Geb_Spock

The project is made for training purposes. Goal: test automation with Groovy in combination with Spock framework and Geb (Gebish) for browser automation. 

The project is based on the design pattern of Page Objet Model and Page Factory. It contains some very basics tests.

Used technologies:
- **Groovy**
- **Spock**
- **Geb**
- **Gradle**

### Clone the repository
```bash
git clone https://github.com/VladNachev/Groovy_Geb_Spock.git
```

## Project Structure

```bash
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
```

## TO DO
To add more and various tests