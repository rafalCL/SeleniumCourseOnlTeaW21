Feature: Text search with DuckDuckGo

  Scenario: Successful search
  Given Browser with open page at address https://duckduckgo.com
  When Entered Henryk Sienkiewicz in the search input box
  And Search button (magnifying glass) clicked
  Then First 3 search results contain phrase: Henryk Sienkiewicz

#    above scenario is kept for comparison
#    to below parametrized scenario

  Scenario Outline: Successful search parametrized
    Given Browser with open page at address https://duckduckgo.com
    When Entered <searchPhrase> in the search input box
    And Search button (magnifying glass) clicked
    Then First <meaningfulSearchResultCount> search results contain phrase: <searchPhrase>
Examples:
    |searchPhrase          |meaningfulSearchResultCount|
    |Henryk Sienkiewicz    |5                          |
    |Maria Skłodowska-Curie|2                          |
    |Andrzej Bobkowski     |4                          |
    |ALF                   |3                          |