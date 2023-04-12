# Spending-Tracker

Rest API allowing the user to:
- track incomings and expenses for a given month
- displaying the monthly balance
- editing and adding categories
- displaying expenses for a given category

# Endpoints

GET http://localhost:8080/operations - return a list of all operations in chronological order

GET http://localhost:8080/operations?year=2023&month=1 - returns a list of operations in the selected month in a chronological order

GET http://localhost:8080/operations/1 - return single operation

GET http://localhost:8080/operations/balance - return balance

GET http://localhost:8080/operations/balance?year=2023&month=1 - return balance in the selected month

POST http://localhost:8080/operations/1 - add single operation

PUT http://localhost:8080/operations/1 - update single operation

DELETE http://localhost:8080/operations/1 - delete single operation



GET http://localhost:8080/categories - return a list of all categories

GET http://localhost:8080/categories/1 - return single category

POST http://localhost:8080/categories/1 - add single category

PUT http://localhost:8080/categories/1 - update single category

DELETE http://localhost:8080/categories/1 - delete single category
