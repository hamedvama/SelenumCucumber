Feature: Test_De_Site_NewtoursDemoAut
  This feature deals with the login functionality, and click any elements

  Scenario Outline: Test Newtours Site
    Given Configuration Node with her IP address <NodeAddress>
    And Give link of site <SiteUrl>
    When Authentication with <userName> and <password>
    Then Connexion Successful
    And Find flights on the site
    And Selected the flight and validate
    And Book the flight and validate
    Then Get flight confirmation

    Examples:
      | NodeAddress                     | SiteUrl                      |userName | password |
      | http://192.168.0.20:5568/wd/hub | http://newtours.demoaut.com/ |mercury  | mercury  |
      #| http://172.20.10.2:5568/wd/hub | http://newtours.demoaut.com/ |mercury  | mercury  |

