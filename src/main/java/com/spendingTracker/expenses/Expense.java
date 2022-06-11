package com.spendingTracker.expenses;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Expense {

    public Expense(Long id, String category, Double dayLimit, Double amountSpent, String timePeriod) {
        this.id = id;
        this.category = category;
        this.dayLimit = dayLimit;
        this.amountSpent = amountSpent;
        this.timePeriod = timePeriod;
    }



    private @Id @GeneratedValue Long id;
    private String category;
    private Double dayLimit;
    private Double amountSpent;
    private String timePeriod;





    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getDayLimit() {
        return dayLimit;
    }

    public void setDayLimit(Double dayLimit) {
        this.dayLimit = dayLimit;
    }

    public Double getAmountSpent() {
        return amountSpent;
    }

    public void setAmountSpent(Double amountSpent) {
        this.amountSpent = amountSpent;
    }

    public String getTimePeriod() {
        return timePeriod;
    }

    public void setTimePeriod(String timePeriod) {
        this.timePeriod = timePeriod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expense expense = (Expense) o;
        return Objects.equals(id, expense.id) && Objects.equals(category, expense.category) && Objects.equals(dayLimit, expense.dayLimit) && Objects.equals(amountSpent, expense.amountSpent) && Objects.equals(timePeriod, expense.timePeriod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category, dayLimit, amountSpent, timePeriod);
    }
    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", dayLimit=" + dayLimit +
                ", amountSpent=" + amountSpent +
                ", timePeriod='" + timePeriod + '\'' +
                '}';
    }


}
