$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Cdiscount.feature");
formatter.feature({
  "line": 1,
  "name": "Test_De_Site",
  "description": "This feature deals with the login functionality, research article, article selection and add article",
  "id": "test-de-site",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 4,
  "name": "Test Cdiscount Site",
  "description": "",
  "id": "test-de-site;test-cdiscount-site",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "Configuration Cdiscount Node with her IP address \u003cNodeAddress\u003e",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "give Cdiscount link of site \u003cSiteUrl\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "Authentication on Cdiscount site with \u003cUserName\u003e and \u003cPassWord\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Connection Okay",
  "keyword": "Then "
});
formatter.examples({
  "line": 10,
  "name": "",
  "description": "",
  "id": "test-de-site;test-cdiscount-site;",
  "rows": [
    {
      "cells": [
        "NodeAddress",
        "SiteUrl",
        "UserName",
        "PassWord"
      ],
      "line": 11,
      "id": "test-de-site;test-cdiscount-site;;1"
    },
    {
      "cells": [
        "http://192.168.0.20:5568/wd/hub",
        "https://www.cdiscount.com/",
        "hamedbaba8@gmail.com",
        "Babany@1991"
      ],
      "line": 12,
      "id": "test-de-site;test-cdiscount-site;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 626800,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "Test Cdiscount Site",
  "description": "",
  "id": "test-de-site;test-cdiscount-site;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "Configuration Cdiscount Node with her IP address http://192.168.0.20:5568/wd/hub",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "give Cdiscount link of site https://www.cdiscount.com/",
  "matchedColumns": [
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "Authentication on Cdiscount site with hamedbaba8@gmail.com and Babany@1991",
  "matchedColumns": [
    2,
    3
  ],
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Connection Okay",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "http://192.168.0.20:5568/wd/hub",
      "offset": 49
    }
  ],
  "location": "CdiscountSteps.configurationCdiscountNodeWithHerIPAddressNodeAddress(String)"
});
formatter.result({
  "duration": 3227579100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "https://www.cdiscount.com/",
      "offset": 28
    }
  ],
  "location": "CdiscountSteps.giveCdiscountLinkOfSiteSiteUrl(String)"
});
formatter.result({
  "duration": 2492326800,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "hamedbaba8@gmail.com",
      "offset": 38
    },
    {
      "val": "Babany@1991",
      "offset": 63
    }
  ],
  "location": "CdiscountSteps.authenticationOnCdiscountSiteWithUserNameAndPassWord(String,String)"
});
formatter.result({
  "duration": 23293430400,
  "status": "passed"
});
formatter.match({
  "location": "NewtoursDemoAut.connectionOkay()"
});
formatter.result({
  "duration": 203200,
  "status": "passed"
});
formatter.after({
  "duration": 133800,
  "status": "passed"
});
formatter.uri("NewtoursDemoAut.feature");
formatter.feature({
  "line": 1,
  "name": "Test_De_Site",
  "description": "This feature deals with the login functionality, research article, article selection and add article",
  "id": "test-de-site",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 4,
  "name": "Test Newtours Site",
  "description": "",
  "id": "test-de-site;test-newtours-site",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "Configuration Node with her IP address \u003cNodeAddress\u003e",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "give link of site \u003cSiteUrl\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "Authentication with \u003cuserName\u003e and \u003cpassword\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Connection Okay",
  "keyword": "Then "
});
formatter.examples({
  "line": 10,
  "name": "",
  "description": "",
  "id": "test-de-site;test-newtours-site;",
  "rows": [
    {
      "cells": [
        "NodeAddress",
        "SiteUrl",
        "userName",
        "password"
      ],
      "line": 11,
      "id": "test-de-site;test-newtours-site;;1"
    },
    {
      "cells": [
        "http://192.168.0.20:5566/wd/hub",
        "http://newtours.demoaut.com/",
        "mercury",
        "mercury"
      ],
      "line": 12,
      "id": "test-de-site;test-newtours-site;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 99600,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "Test Newtours Site",
  "description": "",
  "id": "test-de-site;test-newtours-site;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "Configuration Node with her IP address http://192.168.0.20:5566/wd/hub",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "give link of site http://newtours.demoaut.com/",
  "matchedColumns": [
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "Authentication with mercury and mercury",
  "matchedColumns": [
    2,
    3
  ],
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Connection Okay",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "http://192.168.0.20:5566/wd/hub",
      "offset": 39
    }
  ],
  "location": "NewtoursDemoAut.configurationNodeWithHerIPAddressNode(String)"
});
formatter.result({
  "duration": 2799839300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "http://newtours.demoaut.com/",
      "offset": 18
    }
  ],
  "location": "NewtoursDemoAut.giveLinkOfSiteSiteUrl(String)"
});
formatter.result({
  "duration": 2054313200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "mercury",
      "offset": 20
    },
    {
      "val": "mercury",
      "offset": 32
    }
  ],
  "location": "NewtoursDemoAut.authenticationWithUserNameAndPassWord(String,String)"
});
formatter.result({
  "duration": 7080326200,
  "status": "passed"
});
formatter.match({
  "location": "NewtoursDemoAut.connectionOkay()"
});
formatter.result({
  "duration": 51700,
  "status": "passed"
});
formatter.after({
  "duration": 131000,
  "status": "passed"
});
});