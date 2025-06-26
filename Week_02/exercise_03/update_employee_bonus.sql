CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department IN VARCHAR2,
    p_bonus_percent IN NUMBER
) IS
BEGIN
    FOR emp_rec IN (
        SELECT EmployeeID, Salary
        FROM Employees
        WHERE Department = p_department
    ) LOOP
        -- Apply bonus to salary
        UPDATE Employees
        SET Salary = emp_rec.Salary + (emp_rec.Salary * p_bonus_percent / 100)
        WHERE EmployeeID = emp_rec.EmployeeID;

        DBMS_OUTPUT.PUT_LINE('Bonus applied to Employee ID: ' || emp_rec.EmployeeID);
    END LOOP;

    COMMIT;
END;
/
