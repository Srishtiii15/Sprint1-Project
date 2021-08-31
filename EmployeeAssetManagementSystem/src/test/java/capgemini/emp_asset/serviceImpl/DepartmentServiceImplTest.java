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
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DepartmentServiceImplTest {

	@Autowired
	private DepartmentServiceImpl departmentService;
	
	@Test
	public final void testGetAllDepartment() {
		List<Department> assets = departmentService.getAllDepartment();
		assertThat(assets.size()>0);
	}

	@Test
	public final void testGetDepartment() {
		Optional<Department> dept = departmentService.getDepartment(1);
		assertThat(dept.get().getDeptId()==1);
	}

	@Test
	public final void testAddDepartment() {
		Department dept = new Department();
		dept.setDeptId(2);
		dept.setName("Marketing");
		dept=departmentService.addDepartment(dept);
		assertThat(dept.getName().equalsIgnoreCase("Marketing"));
	}

	@Test
	public final void testRemoveDepartment() {
		Department dept = new Department();
		dept.setDeptId(2);
		dept.setName("IT");
		dept=departmentService.addDepartment(dept);
		departmentService.removeDepartment(dept);
		assertThat(dept.getDeptId()==0);
	}

	@Test
	public final void testEditDepartment() {
		Department dept = new Department();
		dept.setDeptId(1);
		dept.setName("CS");
		dept=departmentService.editDepartment(dept);
		assertThat(dept.getName().equalsIgnoreCase("CS"));
	}

}
