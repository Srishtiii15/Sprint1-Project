package capgemini.emp_asset.serviceImpl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import capgemini.emp_asset.entity.Department;
import capgemini.emp_asset.entity.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class EmployeeServiceImplTest {

	@Autowired
	private EmployeeServiceImpl employeeService;
	
	@Test
	public final void testGetAllEmployee() {
		List<Employee> assets = employeeService.getAllEmployee();
		assertThat(assets.size()>0);
	}

	@Test
	public final void testGetEmployee() {
		Optional<Employee> asset = employeeService.getEmployee(1);
		assertThat(asset.get().getUserId()==1);
	}

	@Test
	public final void testAddEmployee() {
		Employee emp = new Employee();
		Department dept=new Department();
		
		emp.setUserId(3);
		emp.setName("Vaishnavi");
		emp.setUsername("Vaishnavi123");
		emp.setPassword("Vaishnavi@123");
		emp.setRole("Analyst");
		emp.setDesignation("SD");
		
		dept.setDeptId(3);
		dept.setName("CS");
		
		emp=employeeService.addEmployee(emp);
		assertThat(emp.getName().equalsIgnoreCase("Vaishnavi"));
	}

	@Test
	public final void testRemoveEmployee() {
		Employee emp = new Employee();
		Department dept=new Department();
		
		emp.setUserId(4);
		emp.setName("abc");
		emp.setUsername("abc123");
		emp.setPassword("abc@123");
		emp.setRole("Analyst");
		emp.setDesignation("SD");
		
		dept.setDeptId(4);
		dept.setName("IT");
		
		emp=employeeService.addEmployee(emp);
		employeeService.removeEmployee(emp);
		assertThat(emp.getUserId()==0);
	}

	@Test
	public final void testEditEmployee() {
		Employee emp = new Employee();
		Department dept=new Department();
		
		emp.setUserId(2);
		emp.setName("Shrishti");
		emp.setUsername("Shrishti123");
		emp.setPassword("Shrishti@123");
		emp.setRole("Analyst");
		emp.setDesignation("SD");
		
		dept.setDeptId(null);
		dept.setName("CS");
		
		emp=employeeService.editEmployee(emp);
		assertThat(emp.getRole().equalsIgnoreCase("Analyst1"));
	}

}
