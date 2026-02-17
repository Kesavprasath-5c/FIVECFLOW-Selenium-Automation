@tag
Feature: PreRead case activation and completion

@tag1
Scenario: Activate case
Given Login to Client Page and acivate a preRead case and get the order_ID

@tag2
Scenario: QC assign
  When Now assign the case to QC agent

@tag3
Scenario: PreadRead Reporting
And PreRead Reporting the case

