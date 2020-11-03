package br.com.codeburger.codeburger;

import br.com.codeburger.codeburger.model.Ingredient;
import br.com.codeburger.codeburger.model.Sandwich;
import br.com.codeburger.codeburger.model.SandwichIngredient;
import br.com.codeburger.codeburger.repository.IngredientRepository;
import br.com.codeburger.codeburger.repository.SandwichIngredientRepository;
import br.com.codeburger.codeburger.repository.SandwichRepository;
import br.com.codeburger.codeburger.service.IngredientService;
import br.com.codeburger.codeburger.service.IngredientServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CodeburgerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodeburgerApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadDataIngredient(IngredientRepository ingredientRepository) {
    	return args -> {
			ingredientRepository.save(new Ingredient(1L, "Alface", 0.4));
			ingredientRepository.save(new Ingredient(2L, "Bacon", 2.0));
			ingredientRepository.save(new Ingredient(3L, "Hambúrguer", 3.0));
			ingredientRepository.save(new Ingredient(4L, "Ovo", 0.8));
			ingredientRepository.save(new Ingredient(5L, "Queijo", 1.5));
		};
	}

	@Bean
	public CommandLineRunner loadDataSandwich(SandwichRepository sandwichRepository) {
		return args -> {
			sandwichRepository.save(new Sandwich(6L, "X-Bacon", null));
			sandwichRepository.save(new Sandwich(7L, "X-Burger", null));
			sandwichRepository.save(new Sandwich(8L, "X-Egg", null));
			sandwichRepository.save(new Sandwich(9L, "X-Egg Bacon", null));
		};
	}

	@Bean
	public CommandLineRunner loadDataSandwichIngredient(SandwichIngredientRepository sandwichIngredientRepository) {
		return args -> {
			// X-Bacon (6)
			sandwichIngredientRepository.save(new SandwichIngredient(1L,
					new Sandwich(6L, null, null),
					new Ingredient(2L, null, null), 1d));

			sandwichIngredientRepository.save(new SandwichIngredient(2L,
					new Sandwich(6L, null, null),
					new Ingredient(3L, null, null), 1d));

			sandwichIngredientRepository.save(new SandwichIngredient(3L,
					new Sandwich(6L, null, null),
					new Ingredient(5L, null, null), 1d));

			// X-Burger (7)
			sandwichIngredientRepository.save(new SandwichIngredient(4L,
					new Sandwich(7L, null, null),
					new Ingredient( 3L, null, null), 1d));

			sandwichIngredientRepository.save(new SandwichIngredient(5L,
					new Sandwich(7L, null, null),
					new Ingredient(5L, null, null), 1d));

            // X-Egg (8)
			sandwichIngredientRepository.save(new SandwichIngredient(6L,
					new Sandwich(8L, null, null),
					new Ingredient(3L, null, null), 1d));

			sandwichIngredientRepository.save(new SandwichIngredient(7L,
					new Sandwich(8L, null, null),
					new Ingredient(4L, null, null), 1d));

			sandwichIngredientRepository.save(new SandwichIngredient(8L,
					new Sandwich(8L, null, null),
					new Ingredient(5L, null, null), 1d));

			// X-Egg Bacon (9)
			sandwichIngredientRepository.save(new SandwichIngredient(9L,
					new Sandwich(9L, null, null),
					new Ingredient(3L, null, null), 1d));

			sandwichIngredientRepository.save(new SandwichIngredient(10L,
					new Sandwich(9L, null, null),
					new Ingredient(4L, null, null), 1d));

			sandwichIngredientRepository.save(new SandwichIngredient(11L,
					new Sandwich(9L, null, null),
					new Ingredient(5L, null, null), 1d));

			sandwichIngredientRepository.save(new SandwichIngredient(12L,
					new Sandwich(9L, null, null),
					new Ingredient(2L, null, null), 1d));
		};
	}
}