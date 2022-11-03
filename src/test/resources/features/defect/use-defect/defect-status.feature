Feature: Defect Status

#Declarative Style

    Scenario Outline: Change Status
        Given The tester is on the Home Page
        Then The tester can can see only defects assigned to them
        When The tester changes the defect to "<status>"
        Then The tester should see the defect has a "<status>" status

        Examples:
            | status   |
            | Accepted |
            | Rejected |
            | Fixed    |
            | Declined |
            | Shelved  |