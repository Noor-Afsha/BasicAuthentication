package controller.copy;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@GetMapping
	public String Home(Authentication authentication) {
		return "hellow" + authentication.getName();
	}
}
