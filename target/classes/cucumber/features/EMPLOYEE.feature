Feature: EMPLOYEE CRUD Operation

Background:
Given Set the endpoint for EMPLOYEE
And Set the authentication for EMPLOYEE

Scenario: TC001 Create new with request body
Given Set the request header content-type in the create EMPLOYEE request
And Set the request body as 'CreateEMPLOYEE' in the create EMPLOYEE request
When User send the POST request to EMPLOYEE
Then Validate the status code as 201 in the create EMPLOYEE request

Scenario: TC002 Update new with request body
Given Set the request header content-type in the update EMPLOYEE request
And Set the request body as 'UpdateEMPLOYEE' in the update EMPLOYEE request
When User send the PUT request to EMPLOYEE
Then Validate the status code as 200 in the update EMPLOYEE request

Scenario: TC003 Get Particular Id
When User send the Particular Get request to EMPLOYEE request
Then Validate the status code as 200 in the Get EMPLOYEE request

Scenario: TC004 Get All EMPLOYEES
When User send the Get All request
Then Validate the status code as 200 in the Get EMPLOYEES request

Scenario: TC005 Delete Particular Id
When User send the Particular Delete request to EMPLOYEE request
Then Validate the status code as 200 in the Delete EMPLOYEE request

Examples:
|fileName1|
|'CreateEMPLOYEE'|
|'UpdateEMPLOYEE'|