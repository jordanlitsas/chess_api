package com.spendingTracker.spendingItem;
import com.spendingTracker.spendingItem.SpendingItem;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;
import java.util.Date;

@Entity
public class SpendingItem {

    private @Id
    @GeneratedValue Long id;


    private Long userId;
    private String category;
    private double amountSpent;
    private Date submitDate;


    private String expenseType;

    public SpendingItem(){}

    public SpendingItem(Long userId, String category, double amountSpent, Date submitDate, String expenseType){
        this.userId = userId;
        this.category = category;
        this.amountSpent = amountSpent;
        this.submitDate = submitDate;
        this.expenseType = expenseType;
    }

    public String getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(String expenseType) {
        this.expenseType = expenseType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public double getAmountSpent() {
        return amountSpent;
    }

    public void setAmountSpent(double amountSpent) {
        this.amountSpent = amountSpent;
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date date) {
        this.submitDate = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpendingItem that = (SpendingItem) o;
        return Objects.equals(id, that.id) && Objects.equals(expenseType, that.expenseType)&& Objects.equals(userId, that.userId) && Objects.equals(category, that.category)  && Objects.equals(amountSpent, that.amountSpent) && Objects.equals(submitDate, that.submitDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, category, amountSpent, submitDate, expenseType);
    }

    @Override
    public String toString() {
        return "SpendingItem{" +
                "id=" + id +
                ", userId=" + userId +
                ", category='" + category + '\'' +
                ", amountSpent=" + amountSpent +
                ", submitDate=" + submitDate +
                ", expenseType="+expenseType +
                '}';
    }
}
