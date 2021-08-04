Feature: Verify Products Page

    Background:
      Given Open the browser
      When Open the website "https://aspiration.com/"
      Then click on products page via "Spend & Save" link in home page
  @all
  Scenario: Successful Navigation from home to Products Page
    Then verify if the products page opened successfully or not
    And verify if you are able to see the products in the web page
    And close the browser

    @all
    Scenario: verify  if you are able to see 2  products
      Then verify if you are able to see products "Aspiration" and  "Aspiration Plus" in the products page
      And close the browser

      @all
      Scenario: click on Get Aspiration button
        Then click on "GET ASPIRATION" button
        And verify if the email signup textbox appears
        And  close the browser

        @all
        Scenario Outline: click on Get Aspiration Plus button
          Then click on "GET ASPIRATION PLUS" button
          Then verify that a modal with monthly and yearly plan appears
          And verify that "<type>" radio option is "<value>" paid once
          And close the browser
          Examples:
              |type|value|
              |Yearly|$71.88|
              |Monthly|$7.99|



