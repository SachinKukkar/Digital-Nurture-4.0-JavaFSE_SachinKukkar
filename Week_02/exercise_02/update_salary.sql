CREATE OR REPLACE PROCEDURE UpdateSalary (
    p_employee_id IN NUMBER,
    p_percent IN NUMBER
) IS
    v_current_salary NUMBER;
    v_error_message VARCHAR2(4000);
BEGIN
    -- Get current salary
    SELECT Salary INTO v_current_salary
    FROM Employees
    WHERE EmployeeID = p_employee_id;

    -- Update salary
    UPDATE Employees
    SET Salary = v_current_salary + (v_current_salary * p_percent / 100)
    WHERE EmployeeID = p_employee_id;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Salary updated successfully for employee ID ' || p_employee_id);

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        v_error_message := 'Employee ID ' || p_employee_id || ' not found.';
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
    UpdateSalary(1, 10);  -- 10% hike for employee ID 1
END;
/

-- Verify
SELECT * FROM Employees WHERE EmployeeID = 1;


BEGIN
    UpdateSalary(999, 10);  -- This ID doesn't exist
END;
/

