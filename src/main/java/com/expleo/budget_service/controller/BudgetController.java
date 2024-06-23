package com.expleo.budget_service.controller;


import com.expleo.budget_service.dto.ErrorResponseDto;
import com.expleo.budget_service.entity.Budget;
import com.expleo.budget_service.entity.BudgetCategory;
import com.expleo.budget_service.logging.LogExecutionTime;
import com.expleo.budget_service.service.BudgetService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/budget")
public class BudgetController {

    @Autowired
    private BudgetService budgetService;

    @Operation(summary = "Create budget REST API", description = "REST API to create new budget inside MyFinEx App")
    @ApiResponses({@ApiResponse(responseCode = "2001", description = "HTTP Status CREATED"),
            @ApiResponse(responseCode = "500", description = "HTTP Status Internal Server Error",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))})
    @PostMapping("/create")
    @LogExecutionTime
    public ResponseEntity<Budget> createBudget(@Valid @RequestBody Budget budget) {
        return ResponseEntity.status(HttpStatus.CREATED).body(budgetService.createBudget(budget));
    }

    @Operation(summary = "Update budget REST API", description = "REST API to update budget inside MyFinEx App")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "HTTP Status OK"),
            @ApiResponse(responseCode = "500", description = "HTTP Status Internal Server Error",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))})
    @PutMapping("/update/{id}")
    @LogExecutionTime
    public ResponseEntity<Budget> updateBudget(@Valid @RequestBody Budget budget,@PathVariable("id") Long id) {
        budget.setId(id);
        return ResponseEntity.ok(budgetService.updateBudget(budget));
    }

    @Operation(summary = "GET budget by User REST API", description = "REST API to GET budget inside MyFinEx App")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "HTTP Status OK"),
            @ApiResponse(responseCode = "500", description = "HTTP Status Internal Server Error",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))})
    @GetMapping("/user/{userId}")
    @LogExecutionTime
    public ResponseEntity<List<Budget>> getBudgetsByUserId(@PathVariable("userId") Long userId) {
        return ResponseEntity.ok(budgetService.getBudgetsByUserId(userId));
    }


    @Operation(summary = "GET budget by User and category REST API", description = "REST API to GET budget and category inside MyFinEx App")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "HTTP Status OK"),
            @ApiResponse(responseCode = "500", description = "HTTP Status Internal Server Error",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))})
    @GetMapping("/user/{userId}/category/{categoryId}")
    @LogExecutionTime
    public ResponseEntity<Budget> getBudgetsByUserIdAndCategory(@PathVariable("userId") Long userId,
                                                                      @PathVariable("categoryId") Long categoryId) {
        return ResponseEntity.ok(budgetService.getBudgetsByUserIdAndCategory(userId, categoryId));
    }


    @Operation(summary = "GET all category REST API", description = "REST API to GET all category inside MyFinEx App")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "HTTP Status OK"),
            @ApiResponse(responseCode = "500", description = "HTTP Status Internal Server Error",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))})
    @GetMapping("/categories")
    public ResponseEntity<List<BudgetCategory>> getAllCategories() {
        return ResponseEntity.ok(budgetService.getAllCategories());
    }


}
