Feature: Test_Corsair_Site
  write test for connect on the site and search a trip

  Scenario Outline: Setting environment
    Given Set execution IP node <Node>
    And Set url site <UrlSite>
    When Configure environment
    Then navigation available a ce lien <message>
    Examples:
      | Node                            | UrlSite               | message               |
      | http://172.20.10.2:5568/wd/hub | https://www.oui.sncf/ | https://www.oui.sncf/ |
      #| http://172.20.10.2:5568/wd/hub | https://www.corsair.fr/ | https://www.corsair.fr/ |


#  Scenario Outline: Authentication on the site
#    Given send elements <UserName> and <PassWord>
#    When Try to authenticate
#    Then User login successful
#    Examples:
#      | UserName             | PassWord   |
#      | hamedbaba8@gmail.com | Babany1991 |
#      | hamedbaba8@gmail.com | Babany@2391 |

#  Scenario: Setting environment
#    Given Set execution IP node http://192.168.0.20:5568/wd/hub
#    And Set url site https://www.corsair.fr/
#    When Configure environment
#    Then navigation available a ce lien https://www.corsair.fr/

