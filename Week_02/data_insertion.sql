-- Insert sample Customers
INSERT INTO Customers VALUES (1, 'John Doe', TO_DATE('1950-01-01', 'YYYY-MM-DD'), 12000, SYSDATE);
INSERT INTO Customers VALUES (2, 'Jane Smith', TO_DATE('1990-07-20', 'YYYY-MM-DD'), 8000, SYSDATE);
INSERT INTO Customers VALUES (3, 'Alice Cooper', TO_DATE('1962-09-25', 'YYYY-MM-DD'), 15000, SYSDATE);

-- Insert Accounts
INSERT INTO Accounts VALUES (1, 1, 'Savings', 10000, SYSDATE);
INSERT INTO Accounts VALUES (2, 2, 'Checking', 7000, SYSDATE);
INSERT INTO Accounts VALUES (3, 3, 'Savings', 20000, SYSDATE);

-- Insert Transactions
INSERT INTO Transactions VALUES (1, 1, SYSDATE, 500, 'Deposit');
INSERT INTO Transactions VALUES (2, 2, SYSDATE, 300, 'Withdrawal');

-- Insert Loans
INSERT INTO Loans VALUES (1, 1, 5000, 6.5, SYSDATE, ADD_MONTHS(SYSDATE, 60));
INSERT INTO Loans VALUES (2, 3, 10000, 7.2, SYSDATE, ADD_MONTHS(SYSDATE, 48));

-- Insert Employees
INSERT INTO Employees VALUES (1, 'Bob Thomas', 'Manager', 80000, 'HR', TO_DATE('2010-01-15', 'YYYY-MM-DD'));
INSERT INTO Employees VALUES (2, 'Sara Connor', 'Developer', 60000, 'IT', TO_DATE('2017-03-20', 'YYYY-MM-DD'));

COMMIT;