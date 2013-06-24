Feature: Logging In 

Scenario: Users are greeted after logging in 
	Given I provide logindetails
		| login           | password |
		| aslak@email.com | 123   |
		| joe@email.com   | 234   |
		| bryan@email.org | 456   |
		
	When I login 
	
	Then I should see fullname greeting 
		| fullname   		| lastseen |
		| Aslak Hellesoy	| 20130619 |
		| Joe Bloggs 		| 20130617 |
		| Bryan Jones 		| 20130613 |