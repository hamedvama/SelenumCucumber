Feature: Test_De_Site
  This feature deals with the login functionality, research article, article selection and add article

  Scenario Outline: Test Newtours Site
    Given Configuration Node with her IP address <NodeAddress>
    And give link of site <SiteUrl>
    When Authentication with <userName> and <password>
    Then Connection Okay

    Examples:
      | NodeAddress                     | SiteUrl                      | userName | password |
      | http://192.168.0.20:5566/wd/hub | http://newtours.demoaut.com/ | mercury  | mercury  |


  Scenario Outline: Test Cdiscount Site
    Given Configuration Cdiscount Node with her IP address <NodeAddress>
    And give Cdiscount link of site <SiteUrl>
    When Authentication on Cdiscount site with <UserName> and <PassWord>
    Then Connection Okay

    Examples:
      | NodeAddress                     | SiteUrl                    | UserName             | PassWord    |
      | http://192.168.0.20:5568/wd/hub | https://www.cdiscount.com/ | hamedbaba8@gmail.com | Babany@1991 |