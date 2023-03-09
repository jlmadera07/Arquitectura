package in.burshansirgur.springrestapi.controller;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import in.burshansirgur.springrestapi.model.Employee;
import lombok.Value;

//@Controller
@RestController // el @Controller  + @ResponseBody
@RequestMapping("/api/vi/")
public class EmployeeController {
	@org.springframework.beans.factory.annotation.Value("${app.name}")
	private String appName;
	
	@org.springframework.beans.factory.annotation.Value("${app.version}")
	private String appVersion;
	
	//@RequestMapping(value="/employees",method =RequestMethod.GET)
	@GetMapping("/employees")
	
	public String getEmployees() {
		return "Esta es la lista del empleado";
	}
	
	@GetMapping("/version")
	public String getAppDetails() {
		return appName+ "-"+appVersion;
	}
	
	//localhost8080/employees/12
	@GetMapping("/employees/{id}")
	public String getEmployee(@PathVariable("id")Long id) {
		
		return "Obteniendo los detalles del empleado para su identificación "+id;
		
	}
	
	@PostMapping("/employees")
	public String saveEmployee(@RequestBody Employee employee ) {
		return "Guardar los datos del empleado en el la DB "+employee;
	}
	//"localhost8080/employees?id=34
	@DeleteMapping("/employees")
	public String deleteEmployee(@RequestParam("id")Long id) {
		return "Borrando el detalle del empelado por el Id "+id;
	}

}

