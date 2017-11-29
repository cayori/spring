package _08_gameInfo.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GameInfoController {

	@RequestMapping("/game/info")
	public String gameInfo() {
		return "_08_gameInfo/users/info";
	}
	
	@RequestMapping("/game/list")
	public String gameList() {
		return "_08_gameInfo/list";
	}
}
