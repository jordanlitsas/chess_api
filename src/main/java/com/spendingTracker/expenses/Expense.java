package com.spendingTracker.expenses;

public class Expense {
    private double weeklyLimit;
    private double weeklyAmountSpent = 0;
    private String category;

    public Expense(){}
    public Expense(double weeklyLimit, double weeklyAmountSpent, String category) {
        this.weeklyLimit = weeklyLimit;
        this.weeklyAmountSpent = weeklyAmountSpent;
        this.category = category;
    }

    public void addPurchase(double amountSpent){
        this.weeklyAmountSpent += amountSpent;
    }
    public double getWeeklyLimit() {
        return weeklyLimit;
    }

    public void setWeeklyLimit(double weeklyLimit) {
        this.weeklyLimit = weeklyLimit;
    }


    public double getWeeklyAmountSpent() {
        return weeklyAmountSpent;
    }

    public void setWeeklyAmountSpent(double weeklyAmountSpent) {
        this.weeklyAmountSpent = weeklyAmountSpent;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }




}
