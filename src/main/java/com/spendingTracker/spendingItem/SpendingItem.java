package com.spendingTracker.spendingItem;
import com.spendingTracker.spendingItem.SpendingItem;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Date;

@Entity
public class SpendingItem {

    private @Id
    @GeneratedValue Long id;


    private Long userId;
    private String category;
    private double amountSpent;
    private LocalDate submitDate;



    public SpendingItem(){
        this.submitDate = LocalDate.now();
    }

    public SpendingItem(Long userId, String category, double amountSpent){
        this.userId = userId;
        this.category = category;
        this.amountSpent = amountSpent;
        this.submitDate = LocalDate.now();
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

    public LocalDate getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(LocalDate date) {
        this.submitDate = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpendingItem that = (SpendingItem) o;
        return Objects.equals(id, that.id) && Objects.equals(userId, that.userId) && Objects.equals(category, that.category)  && Objects.equals(amountSpent, that.amountSpent) && Objects.equals(submitDate, that.submitDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, category, amountSpent, submitDate);
    }

    @Override
    public String toString() {
        return "SpendingItem{" +
                "id=" + id +
                ", userId=" + userId +
                ", category='" + category + '\'' +
                ", amountSpent=" + amountSpent +
                ", submitDate=" + submitDate +

                '}';
    }
}
