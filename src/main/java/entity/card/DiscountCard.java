package entity.card;

import java.io.StringReader;
import java.sql.Date;

public class DiscountCard extends Card {
    private Double discountRate;
    private Date dueDate;

    public Double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Double discountRate) {
        this.discountRate = discountRate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DiscountCard that = (DiscountCard) o;

        if (getId() != that.getId()) return false;
        if (discountRate != null ? !discountRate.equals(that.discountRate) : that.discountRate != null) return false;
        if (dueDate != null ? !dueDate.equals(that.dueDate) : that.dueDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (discountRate != null ? discountRate.hashCode() : 0);
        result = 31 * result + (dueDate != null ? dueDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + "DiscountCard{" +
                "discountRate=" + discountRate +
                ", dueDate=" + dueDate +
                '}';
    }

    @Override
    public boolean consume() {
        //return pay(this.getDiscountRate(), this.getDueDate());
        return true;
    }
}
