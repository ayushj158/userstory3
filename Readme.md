# Project Title

This app allows a user to create an order and add items to it's shopping cart. This is an standalone application driven primarily by tests
## Getting Started

Unzip file: UserStory2.zip

### Prerequisites

What softwares you need to run this.

```
1. Install maven on your machine with mvn as path varibale. 
2. Verify maven installation using command mvn --version. 
3. Ensure current user has read/write acces to .m2 repository 
    . Windows .m2 : c:/users/user_name/.m2 
    . Linux .m3 : /home/user_name/.m2
4. JAVA 8 should be installed on your machine
```
## How to build porject and run tests?

```
Execute : sh build-and-run-test.sh 
```
This will build your project and run all test cases
### Unit Tests 

  Unit Tests are available for every business logic in the porject. 

```
For example : ShoppingCartServiceTest tests ShoppingCartService class
```
### End to End Tests
 EndToEndTests class test end to end user scenarios . For Example

Given:
An empty shopping cart
And a product, Dove Soap with a unit price of 39.99
And another product, Axe Deo with a unit price of 99.99
And a sales tax rate of 12.5%

When:
The user adds 2 Dove Soaps to the shopping cart
And then adds 2 Axe Deos to the shopping cart

Then:
The shopping cart should contain 2 Dove Soaps each with a unit price of 39.99
And the shopping cart should contain 2 Axe Deos each with a unit price of 99.99
And the total sales tax amount for the shopping cart should equal 35.00
And the shopping cart’s total price should equal 314.96
```

## Built With

* [JAVA8](https://www.oracle.com/technetwork/java/javase/overview/java8-2100321.html)- Language Used
* [Maven](https://maven.apache.org/) - Dependency Management
* [JUnit5](https://junit.org/junit5/docs/current/user-guide/) - Used to unit test application


## Versioning
```
37981f84a50f54cb59378870e3f06ea1c17db7d7 
```
