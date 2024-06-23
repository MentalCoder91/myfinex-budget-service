package com.expleo.budget_service.repository;

import com.expleo.budget_service.entity.Budget;
import com.expleo.budget_service.entity.BudgetCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BudgetRepository extends JpaRepository<Budget, Long> {


    List<Budget> findByUserId(Long userId);


    List<Budget> findByUserIdAndCategory(Long userId, BudgetCategory category);


    @Query(value = "SELECT * FROM budget WHERE user_id = :userId AND category_id = :categoryId", nativeQuery = true)
    Budget findByUserIdAndCategoryId(@Param("userId") Long userId, @Param("categoryId") Long categoryId);
}
