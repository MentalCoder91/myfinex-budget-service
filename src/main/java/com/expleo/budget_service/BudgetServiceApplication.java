package com.expleo.budget_service;

import com.expleo.budget_service.entity.BudgetCategory;
import com.expleo.budget_service.repository.BudgetCategoryRepository;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Budget microservice REST API Documentation",
				description = "MyFinEx Budget microservice REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Anish Alwekar",
						email = "anish.alwekar@gmail.com",
						url = "https://github.com/MentalCoder91"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://github.com/MentalCoder91"
				)
		),
		externalDocs = @ExternalDocumentation(
				description =  "MyFinEx Budget microservice REST API Documentation",
				url = "http://localhost:9092/swagger-ui/index.html"
		)
)
public class BudgetServiceApplication implements CommandLineRunner {

	@Autowired
	private BudgetCategoryRepository budgetCategoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(BudgetServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		budgetCategoryRepository.save(new BudgetCategory(null, "Groceries"));
		budgetCategoryRepository.save(new BudgetCategory(null, "Rent"));
		budgetCategoryRepository.save(new BudgetCategory(null, "Utilities"));
		budgetCategoryRepository.save(new BudgetCategory(null, "Transportation"));
		budgetCategoryRepository.save(new BudgetCategory(null, "Dining Out"));
		budgetCategoryRepository.save(new BudgetCategory(null, "Entertainment"));
		budgetCategoryRepository.save(new BudgetCategory(null, "Healthcare"));
		budgetCategoryRepository.save(new BudgetCategory(null, "Insurance"));
		budgetCategoryRepository.save(new BudgetCategory(null, "Education"));
		budgetCategoryRepository.save(new BudgetCategory(null, "Savings"));
		budgetCategoryRepository.save(new BudgetCategory(null, "Investments"));
		budgetCategoryRepository.save(new BudgetCategory(null, "Clothing"));
		budgetCategoryRepository.save(new BudgetCategory(null, "Personal Care"));
		budgetCategoryRepository.save(new BudgetCategory(null, "Gifts"));
		budgetCategoryRepository.save(new BudgetCategory(null, "Charity"));
	}
}
