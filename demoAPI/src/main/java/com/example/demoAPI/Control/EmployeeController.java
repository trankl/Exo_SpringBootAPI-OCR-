package com.example.demoAPI.Control;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demoAPI.Model.Employee;
import com.example.demoAPI.Service.EmployeeService;

@Controller
public class EmployeeController {


	@GetMapping({ "/hello" })
	public String hello(Model model,
			@RequestParam(value = "name", required = false, defaultValue = "World") String name)
	{
		model.addAttribute("name", name);
		return "hello";
	}
	
	@Autowired
    private EmployeeService employeeService;

	// Injectez (inject) de l'application.properties.
	@Value("${welcome.message}")
	private String message;

	@Value("${error.message}")
	private String errorMessage;	 
 
 @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String index(Model model) {

		model.addAttribute("message", message);
		System.out.println(message);
		return "index";
	}
 
 @RequestMapping(value = { "/personList" }, method = RequestMethod.GET)
	public String personList(Model model) {
	 	
		model.addAttribute("ListEmployees", employeeService.getAllEmployees());
		System.out.println("List Employees : " + employeeService.getAllEmployees());
		return "personList";
	}
 
    //Pour l’envoi de données. Cela sera utilisé par exemple pour créer un nouvel élément.
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
    	return employeeService.saveEmployee(employee);
    }
    

	 //	Pour la lecture de données: get 1 employee by ID
	    @GetMapping("/employee{id}")
	    public Employee getEmployee(@PathVariable("id") final Long id) {
	    	Optional<Employee> employee = employeeService.getEmployee(id);
	    	if (employee.isPresent()) {
	    		return employee.get();
	    	}
	    	return null;
	    }
	    
	    
	  //Pour la lecture de données: get all employees
	    @GetMapping("/employees")
	    public Iterable<Employee> getAllEmployees() {
	    	return employeeService.getAllEmployees();
	    }
	    
	    
    //Pour la mise à jour partielle de l’élément envoyé.
   // @PatchMapping
    
    
    //Pour le remplacement complet de l’élément envoyé.
	    @PutMapping("/employee/{id}")
		public Employee updateEmployee(@PathVariable("id") final Long id, @RequestBody Employee employee) {
			Optional<Employee> e = employeeService.getEmployee(id);
			System.out.println("e = " +e);
			if(e.isPresent()) {
				Employee currentEmployee = e.get();
				System.out.println("currentEmployee = " +currentEmployee );
				String firstName = employee.getFirstName();
				if(firstName != null) {
					currentEmployee.setFirstName(firstName);
				}
				String lastName = employee.getLastName();
				if(lastName != null) {
					currentEmployee.setLastName(lastName);;
				}
				String mail = employee.getMail();
				if(mail != null) {
					currentEmployee.setMail(mail);
				}
				String password = employee.getPassword();
				if(password != null) {
					currentEmployee.setPassword(password);;
				}
				employeeService.saveEmployee(currentEmployee);
				return currentEmployee;
			} else {
				return null;
			}
		}
	    
    	
    
    //Pour la suppression de l’élément envoyé.
    @DeleteMapping ("/employee/{id}")
    public void deleteEmployee(@PathVariable("id") final Long id) {
    	employeeService.deleteEmployee(id);
    }
}
