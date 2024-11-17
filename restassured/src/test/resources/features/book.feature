Feature: Book API Management

  Scenario: Create a new Book
    Given enter the post request url
    And add book details
    When post the Book details
    Then validate the status code
    And validate the price
    And validate the author

  Scenario: Get Book details
    Given enter the get request url
    When get the book details


  Scenario: Update single data in Book details
    Given enter the patch request url
    And update the data in book details
    When patch the book details

  Scenario: Delete the Book details
    Given enter the delete request url
    Then validate the status code