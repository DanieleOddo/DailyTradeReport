# Instruction Daily Trade Reporting Engine

## Note of Demo 
   This demo is written with Maven  & Java 1.8 
   I used Java 1.8 version for manage Date Instruction and used Stream
   I Used a Maven quickstart project with only Junit dependency 
   
## Input Instruction 
   I put input instruction in file ".csv" with all fields are String
   
## Working Day Engine
   I Convert Input Date and i check the currency for find a Correct workingDay
   I Dont check for Bank Holiday. 
   
## OutGoing Detail
   Inside "CreateListOutgoingDetails" is responsible of convert Instruction in Outgoing detail  

## Reporting 
   Inside "DailyTradeReportGenerator" is responsible of generating reports in Console. 
   This class use "CalculateDailyAmountService" --> to elaborate The statics of Amount everyday.
   This class use "CalculateDailyRankService" --> to elaborate the statics Rank of days.
   
## Instruction of This Demo
   Import a Maven Project inside Eclipse.
   The execution of App.java (Main of demo) java application read file input and produce report in console. 
 
## TDD - Test Drive Developed
   I create JUnit Test for all my class and in General Test Positive or Negative result. 