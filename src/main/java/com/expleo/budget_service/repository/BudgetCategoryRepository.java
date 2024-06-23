package com.expleo.budget_service.repository;

import com.expleo.budget_service.entity.BudgetCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BudgetCategoryRepository extends JpaRepository<BudgetCategory,Long> {
}
