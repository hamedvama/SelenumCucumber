Feature: Test_SNCF_Site

  Scenario Outline: Test_SNCF
    Given Setting Environment with IP node <NodeAddress> and Site Url <linkSite>
    And Authentication on SNCF site with UserName <user> and PassWord <password>
    Then User login successful
    Examples:
      | NodeAddress                    | linkSite              | user                 | password   |
      | http://192.168.0.20:5566/wd/hub | https://www.oui.sncf/ | hamedbaba8@gmail.com | Babany1991 |
      #| http://172.20.10.2:5566/wd/hub | https://www.oui.sncf/ | hamedbaba8@gmail.com | Babany1991 |
