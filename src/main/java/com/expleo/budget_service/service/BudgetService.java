package com.expleo.budget_service.service;


import com.expleo.budget_service.entity.Budget;
import com.expleo.budget_service.entity.BudgetCategory;
import com.expleo.budget_service.exception.BudgetAlreadyExistsException;
import com.expleo.budget_service.exception.BudgetNotFoundException;
import com.expleo.budget_service.repository.BudgetCategoryRepository;
import com.expleo.budget_service.repository.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BudgetService {

    @Autowired
    private BudgetRepository budgetRepository;

    @Autowired
    private BudgetCategoryRepository budgetCategoryRepository;


    public Budget createBudget(Budget budget) {
        Long userId = budget.getUserId();
        Long catId = budget.getCategory().getId();
        Budget byUserIdAndCategoryId = budgetRepository.findByUserIdAndCategoryId(userId, catId);
        if(byUserIdAndCategoryId!=null){
            throw new BudgetAlreadyExistsException("Budget Already exists for user for category:"+budget.getCategory().getName());
        }
        return budgetRepository.save(budget);
    }

    public Budget updateBudget(Budget budget) {
         Optional<Budget> budgetOptional = budgetRepository.findById(budget.getId());
         if(budgetOptional.isEmpty()){
             throw new BudgetNotFoundException("Budget with id :"+budget.getId()+" not found" );
         }
         return budgetRepository.save(budget);
    }

    public List<Budget> getBudgetsByUserId(Long userId) {
        List<Budget> byUserId = budgetRepository.findByUserId(userId);
        if(byUserId.isEmpty()){
            throw new BudgetNotFoundException("There are no budgets for this userId");
        }
        return byUserId;
    }

    public Budget getBudgetsByUserIdAndCategory(Long userId, Long categoryId) {

        Budget byUserIdAndCategoryId = budgetRepository.findByUserIdAndCategoryId(userId, categoryId);
        if(byUserIdAndCategoryId==null){
            throw new BudgetNotFoundException("There are no budgets for this userId and category");
        }

        return byUserIdAndCategoryId;
    }

    public List<BudgetCategory> getAllCategories() {
        return budgetCategoryRepository.findAll();
    }





}
