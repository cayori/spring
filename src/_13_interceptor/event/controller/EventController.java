package _13_interceptor.event.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EventController {

	@RequestMapping("/event/list.do")
	public String list() {
		return "_13_interceptor/event/list";
	}
	
	@RequestMapping("/event/eventExpired.do")
	public String expired() {
		return "_13_interceptor/event/eventExpired";
	}
}
