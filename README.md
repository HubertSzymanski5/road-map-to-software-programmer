# Welcome in Road Map to be the coder!


## What is it?
It's collection of ideas what to learn in specific order to achieve what it takes to be a programmer.

In this _tutorial_ we will focus on basic in order to get required knowledge and skills to be a software developer, 
in particular Java backend software developer.

Main idea behind this repo is to give generic points in form of road map of what to learn / focus on next.
Each step contains terms or technologies to learn with some project idea at the end.

# Steps:

## Basics

### What to learn?
* Java:
    * basic syntax: ie. loops, types, classes, enums, etc.
    * String manipulation
    * OOP basics: class, interface
    * I/O streams: reading file / writing to file
    * error handling: try/catch, try with resources
* Git: create account on GitLab or GitHub, try adding features as commits in Your project repository
* IDE: ie. Intellij IDEA (Community Edition)

### Project: Excel import file linter
You have a bunch of `.txt` files, and You want to verify that You can use them to import as tables in Excel. 
Every file contains list of employees from different department. Properties in each row are delimited with `;`.
All employees rows should have the following fields:
* first name - `string`
* last name - `string`
* date of birth - `string` in `yyyy-MM-dd`
* salary - `number`
* department - `string` one of `IT`, `Sales`, `Management`, `other` (case doesn't matter)

Each string may contain only alphanumeric characters. No special characters like `ąźć²ðŋ€←½¢` are allowed.

Write a linter app that will read the file and decide if it is valid or not.

If file turns out to be valid output of the program should be simple:

    <file_name> is valid

If file is invalid output of the program should contain message and then list of lines with description
which fields are invalid and why. Try to make it meaningful, so to user know what is the issue and what should
be fixed. Example output of invalid file:

    <file_name> is invalid
    line 20: First name '<name>' contains illegal character...
    line 23: Salary must be positive number...

Remember to inform about all malformed lines, not only the first one.

_Tips:_
* _start small → first try reading the file, then reading the fields_
* _don't be afraid to google stuff_
* _look at Your code and try new things → can I achieve this functionality in other way? Try googling that crazy ideas ;)_
* _see solution for some of my insane ideas → it is overcomplicated, but hey we are trying to learn with experiments_

## Testing

Great! So You have created Your first (or another) project! Congrats!
Now I would like to introduce to You few new tools and ideas, so You can create bigger projects with use of
external libraries (but let's leave those big projects for future). Now we will need special library to write unit tests.
For Java, it's JUnit.

### What to learn?
* Build tool for Java:
  * Maven or Gradle: pick one, but it's good to know both
  * basics: how to build project
  * dependencies: basic idea behind `pom.xml` or `build.gradle` files
* Unit testing:
  * What is unit testing?
  * Adding JUnit dependencies to Maven or Gradle: see [MVNrepository](https://mvnrepository.com/) it holds public dependencies
  * Writing JUnit test: setting up the test class, assertions
  * Test Driven Development (TDD): read about it and try it out with simple [FizzBuzz Code Kata](https://www.youtube.com/watch?v=JyRouDwzCoo)

### Project:
Let's start with a warmup! I've taken some code from previous app made some changes and added very little tests.
Turns out that there's a bug in it! Add tests to cover all requirements below. Find the bug and fix it!
It's `DateOfBirthValidator`. As You know date of birth comes as a `string` and it's required format is `yyyy-MM-dd`.
Let's add one more restriction that employee should be over 16 (or at least turn 16 this year).
Employee also cannot be older than 70

To sum up:
* date of birth cannot be in the future
* date needs to be in valid `yyyy-MM-dd` format
* employee should be over 16 or turn 16 this year
* employee cannot be older than 70

This project won't be really a new project. We created an application in first step that has no tests at all
(sorry, manual testing doesn't count). So the goal is quite simple - write unit tests!
Sounds good, but how?
1. To make it easier start with creating Maven or Gradle project and add your code there.
2. By default, project should have JUnit dependencies, if not add them.
3. Write tests...

What if it is impossible? Do You have only one `App` class with multiple methods or just `main()` and no idea how to
start? Ideally You should _refactor_ Your code - group and move responsibilities to different classes, packages, etc.
When we start our journey with programming it's easy to write messy code that is hard to test. Sometimes there is
a project with no tests at all, and we need to write them as it helps to understand the project.
If You followed FizzBuzz Kata You should already know how to write tests alongside with application code.
Always do it! Just to make it Your habit.

If _refactoring_ sound too hard, You can also start from the start - create the same application, but this time use TDD!
