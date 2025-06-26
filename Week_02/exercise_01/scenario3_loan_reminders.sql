SET SERVEROUTPUT ON;

DECLARE
    CURSOR loan_cursor IS
        SELECT LoanID, CustomerID, EndDate
        FROM Loans
        WHERE EndDate BETWEEN SYSDATE AND SYSDATE + 30;

    v_name VARCHAR2(100);
BEGIN
    FOR loan_rec IN loan_cursor LOOP
        -- Fetch customer name
        SELECT Name INTO v_name
        FROM Customers
        WHERE CustomerID = loan_rec.CustomerID;

        -- Print reminder
        DBMS_OUTPUT.PUT_LINE('Reminder: Loan ID ' || loan_rec.LoanID ||
                             ' for customer ' || v_name ||
                             ' is due on ' || TO_CHAR(loan_rec.EndDate, 'DD-Mon-YYYY'));
    END LOOP;
END;
/
