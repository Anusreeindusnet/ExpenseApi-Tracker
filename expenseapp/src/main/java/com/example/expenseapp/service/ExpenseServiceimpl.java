package com.example.expenseapp.service;

import com.example.expenseapp.entity.Expense;
import com.example.expenseapp.exceptions.ResourceNotFoundException;
import com.example.expenseapp.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseServiceimpl implements ExpenseService{
    @Autowired
    private ExpenseRepository expenseRepo;
    @Override

    public List<Expense> getAllExpense() {
        return expenseRepo.findAll();
    }

    @Override
    public Expense saveExpenseDetails(Expense expense) {
        return expenseRepo.save(expense);
    }

    @Override
    public Expense getExpenseById(long id) {
       Optional<Expense>expense= expenseRepo.findById(id);
       if(expense.isPresent()){
          return expense.get();
       }
       throw new ResourceNotFoundException("Expense not found "+id);
    }

    @Override
    public Expense updateExpenseDetails(Long id, Expense expense) {
        Expense existingExpense=getExpenseById(id);
        existingExpense.setName(expense.getName()!=null? expense.getName() : existingExpense.getName());
        existingExpense.setDescription(expense.getDescription()!=null? expense.getDescription() : existingExpense.getDescription());
        existingExpense.setCategory(expense.getCategory()!=null? expense.getCategory() : existingExpense.getCategory());
        existingExpense.setDate(expense.getDate()!=null? expense.getDate() : existingExpense.getDate());
        existingExpense.setAmount(expense.getAmount()!=null? expense.getAmount() : existingExpense.getAmount());
       return  expenseRepo.save(existingExpense);

    }

    @Override
    public void deleteExpenseById(Long id) {
        expenseRepo.deleteById(id);
    }
}
