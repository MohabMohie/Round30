# Round30
Automatest: Test Automation training round 30 practice project


## Element Identification

```xpath
xpath:

//tagName[@attribute='value']
//tagName[contains(@attribute,'subsetValue')]
//tagName[@attribute='value'][@attribute2='value2']


//tagName[@attribute]
//tagName
//*[@attribute='value']

//parentTagName[@attribute='value']/tagName
//grandParentTagName[@attribute='value']//tagName

(//tagName[@attribute='value'])[index]


golden rules:
- always match 1 of 1 (unique)
- pick the most stable attributes
- pick the most stable values
- use as few attributes as possible
- use as few nodes as possible
- when you have spaces in your `class` attribute, never use [@class='']
- locator must always match the business requirement
- try to avoid using text to identify elements (unless your application supports only one language)
- never identify the element using the same attribute you need to assert
```
