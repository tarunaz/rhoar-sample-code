package com.example.service;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/fruits")
public class FruitController {

	private List fruite = new ArrayList<>();

	@GetMapping
	public String home(Model model) {
		model.addAttribute("fruits", fruits); // For the List view
		model.addAttribute("fruitForm", new Fruit()); // For the Form
		return "home";
	}

	@PostMapping
	public String createFruit(@ModelAttribute Fruit fruit) {
		fruits.add(fruit);
		return "redirect:/fruits";
	}

}
