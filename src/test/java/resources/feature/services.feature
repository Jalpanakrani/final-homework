Feature: End to End testing of services data

  Scenario: Create a new services & verify if the services is added
    When    I sends the Post Request for create the services Data
    And     I insert the name "cash & carry"
    Then    I verify the status code 201 for services data
    And     I get the id of new created services data


  Scenario: Verify the services data are successfully created
    When I sends a GET request for fatching services data by given ID
    Then I verify the name is for created record "cash & carry" for services

  Scenario: Update the services data for given ID
    When    I send the Put Request for updating the services data
    And     I update the name "shop" for services
    Then    I verify the status code 200 for update services data
    And     I verify the name is "shop" for updating the services data

  Scenario: Delete the services data for given ID & verify the record are deleted successfully
    When    I sends the Delete Request for deleting the services  given ID
    Then    I verify the status code 200 for delete services data
    And     I get the data for deleted record ID for services data
    And     I verify the status code 404 for verifing the delete record for services

