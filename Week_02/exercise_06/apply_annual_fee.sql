SET SERVEROUTPUT ON;

DECLARE
    CURSOR acc_cursor IS
        SELECT AccountID, Balance
        FROM Accounts;

    v_fee NUMBER := 200;
BEGIN
    FOR acc_rec IN acc_cursor LOOP
        -- Deduct annual fee
        UPDATE Accounts
        SET Balance = Balance - v_fee
        WHERE AccountID = acc_rec.AccountID;

        DBMS_OUTPUT.PUT_LINE(
            'Annual fee of ₹' || v_fee || ' deducted from Account ID: ' || acc_rec.AccountID
        );
    END LOOP;

    COMMIT;
END;
/
