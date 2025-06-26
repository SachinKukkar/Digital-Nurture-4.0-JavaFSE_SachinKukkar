CREATE OR REPLACE PROCEDURE AddNewCustomer (
    p_customer_id IN NUMBER,
    p_name IN VARCHAR2,
    p_dob IN DATE,
    p_balance IN NUMBER
) IS
    v_error_message VARCHAR2(4000);
BEGIN
    -- Insert new customer
    INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
    VALUES (p_customer_id, p_name, p_dob, p_balance, SYSDATE);

    DBMS_OUTPUT.PUT_LINE('Customer added successfully: ' || p_name);
    COMMIT;

EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        v_error_message := 'Customer ID ' || p_customer_id || ' already exists.';
        INSERT INTO ErrorLog (ErrorMessage) VALUES (v_error_message);
        DBMS_OUTPUT.PUT_LINE(v_error_message);

    WHEN OTHERS THEN
        v_error_message := SQLERRM;
        INSERT INTO ErrorLog (ErrorMessage) VALUES (v_error_message);
        DBMS_OUTPUT.PUT_LINE('Other error: ' || v_error_message);
        ROLLBACK;
END;
/


BEGIN
    AddNewCustomer(4, 'Clark Kent', TO_DATE('1985-06-18', 'YYYY-MM-DD'), 15000);
END;
/

-- Check error log
SELECT * FROM ErrorLog;
