Feature: DuckDuckGo Search
Scenario: Search phrase in https://duckduckgo.com/
Given Web page https://duckduckgo.com opened in browser
When Search phrase 'W pustyni i w puszczy' entered in search input box
And Search button clicked
Then First 3 results contain phrase 'W pustyni i w puszczy'