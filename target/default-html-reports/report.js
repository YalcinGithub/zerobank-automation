$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/FindTransactions.feature");
formatter.feature({
  "name": "Find Transactions in Account Activity",
  "description": "",
  "keyword": "Feature"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "the user accesses the Find Transactions tab",
  "keyword": "Given "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.FindTransactionsStepDefs.the_user_accesses_the_Find_Transactions_tab()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Search description case insensitive",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@wip"
    }
  ]
});
formatter.step({
  "name": "the user enters description \"ONLINE\"",
  "keyword": "When "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.FindTransactionsStepDefs.theUserEntersDescription(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "clicks search",
  "keyword": "And "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.FindTransactionsStepDefs.clicks_search()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "results table should only show descriptions containing \"ONLINE\"",
  "keyword": "Then "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.FindTransactionsStepDefs.resultsTableShouldOnlyShowDescriptionsContaining(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user enters description \"online\"",
  "keyword": "When "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.FindTransactionsStepDefs.theUserEntersDescription(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "clicks search",
  "keyword": "And "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.FindTransactionsStepDefs.clicks_search()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "results table should only show descriptions containing \"ONLINE\"",
  "keyword": "Then "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.FindTransactionsStepDefs.resultsTableShouldOnlyShowDescriptionsContaining(java.lang.String)"
});
formatter.result({
  "error_message": "java.lang.AssertionError\r\n\tat org.junit.Assert.fail(Assert.java:87)\r\n\tat org.junit.Assert.assertTrue(Assert.java:42)\r\n\tat org.junit.Assert.assertTrue(Assert.java:53)\r\n\tat com.zerobank.stepdefinitions.FindTransactionsStepDefs.resultsTableShouldOnlyShowDescriptionsContaining(FindTransactionsStepDefs.java:118)\r\n\tat ✽.results table should only show descriptions containing \"ONLINE\"(file:///C:/Users/admin/IdeaProjects/zerobank-automation/src/test/resources/features/FindTransactions.feature:33)\r\n",
  "status": "failed"
});
formatter.embedding("image/png", "embedded0.png", "screenshot");
formatter.after({
  "status": "passed"
});
});