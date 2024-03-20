SELECT * FROM employees;

SELECT COUNT(*) FROM EMployees; --집계함수 count sum avg min max

SELECT COUNT(distinct department_id) FROM EMPLOYEES;

Select e.first_name, e.last_name, e.salary,d.department_name from employees e, departments d where e.department_id = d.department_id;