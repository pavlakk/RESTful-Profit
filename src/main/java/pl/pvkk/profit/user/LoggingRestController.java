package pl.pvkk.profit.user;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("user")
public class LoggingRestController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/print/{userId}")
	public HttpEntity<User> printUser(@PathVariable int userId){
		return userService.tryToPrintUser(userId);
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> addUser(@Valid @RequestBody User user, BindingResult result){
		
		//maybe this is hard to understand but looks beautiful
		//just check are some errors -> try to save -> if login is taken get error -> if not welcome user
		return result.hasErrors() ?
				new ResponseEntity<String>(
					result.getFieldError().getField()+" "+result.getFieldError().getDefaultMessage(),
					HttpStatus.BAD_REQUEST) :
				userService.tryToSaveUser(user);
	}

}








