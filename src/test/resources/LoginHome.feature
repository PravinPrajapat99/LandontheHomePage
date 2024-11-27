Feature: verify the login and search for document

  Scenario Outline: check login is successful with given username and password
    Given user is on login page
    When user enter "<username>" and "<password>"
    And click on login button
    Then check if it is navigated to home page
    Examples:
      | username                     | password  |
      | admin@qaef-appcontrol-vf.com | vv00Zle11 |

  Scenario Outline: check if the document with given name is present or not
    Given user is in home page
    Then verify the user
    Then navigate to library section
    Then get the search bar
    When user enter document "<DocName>"
    When click search button
    Then check if it present
    Examples:
      | DocName   |
      | 277 pages|
