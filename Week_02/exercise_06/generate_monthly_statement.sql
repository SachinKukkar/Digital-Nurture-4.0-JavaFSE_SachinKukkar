SET SERVEROUTPUT ON;

DECLARE
    CURSOR txn_cursor IS
        SELECT t.TransactionID, t.AccountID, t.TransactionDate, t.Amount, t.TransactionType,
               c.Name AS CustomerName
        FROM Transactions t
        JOIN Accounts a ON t.AccountID = a.AccountID
        JOIN Customers c ON a.CustomerID = c.CustomerID
        WHERE TRUNC(t.TransactionDate, 'MM') = TRUNC(SYSDATE, 'MM'); -- current month

BEGIN
    FOR txn_rec IN txn_cursor LOOP
        DBMS_OUTPUT.PUT_LINE(
            'Customer: ' || txn_rec.CustomerName ||
            ' | Transaction ID: ' || txn_rec.TransactionID ||
            ' | Account ID: ' || txn_rec.AccountID ||
            ' | Amount: ' || txn_rec.Amount ||
            ' | Type: ' || txn_rec.TransactionType ||
            ' | Date: ' || TO_CHAR(txn_rec.TransactionDate, 'DD-Mon-YYYY')
        );
    END LOOP;
END;
/
