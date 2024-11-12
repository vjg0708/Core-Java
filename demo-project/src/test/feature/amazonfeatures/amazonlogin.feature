@tag
  Feature: Amazon Workflow


    @tag1
    Scenario: Valid Login
      Given open the browser
      And navigate to the url
      When enter valid username and password
      And click the login button
      Then verify the login
      Given enter product name in search
      Then check whether the products are displayed

    @tag3
    Scenario: Invalid Login
      Given open the browser
      And navigate to the url
      When enter invalid username and password
      And click the login button
      Then  verify the login

