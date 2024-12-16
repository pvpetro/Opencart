Feature: Login with Valid Credentials


  #Scenario: Successful Login with Valid Credentials
    #Given the user navigates to login page
    #When user enters email as "gomathykrishnan13@gmail.com" and password as "Gomathy@123"
    #And the user clicks on the Login button
    #Then the user should be redirected to the MyAccount Page
   
Scenario Outline: Login Data Driven
    Given the user navigates to login page
    When user enters email as "<email>" and password as "<password>"
    And the user clicks on the Login button
    Then the user should be redirected to the MyAccount Page
    
     Examples: 
      | email                     | password |
      | pavanol@gmail.com         | test123  |
      | gomathykrishnan13@gmail.com |Gomathy@123 |
      |abc@gmail.com               | abc@123|