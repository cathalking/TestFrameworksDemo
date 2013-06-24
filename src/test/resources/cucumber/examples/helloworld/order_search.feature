@ignore
Feature: Order Search 
# Background: As a regular user I want to

Scenario: Search for orders using range of core search criteria 
	Given I provide following search criteria 
| Account 	| FirmCode 	| Session 	| Contract 	| BrokerCode 	| ClientOrdId 	| TradeDate |
| accountA 	| firmA 	| sessionA 	| ABC 		| brokerA 		| clOrd1 		| 20130622 |
| accountB 	| firmB 	| sessionB 	| DEF 		| brokerB 		| clOrd2 		| 20130622 | 
| accountC 	| firmC 	| sessionC 	| GHI 		| brokerC 		| clOrd3 		| 20130622 | 
| accountD 	| firmD 	| sessionD 	| JKL 		| brokerD 		| clOrd4 		| 20130622 |
		
	When I run the search 
	
	Then I should see the following search results 
| Account 	| FirmCode 	| Session 	| Contract 	| BrokerCode 	| ClientOrdId 	| TradeDate | OrderQty 	| RmgQty 	| OrderPrice 	| Exchange 	| Status 	| Type |
| accountA 	| firmA 	| sessionA 	| ABC 		| brokerA 		| clOrd1 		| 20130622 	| 9500 		| 9300 		| 1.5 			| CBOT 		| Working 	| Limit |
| accountB 	| firmB 	| sessionB 	| DEF 		| brokerB 		| clOrd2 		| 20130622 	| 8500 		| 8300 		| 2 			| CME 		| Pending 	| Market |
| accountC 	| firmC 	| sessionC 	| GHI 		| brokerC 		| clOrd3 		| 20130622 	| 7500 		| 7300 		| 2.5 			| CMEL 		| Cxled 	| FoK |
| accountD 	| firmD 	| sessionD 	| JKL 		| brokerD 		| clOrd4 		| 20130622 	| 6500 		| 6300 		| 3 			| NYMX 		| Rejected 	| GTC |