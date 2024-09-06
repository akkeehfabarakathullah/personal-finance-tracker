# personal Finance Tracker Application

## Overview

The Personal Finance Tracker Application is a Java Spring Boot-based web application designed to help users manage their personal finances. The application allows users to track their income and expenses, categorize transactions, and view financial summaries.

## Features

- *User Registration and Login*: Users can register and log in to manage their financial data.
- *Transaction Management*: Users can add, view, and filter transactions.
- *Category Management*: Users can create, update, and delete categories for transactions.
- *Dashboard*: Provides an overview of total income, total expenses, and recent transactions.

## Technologies Used

- *Spring Boot*: Framework for building the backend of the application.
- *Spring Data JPA*: ORM for data persistence.
- *Thymeleaf*: Template engine for rendering HTML views.
- *Bootstrap*: CSS framework for responsive design.


## Project Structure

### 1. *Controllers*

- *HomeController*: Handles routing and user interactions for home, dashboard, transactions, categories, and user-related actions.

### 2. *Entities*

- *Category*: Represents a category for transactions (e.g., income, expense).
- *Transaction*: Represents a financial transaction with attributes like amount, description, and category.
- *User*: Stores user information including username, password, and email.

### 3. *Repositories*

- *CategoryRepository*: Interface for CRUD operations on Category entities.
- *TransactionRepository*: Interface for CRUD operations on Transaction entities.
- *UserRepository*: Interface for CRUD operations on User entities.

### 4. *Services*

- *CategoryService*: Manages category-related operations.
- *TransactionService*: Handles transaction operations.
- *DashboardService*: Provides financial metrics for the dashboard.
- *UserService*: Manages user-related operations.

### 5. *Enums*

- *CategoryType*: Enum for category types (e.g., INCOME, EXPENSE).
- *TransactionType*: Enum for transaction types (e.g., INCOME, EXPENSE).

## Setup and Installation

- *Java 11+*: Ensure that Java is installed on your machine.
- *Maven*: Dependency management and build tool.

### Installation Steps

 Go to you your web page and search
http://localhost:8080/user /registration 

Go to /user/register to create a new account.

User Login:- Go to /user/login to log in with your credentials.

Dashboard:- Access the dashboard at /new/dashboard to view financial summaries.

TAdd a new transaction at /transactions/new.

View transaction history at /transactions/history.

CategoriesManage categories at /categories.


