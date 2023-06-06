# Spending-Tracker

Spending Tracker Rest API allows the user to:
- track incomings and expenses for a given month
- displaying the monthly balance
- editing and adding categories

# Endpoints

1. Operations

GET http://localhost:8080/operations - return a list of all operations in descending order (parameters - year and month)

GET http://localhost:8080/operations/1 - return single operation

GET http://localhost:8080/operations/balance - return balance (parameters - year and month)

POST http://localhost:8080/operations/1 - add single operation

PUT http://localhost:8080/operations/1 - update single operation

DELETE http://localhost:8080/operations/1 - delete single operation

2. Categories

GET http://localhost:8080/categories - return a list of all categories

GET http://localhost:8080/categories/1 - return single category

POST http://localhost:8080/categories/1 - add single category

PUT http://localhost:8080/categories/1 - update single category

DELETE http://localhost:8080/categories/1 - delete single category

3. Authentication

POST http://localhost:8080/auth/register - user registrations

POST http://localhost:8080/auth/authenticate - user authentication
