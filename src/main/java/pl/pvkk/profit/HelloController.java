package pl.pvkk.profit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping(value={"/", "/home"})
	public String hello(){
		return "index";
	}
}