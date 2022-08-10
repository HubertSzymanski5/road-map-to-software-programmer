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