package com.spendingTracker.category;

import com.spendingTracker.user.CustomUser;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;
@Entity
public class Category {

    private @Id @GeneratedValue Long id;



    private Long userId;
    private String name;
    private double sevenDayLimit;
    private String expenseType;


    private boolean isSavings;
    public Category() {}

    public Category(String userId, String name, Double sevenDayLimit, String expenseType, boolean isSavings) {
        this.userId = Long.parseLong(userId);
        this.name = name;
        this.sevenDayLimit = sevenDayLimit;
        this.expenseType = expenseType;
        this.isSavings = isSavings;
    }

    public boolean isSavings() {
        return isSavings;
    }

    public void setSavings(boolean savings) {
        isSavings = savings;
    }

    public String getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(String expenseType) {
        this.expenseType = expenseType;
    }
    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }
    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSevenDayLimit(){
        return this.sevenDayLimit;
    }

    public void setSevenDayLimit(double sevenDayLimit){
        this.sevenDayLimit = sevenDayLimit;
    }


    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof com.spendingTracker.category.Category))
            return false;
        com.spendingTracker.category.Category category = ( com.spendingTracker.category.Category) o;
        return
                Objects.equals(this.id, category.id) && Objects.equals(this.userId, category.userId)
                && Objects.equals(this.name, category.name) && Objects.equals(this.sevenDayLimit, category.sevenDayLimit)
                        && Objects.equals(this.expenseType, category.expenseType)
                        && Objects.equals(this.isSavings, category.isSavings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.userId, this.name, this.sevenDayLimit, this.expenseType, this.isSavings);
    }
    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", sevenDayLimit=" + sevenDayLimit +
                ", expenseType="+expenseType +", " +
                "isSavings="+isSavings +
                '}';
    }
}
