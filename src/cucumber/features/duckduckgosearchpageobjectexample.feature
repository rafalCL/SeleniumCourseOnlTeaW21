Feature: Text search with DuckDuckGo

  Scenario Outline: Successful search
    Given 2Browser with open page at address https://duckduckgo.com
    When 2Entered <searchPhrase> in the search input box
    And 2Search button (magnifying glass) clicked
    Then 2First <meaningfulSearchResultCount> search results contain phrase: <searchPhrase>
    And Save screenshot
    And Close browser
Examples:
    |searchPhrase          |meaningfulSearchResultCount|
    |Henryk Sienkiewicz    |5                          |
    |Maria Skłodowska-Curie|2                          |
    |Andrzej Bobkowski     |4                          |
    |ALF                   |3                          |