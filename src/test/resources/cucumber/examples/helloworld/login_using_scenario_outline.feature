Feature: Logging In using Scenario Outline

Scenario Outline: Users are greeted after logging in 
	Given I provide "<login>" and "<password>"
		
	When I login with the provided details
	
	Then login greeting should mention "<fullName>" <lastSeen> <repPoints> 
	
Examples:
        | login             | password  |   fullName            | lastSeen          | repPoints |
        | ralph@email.com   | 123       |   Ralph Malph         | 20130619          | 15        |
        | potsie@email.com  | 234       |   Potsie Webber       | 20130617          | 19        |
        | richie@email.org  | 456       |   Richie Cunningham   | 20130613          | 21        |