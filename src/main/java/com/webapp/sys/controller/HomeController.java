<<<<<<< HEAD
package com.webapp.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping
	public String index() {
		return "index";
	}
=======
package com.webapp.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping
	public String index() {
		return "index";
	}
>>>>>>> refs/remotes/origin/master
}