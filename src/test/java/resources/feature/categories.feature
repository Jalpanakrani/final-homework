Feature: End to End testing of Categories data

  Scenario: Create a new Categories & verify if the Categories is added
    When    I sends the Post Request for create the Categories Data
    And     I insert the name "cash & carry",id "ABC"
    Then    I verify the status code 201 for categories data
    And     I get the id of new created Categories data


  Scenario: Verify the Categories data are successfully created
    When I sends a GET request for fatching Categories data by given ID
    Then I verify the name is for created record "cash & carry"

  Scenario: Update the Categories data for given ID
    When    I send the Put Request for updating the Categories data
    And     I update the name "shop"
    Then    I verify the status code 200 for update categories data
    And     I verify the name is "shop" for updating the categories data

  Scenario: Delete the Prodct data for given ID & verify the record are deleted successfully
    When    I sends the Delete Request for deleting the Categories  given ID
    Then    I verify the status code 200 for delete categories data
    And     I get the data for deleted record ID for categories data
    And     I verify the status code 404 for verifing the delete record





