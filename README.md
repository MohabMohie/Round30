# Round30
Automatest: Test Automation training round 30 practice project


## Element Identification

### Xpath formats
```xpath
//tagName[@attribute='value']
//tagName[contains(@attribute,'subsetValue')]
//tagName[@attribute='value'][@attribute2='value2']


//tagName[@attribute]
//tagName
//*[@attribute='value']

//parentTagName[@attribute='value']/tagName
//grandParentTagName[@attribute='value']//tagName

(//tagName[@attribute='value'])[index]
```

### Golden rules for element identification:

<table><tr><td>

- always match 1 of 1 (unique)
- locator must always match the business requirement
- never identify the element using the same attribute you need to assert
- pick the most stable attributes
- pick the most stable values
- use as few attributes as possible
- use as few nodes as possible
- absolute xpath == r-click copy full xpath -> NEVER USE THIS
- relative xpath == starts with `//` -> ALWAYS write it yourself
- dynamic xpath -> use it with `INDEX` or `TEXT`
- when you have spaces in your `class` attribute, never use `[@class='']`
- try to avoid using `text` to identify elements (unless your application supports only one language)

</td></tr></table>

### Testing the id attribute:
```java
By.xpath("//*[@id='searchbox_input']");
By.cssSelector("#searchbox_input");
By.id("searchbox_input");
```

### The three options to deal with element locators:
```java
//option 1
By searchbox = By.id("searchbox_input");
driver.findElement(searchbox).sendKeys("Selenium WebDriver" + Keys.ENTER);

//option 2
WebElement searchboxInput = driver.findElement(By.id("searchbox_input"));
searchboxInput.sendKeys("Selenium WebDriver" + Keys.ENTER);

//option 3
driver.findElement(By.id("searchbox_input")).sendKeys("Selenium WebDriver" + Keys.ENTER);
```

### The two options for dealing with multiple element instances:
```java
 // option 1 - using index in the xpath
driver.findElement(By.xpath("(//a[@data-testid='result-extras-url-link'])[2]")).getDomAttribute("href");
// option 2 - using findElements method
driver.findElements(By.xpath("//a[@data-testid='result-extras-url-link']")).get(1).getDomAttribute("href");
```

### Creating a dynamic xpath:
```java
private String getResultLinkUsingBy(int index) {
    By allResultLinks = By.xpath("(//a[@data-testid='result-extras-url-link'])["+index+"]");
    return driver.findElement(allResultLinks).getDomAttribute("href");
}
```

### Fetching element information:
```java
driver.findElement(locator).getText();
driver.findElement(locator).getAttribute("value"); // DO NOT USE THIS AS IT WILL BE REMOVED
driver.findElement(locator).getDomAttribute("value");
driver.findElement(locator).getDomProperty("value");
```

## Page Object Model (POM) Design Pattern:

### The two options for creating POM reusable methods:

#### In the POM Class:
```java
// option 1: create a separate method for each line of code
public void enterUsername(String username) {
    driver.findElement(usernameInput).sendKeys(username);
}
public void enterPassword(String password) {
    driver.findElement(passwordInput).sendKeys(password);
}
public void agreeToTermsAndConditions(){
    driver.findElement(loginButton).click();
}
public void clickLoginButton() {
    driver.findElement(loginButton).click();
}

// option 2: create a single method to perform all actions
public void login(String username, String password) {
    driver.findElement(usernameInput).sendKeys(username);
    driver.findElement(passwordInput).sendKeys(password);
    driver.findElement(loginButton).click();
    driver.findElement(loginButton).click();
}
```

#### In the Test Class:
```java
// option 1: create a separate method for each line of code
login.enterUsername(validUsername);
login.enterPassword(validPassword);
login.clickLoginButton();

// option 2: create a single method to perform all actions
login.login(validUsername, validPassword);
```

## Minimum and extra passing criteria for any technical task:

### Minimum passing criteria:
<table><tr><td>

- Locators:
    - No r-click copy xpath
    - No absolute xpath
    - Knows how to write a proper xpath
- Design:
  - Test Workflow Management
    - @Before / @After for Methods and Classes
    - @Test doesn't use priority attribute
  - Page Object Model
    - No duplicate code
    - No hardcoded values
    - Using business-level methods (login, register, etc.)
    - Using By objects (no @FindBy, no WebElement objects)
  - Synchronization 
    - No Thread.sleep
    - No implicit wait ***
- ReadME.md -> explain your project and how to execute it
- Source Control
- Folder Structure:
  - src/test/java -> for test files
  - src/test/resources -> for test data files
  - src/main/java -> for POM classes
  - pom.xml -> for maven dependencies, with the latest stable version for each

</td></tr></table>

### Extra score:
<table><tr><td>

- Allure reporting
- Test Data Externalization
- No warnings in the code
- Abstraction for Test Cases and/or Test Scenarios
- Log4j logging
- Fluent Design with POM
- Abstraction for POM classes
- Proper scoping / Access Modifiers
- GitHub Actions pipeline to run the tests and host the report
- Bot pattern with Custom explicit wait

</td></tr></table>
