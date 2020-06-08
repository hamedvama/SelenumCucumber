Feature: Test_Corsair_Site
  write test for connect on the site and search a trip

  Scenario Outline: Test on Corsair Site
    Given Set execution IP node <Node>
    And Set url site <UrlSite>
    When Configure environment
    Then Navigation available
    And Authentication on Corsair site with UserName <user> and PassWord <password>
    Then Authentication successful
    #When Choose destination

    Examples:
      | Node                            | UrlSite                 | user                 | password   |
      | http://172.20.10.2:5568/wd/hub | https://www.corsair.fr/ |hamedbaba8@gmail.com | Babany@2391 |
      #| http://192.168.0.20:5568/wd/hub | https://www.corsair.fr/ | hamedbaba8@gmail.com | Babany@2391 |


