Feature: Test_De_Site_NewtoursDemoAut
  This feature deals with the login functionality, and click any elements

  Scenario Outline: Test Newtours Site
    Given Configuration Node with her IP address <NodeAddress>
    And give link of site <SiteUrl>
    When Authentication with <userName> and <password>
    Then Connection Okay

    Examples:
      | NodeAddress                     | SiteUrl                      | userName | password |
      | http://192.168.0.20:5566/wd/hub | http://newtours.demoaut.com/ | mercury  | mercury  |
