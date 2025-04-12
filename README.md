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