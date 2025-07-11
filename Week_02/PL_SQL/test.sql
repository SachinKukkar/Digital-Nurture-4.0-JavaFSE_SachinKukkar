BEGIN
    ProcessMonthlyInterest;
END;
/
SELECT * FROM Accounts WHERE AccountType = 'Savings';


BEGIN
    UpdateEmployeeBonus('HR', 10);  -- Give 10% bonus to HR employees
END;
/

-- Check changes:
SELECT * FROM Employees WHERE Department = 'HR';
BEGIN
    UpdateEmployeeBonus('IT', 5);  -- 5% bonus to IT employees
END;
/

SELECT * FROM Employees WHERE Department = 'IT';




BEGIN
    TransferFunds(3, 1, 1000);  -- Transfer ₹1000 from Account 3 to 1
END;
/

-- Verify balances
SELECT * FROM Accounts WHERE AccountID IN (1, 3);
BEGIN
    TransferFunds(2, 1, 999999);  -- Should raise insufficient balance error
END;



DECLARE
    v_age NUMBER;
BEGIN
    v_age := CalculateAge(TO_DATE('1990-07-20', 'YYYY-MM-DD'));
    DBMS_OUTPUT.PUT_LINE('Age is: ' || v_age);
END;
/
SELECT Name, DOB, CalculateAge(DOB) AS Age
FROM Customers;


DECLARE
    v_emi NUMBER;
BEGIN
    v_emi := CalculateMonthlyInstallment(50000, 7.5, 5);
    DBMS_OUTPUT.PUT_LINE('Monthly EMI is: ₹' || v_emi);
END;
/


DECLARE
    result BOOLEAN;
BEGIN
    result := HasSufficientBalance(1, 500);
    IF result THEN
        DBMS_OUTPUT.PUT_LINE('Sufficient balance.');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Insufficient balance.');
    END IF;
END;
/


UPDATE Customers
SET Balance = Balance + 500
WHERE CustomerID = 1;

COMMIT;

SELECT CustomerID, Name, LastModified
FROM Customers
WHERE CustomerID = 1;



CREATE TABLE AuditLog (
    LogID NUMBER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    TransactionID NUMBER,
    AccountID NUMBER,
    Amount NUMBER,
    TransactionType VARCHAR2(10),
    LoggedAt DATE DEFAULT SYSDATE
);



INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (3, 1, SYSDATE, 250, 'Deposit');

COMMIT;
SELECT * FROM AuditLog WHERE TransactionID = 3;


SELECT trigger_name, status
FROM user_triggers
WHERE table_name = 'TRANSACTIONS';
SELECT * FROM Transactions WHERE TransactionID = 3;


INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (4, 2, SYSDATE, 150, 'Withdrawal');

COMMIT;
SELECT * FROM AuditLog WHERE TransactionID = 4;
SELECT * FROM USER_ERRORS WHERE NAME = 'LOGTRANSACTION';


INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (5, 1, SYSDATE, 200, 'Deposit');

COMMIT;

INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (6, 1, SYSDATE, 0, 'Deposit');


BEGIN
    AccountOperations.OpenAccount(100, 1, 'Savings', 3000);
    DBMS_OUTPUT.PUT_LINE('Total Balance: ₹' || AccountOperations.GetTotalBalanceByCustomer(1));
    AccountOperations.CloseAccount(100);
END;
/
