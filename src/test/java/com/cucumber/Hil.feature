@tag
Feature: Hil case activation and completion

@tag1
Scenario: Activate the Hil case
Given Login to the client page and activate the Hil case and get the order_ID

@tag2
Scenario: Assign to Hil agent
When case is in the hil pool assign the case to Hil agent

@tag3
Scenario: Hil Reporting
Then report the assigned Hil case