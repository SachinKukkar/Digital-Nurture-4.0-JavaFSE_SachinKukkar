CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS

    PROCEDURE HireEmployee (
        p_employee_id IN NUMBER,
        p_name IN VARCHAR2,
        p_position IN VARCHAR2,
        p_salary IN NUMBER,
        p_department IN VARCHAR2,
        p_hire_date IN DATE
    ) IS
    BEGIN
        INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
        VALUES (p_employee_id, p_name, p_position, p_salary, p_department, p_hire_date);
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Employee hired: ' || p_name);
    END;

    PROCEDURE UpdateEmployeeDetails (
        p_employee_id IN NUMBER,
        p_salary IN NUMBER,
        p_position IN VARCHAR2
    ) IS
    BEGIN
        UPDATE Employees
        SET Salary = p_salary,
            Position = p_position
        WHERE EmployeeID = p_employee_id;
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Employee updated: ID ' || p_employee_id);
    END;

    FUNCTION CalculateAnnualSalary (
        p_employee_id IN NUMBER
    ) RETURN NUMBER IS
        v_salary NUMBER;
    BEGIN
        SELECT Salary INTO v_salary
        FROM Employees
        WHERE EmployeeID = p_employee_id;
        RETURN v_salary * 12;
    END;

END EmployeeManagement;
/

