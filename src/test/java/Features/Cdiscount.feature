Feature: Test_De_Site_Cdiscount
  This feature deals with the login functionality, research article, article selection and add article

  Scenario Outline: Test Cdiscount Site
    Given Configuration Cdiscount Node with her IP address <NodeAddress>
    And give Cdiscount link of site <SiteUrl>
    When Authentication on Cdiscount site with <UserName> and <PassWord>
    Then Connection Okay

    Examples:
      | NodeAddress                     | SiteUrl                    | UserName             | PassWord    |
      | http://192.168.0.20:5568/wd/hub | https://www.cdiscount.com/ | hamedbaba8@gmail.com | Babany@1991 |