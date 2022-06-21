Feature: End to End testing of Product data

  Scenario: Create a new Products & verify if the Product is added
    When    I sends the Post Request for create the Product Data
    And     I enter name,type,price,shipping,upc,description,manufacturer,model,url,image
    Then    I verify the status code 201
    And     I get the id of new created product data


  Scenario: Verify the Product data are successfully created
    When I sends a GET request for fatching product data by given ID
    Then I verify the name

  Scenario: Update the product data for given ID
    When    I send the Put Request for updating the Product data
    And     I update the name,type ,price ,shipping
    Then    I verify the status code for update 200
    And     I verify the name is "asus" for updating the record

  Scenario: Delete the Prodct data for given ID & verify the record are deleted successfully
    When    I sends the Delete Request for deleting the product  given ID
    Then    I verify the status code for delete 200
    And     I get the data for deleted record ID
    And     I verify the status code for delete verify 404




