#!/bin/bash

# Step 1: Run Maven tests
echo "Running Maven tests..."
mvn clean test

# Step 2: Generate Allure report
echo "Generating Allure report..."
allure serve allure-results

# Step 3: Clean up project directories
echo "Cleaning up project directories..."
rm -rf .idea

# Step 4: Run Maven clean
echo "Running Maven clean..."
mvn clean

echo "Automated Test Execution completed."
