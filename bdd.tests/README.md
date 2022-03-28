# BDD

This repository is meant to demonstrate best practices for Behavior Driven Development (BDD) with Adobe Experience Manager (AEM).

## Current Implementation

The following is a list of current best practices and implementation steps.

### Page Object Pattern

We use the page objec pattern for reusability and maintainability. Page objects shouldn't usually be built for each page, but rather for the significant elements on a page. The idea is to model the structure in the page that makes sense to the user of the application.

#### Creating a new Page Object

- Create a new Jeva class in the pageObjects folder following the establlished naming convention
  - Example: ErrorPaage.java
- Give the class a WebDriver
- Create a constructor for the new class passing in and initalizing the WebDriver
- Add the new page object to the PageObjectManager class
  - Create a method following the nameing scheme of the other methods in that class to initalize a new page object.
- Add the new page object to the aemStepDefs class
  - Initalize the page object in the constructor of the aemStepDefs class
- Your page object is now ready to be used in BDD tests!

#### Further Learning

for more information about the page object pattern see:
- Martin Fowler's Page Object Article <https://martinfowler.com/bliki/PageObject.html>
- Selenium's Page Object Documentation <https://www.selenium.dev/documentation/test_practices/encouraged/page_object_models/>

### Using Selctors and XPATHs

In order to interact with elements on a page in our page objects we need to locate them. Ideally we would use IDs, however AEM does not typically utilize IDs for thier web elements so we will need to leverage selectors and XPATHs. The [ContentPage](/Users/briannaurbina/Documents/code/aem-guides-wknd-cucumber/bdd.tests/src/test/java/pageObjects/ContentPage.java) class is a great example of utilizing IDs, XPATHs, and selectors.

#### Finding Selectors and XPATHs

The following is a list of steps to grab selectors, IDs, and XPATHs:

- Go to the page in the UI of AEM where the desired web element resides
- Right click on the element and select "Inspesct"
- Right clock on the block of code highlighting the desired web element and select "Copy..." then "Selector"
- stopping point for now