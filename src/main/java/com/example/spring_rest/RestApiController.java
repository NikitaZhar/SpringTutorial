package com.example.spring_rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
class RestApiController {
	private List<Coffee> coffees = new ArrayList<>();

	public RestApiController() {
		coffees.addAll(List.of(
				new Coffee("Café Cereza"),
				new Coffee("Café Ganador"),
				new Coffee("Café Lareño"),
				new Coffee("Café Três Pontas")
				));
	}

	@GetMapping("/coffees")
	Iterable<Coffee> getCoffees() {
		return coffees;
	}

	@GetMapping("/coffees/{id}")
	Optional<Coffee> getCoffeeById(@PathVariable String id) {
		for (Coffee coffee: coffees) {
			if (coffee.getId().equals(id)) {
				return Optional.of(coffee);
			}
		}
		return Optional.empty();
	}

	@PostMapping("/coffees")
	Coffee postCoffee(@RequestBody Coffee coffee) {
		coffees.add(coffee);
		return coffee;
	}

	@PutMapping("/coffees/{id}")
	Coffee putCoffee(@PathVariable String id, @RequestBody Coffee coffee) {
		int coffeeIndex = -1;
		for (Coffee coffeeToFind: coffees) {
			if (coffeeToFind.getId().equals(id)) {
				coffeeIndex = coffees.indexOf(coffeeToFind);
				coffees.set(coffeeIndex, coffee);
			}
		}
		return (coffeeIndex == -1) ? postCoffee(coffee) : coffee;
	}

	@DeleteMapping("/coffees/{id}")
	void deleteCoffee(@PathVariable String id) {
		coffees.removeIf(coffee -> coffee.getId().equals(id));
	}
}
