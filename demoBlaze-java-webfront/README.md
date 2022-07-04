## To launch all the features, is necessary execute the next command in the 'path' where its found ./pom.xml

` mvn clean test -Dcucumber.filter.tags="@all" `

## To launch a specific test, is necessary execute the next command in the 'path' where its found ./pom.xml

` mvn clean test -Dcucumber.filter.tags="@DemoBlaze_001" `

## Reports are saved in an automatically generated URL (example: https://reports.cucumber.io/reports/{id}), that can be viewed in the output console. This report will self-destruct in a day.
