package com.example.expenseapp.service;

import com.example.expenseapp.entity.Expense;

import java.util.List;

public interface ExpenseService {

   List<Expense> getAllExpense();

   Expense saveExpenseDetails(Expense expense);

   Expense getExpenseById(long id);

   Expense updateExpenseDetails(Long id,Expense expense);


   void deleteExpenseById(Long id);




}
