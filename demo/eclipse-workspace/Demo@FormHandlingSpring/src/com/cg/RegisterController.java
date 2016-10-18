package com.cg;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
@RequestMapping(value = "/register")
public class RegisterController {

	private UserDTO dtoRef;
	
	{
    	dtoRef = new UserDTO();
    	dtoRef.setEmail("abc@xyz.com");
	}
	
	@Autowired
    daoImpl dao;
    
	
    @RequestMapping(method = RequestMethod.GET)
    public String viewRegistration(Map<String, Object> model) {
    	System.out.println("inside GET");
/*        UserDTO userForm = new UserDTO();    
        
        userForm.setUsername("dummy");
        model.put("userForm", userForm);
*/         
        List<String> professionList = new ArrayList<String>();
        professionList.add("Developer");
        professionList.add("Designer");
        professionList.add("IT Manager");
        model.put("professionList", professionList);
         
        
        System.out.println(model);
        /*
        for(String key:model.keySet())
        {
        	System.out.println("inside get: model map contains "+key);
        }
        */
        //        return "redirect:registration";
        return "registration";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    
    public String processRegistration(@ModelAttribute("userForm") UserDTO UserDTO, Map<String,Object> model) {
    	System.out.println("inside POST");
        // implement your own registration logic here...
         
        // for testing purpose:
    	  /* for(String key:model.keySet())
           {
           	System.out.println("inside post: model map contains "+key);
           }
    	*/
    	System.out.println(UserDTO);
    	
        System.out.println("username: " + UserDTO.getUsername());
        System.out.println("password: " + UserDTO.getPassword());
        System.out.println("email: " + UserDTO.getEmail());
        System.out.println("birth date: " + UserDTO.getBirthDate());
        System.out.println("profession: " + UserDTO.getProfession());
         
        
        dao.create(UserDTO);
        
//        return "redirect:/WEB-INF/pages/success.jsp";
        return "success";
    }
    
    @ModelAttribute("userForm")
    UserDTO createUser(){
    	System.out.println("TRYING TO CREATE AN ENTRY FOR A USER");
    	return dtoRef;
    }
    
}