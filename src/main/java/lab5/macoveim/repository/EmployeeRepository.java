package lab5.macoveim.repository;

import lab5.macoveim.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Employee> findAll() {
        return jdbcTemplate.query(
                "SELECT* FROM employee",
                (response, rowNumber) ->
                        new Employee(response.getInt("id_employee"),
                                response.getLong("id_organisation"),
                                response.getString("last_name"),
                                response.getString("first_name"),
                                response.getDate("birthday")));
    }

    public void save(Employee employee) {

        jdbcTemplate.update(
                "INSERT INTO employee (last_name,first_name,birthday,id_organisation) VALUES(?,?,?,?)",
                employee.getLastName(), employee.getFirstName(), employee.getBirthday(), employee.getOrganizationId());

    }

    public Employee findById(long employeeId) {
        return jdbcTemplate.queryForObject("SELECT *FROM  employee WHERE id_employee=? ", new Object[]{employeeId},
                (response, rowNum) -> new Employee(response.getInt("id_employee"),
                        response.getLong("id_organisation"),
                        response.getString("last_name"),
                        response.getString("first_name"),
                        response.getDate("birthday")));
    }

    public void delete(long employeeId) {
        jdbcTemplate.update("DELETE  FROM employee WHERE id_employee=?", employeeId);
    }

    public void update(Employee employee) {
        jdbcTemplate.update("UPDATE employee SET last_name= ? , first_name= ?  WHERE id_employee= ?",
                employee.getLastName(), employee.getFirstName(), employee.getId());
    }

    public List<Employee> findByOrgId(long orgId) {
        return jdbcTemplate.query(
                "SELECT* FROM employee where id_organisation =?", new Object[]{orgId},
                (response, rowNumber) ->
                        new Employee(response.getInt("id_employee"),
                                response.getLong("id_organisation"),
                                response.getString("last_name"),
                                response.getString("first_name"),
                                response.getDate("birthday")));

    }
}
