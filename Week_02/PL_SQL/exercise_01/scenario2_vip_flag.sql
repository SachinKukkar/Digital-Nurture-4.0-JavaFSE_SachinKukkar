SET SERVEROUTPUT ON;

BEGIN
    FOR cust_rec IN (
        SELECT CustomerID, Balance FROM Customers
    ) LOOP
        IF cust_rec.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = cust_rec.CustomerID;

            DBMS_OUTPUT.PUT_LINE('Promoted to VIP: Customer ' || cust_rec.CustomerID);
        END IF;
    END LOOP;

    COMMIT;
END;
/
