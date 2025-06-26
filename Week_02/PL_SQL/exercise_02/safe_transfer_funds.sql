CREATE OR REPLACE PROCEDURE SafeTransferFunds (
    p_from_account_id IN NUMBER,
    p_to_account_id IN NUMBER,
    p_amount IN NUMBER
) IS
    v_balance NUMBER;
    v_error_message VARCHAR2(4000);
BEGIN
    -- Check source account balance
    SELECT Balance INTO v_balance
    FROM Accounts
    WHERE AccountID = p_from_account_id;

    IF v_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds in source account.');
    END IF;

    -- Deduct from source
    UPDATE Accounts
    SET Balance = Balance - p_amount
    WHERE AccountID = p_from_account_id;

    -- Add to destination
    UPDATE Accounts
    SET Balance = Balance + p_amount
    WHERE AccountID = p_to_account_id;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Transfer successful.');

EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        v_error_message := SQLERRM;
        INSERT INTO ErrorLog (ErrorMessage) VALUES (v_error_message);
        DBMS_OUTPUT.PUT_LINE('Error occurred: ' || v_error_message);
END;
/

BEGIN
    SafeTransferFunds(3, 2, 2000);
END;
/

BEGIN
    SafeTransferFunds(2, 3, 999999);
END;
/
