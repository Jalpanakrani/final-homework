Feature: End to End testing of Stores data

  Scenario: Create a new Stores & verify if the Stores is added
    When    I sends the Post Request for create the Stores Data
    And     I insert the name ,type ,address,addresss ,city ,state ,zip ,lat ,lng ,hours
    Then    I verify the status code 201 for Stores data
    And     I get the id of new created Stores data


  Scenario: Verify the Stores data are successfully created
    When I sends a GET request for fatching Stores data by given ID
    Then I verify the name is for created record "VB & son's" for stores

  Scenario: Update the Stores data for given ID
    When    I send the Put Request for updating the Stores data
    And     I update the name "shop",type "Cash & carry",address "Tooting" for stores
    Then    I verify the status code 200 for update Stores data
    And     I verify the name is "shop" for updating the Stores data

  Scenario: Delete the stores data for given ID & verify the record are deleted successfully
    When    I sends the Delete Request for deleting the Stores  given ID
    Then    I verify the status code 200 for delete Stores data
    And     I get the data for deleted record ID for Stores data
    And     I verify the status code 404 for verifing the delete record for stores


