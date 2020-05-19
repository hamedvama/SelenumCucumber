Feature: Test_De_Site_Cdiscount
  This feature deals with the login functionality, research article, article selection and add article

  Scenario Outline: Test Cdiscount Site
    Given Configuration Cdiscount Node with her IP address <NodeAddress>
    And Give Cdiscount link of site <SiteUrl>
    When Authentication on Cdiscount site with <UserName> and <PassWord>
    And Go to the basket
    And Valid the basket
    Then Process Done

    Examples:
      | NodeAddress                     | SiteUrl                    | UserName             | PassWord    |
      | http://172.20.10.2:5566/wd/hub | https://www.cdiscount.com/ | hamedbaba8@gmail.com | Babany@2391 |
      #| http://192.168.0.20:5566/wd/hub | https://www.cdiscount.com/ | hamedbaba8@gmail.com | Babany@2391 |

#  Scenario Outline: Fail authentication
#    Given  Configuration Cdiscount Node with her IP address <NodeAddress>
#    And Give Cdiscount link of site <SiteUrl>
#    When Authentication on Cdiscount site with <UserName> and <PassWord>
#    Then Fail connection <Message>
#    Examples:
#      | NodeAddress                     | SiteUrl                    | UserName             | PassWord | Message                          |
#      | http://192.168.0.20:5568/wd/hub | https://www.cdiscount.com/ | hamedbaba8@gmail.com |          | Veuillez entrer un mot de passe. |
