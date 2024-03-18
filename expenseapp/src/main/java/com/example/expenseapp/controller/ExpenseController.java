package com.example.expenseapp.controller;


import com.example.expenseapp.entity.Expense;
import com.example.expenseapp.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;
    @GetMapping("/expenses")
    public List<Expense> getAllExpenses(){
        return expenseService.getAllExpense() ;
    }

    @GetMapping("/expenses/{id}")
    public Expense getExpenseById(@PathVariable("id") Long id ){
     return expenseService.getExpenseById(id);
    }
    @DeleteMapping("/expenses/{id}")
    public void deleteExpenseById(@PathVariable("id") Long id ){
        expenseService.deleteExpenseById(id);
    }

    @PutMapping("/expenses/{id}")
    public Expense updateExpenseDetails(@RequestBody Expense expense,@PathVariable Long id){
        return expenseService.updateExpenseDetails(id,expense);

    }

    @PostMapping("/expenses")
    public Expense saveExpenseDetails(@RequestBody Expense expense){
    return expenseService.saveExpenseDetails(expense);
    }
}
