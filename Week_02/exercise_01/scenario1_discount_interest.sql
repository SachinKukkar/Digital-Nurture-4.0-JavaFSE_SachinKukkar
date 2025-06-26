SET SERVEROUTPUT ON;

DECLARE
    CURSOR cust_cursor IS
        SELECT CustomerID, DOB FROM Customers;

    v_age NUMBER;
BEGIN
    FOR cust_rec IN cust_cursor LOOP
        -- Calculate age
        v_age := FLOOR(MONTHS_BETWEEN(SYSDATE, cust_rec.DOB) / 12);

        IF v_age > 60 THEN
            -- Apply 1% discount to all loans of this customer
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = cust_rec.CustomerID;

            DBMS_OUTPUT.PUT_LINE('Discount applied to Customer ID ' || cust_rec.CustomerID || ' (Age: ' || v_age || ')');
        END IF;
    END LOOP;
END;
/
