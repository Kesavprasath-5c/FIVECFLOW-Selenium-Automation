@tag
Feature: Nomral case completion via Rad and QC 

@tag1
Scenario: Activate case
  Given Login to Client Page and acivate the case and get the order_ID

@tag2
Scenario: Assign to rad
  When Assign the case to rad

@tag3
Scenario:  Rad reporting
  And Report the case by raddiologits

@tag4
Scenario: QC assign
  And Now assign the case to QC agent

@tag5
Scenario: QC submit
  Then Submit the case via QC agent
  