package com.example.expenseapp.repository;

import com.example.expenseapp.entity.Expense;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Long> {






}
