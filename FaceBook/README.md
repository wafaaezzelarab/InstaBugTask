**Short explanation for this framework :**

This framework to implement automated testcases for creating facebook account and Login to facebook 
using testUser.

The structure  using MAVEN for management and also using Page Object Model(POM)design Pattern,
to be able to re-use and enhance and easy maintain .

*-Data Driven framework :*the testcases read the data from external file defined in csv files and 
use it in the test methods as inputs for facebook registration and Login.

*-POM :*Each page has a class included the elements locator and Methods to this pages (registration and login pages)

*-Also using the TESTs* by starting the webdriver , performing the actions using the data driven
and assert the results then quit the driver




