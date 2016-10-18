import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;
import com.flp.ems.service.*;

import junit.framework.Assert;
public class Service {

	
	EmployeeServiceImpl emp=new EmployeeServiceImpl();
	@Test
	public void checkRolesList(){
		
		
		HashMap<String,String> roles=emp.getRolesList();
		assert  roles.isEmpty()==false :  "Roles not initialized";
		//assertThat(, is(expected));

	}
	


	@Test
	public void checkDepartmentList(){
		HashMap<String,String> dept=emp.getDepartmentList();
		assert  dept.isEmpty()==false ;
	
	
	}

	@Test
	public void checkProjectList(){
	//	HashMap<String,String> project=emp.getProjectList(new HashMap());
		//assert  project.isEmpty()==false;
			
	}





}
