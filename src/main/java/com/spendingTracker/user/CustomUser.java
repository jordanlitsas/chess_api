package com.spendingTracker.user;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public
class CustomUser {

    private @Id @GeneratedValue Long id;
    private String uId;

    CustomUser() {}

    public CustomUser(String uId) {
        this.uId = uId;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getUId() {
        return this.uId;
    }

    public void setUId(String uId) {
        this.uId = uId;
    }


    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof CustomUser))
            return false;
        CustomUser customUser = (CustomUser) o;
        return Objects.equals(this.id, customUser.id) && Objects.equals(this.uId, customUser.uId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.uId);
    }

    @Override
    public String toString() {
        return "CustomUser{" + "id=" + this.id + ", uId='" + this.uId+"}";
    }
}