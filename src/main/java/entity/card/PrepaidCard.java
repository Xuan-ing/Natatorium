package entity.card;

public class PrepaidCard extends Card {
    private Double balance;
    public final Double PRICE = 60.0;

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        int id = getId();
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PrepaidCard that = (PrepaidCard) o;

        if (id != that.getId()) return false;
        if (balance != null ? !balance.equals(that.balance) : that.balance != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        return result;
    }

   @Override
    public boolean consume() {
        if (balance > PRICE) {
            this.setBalance(this.getBalance() - PRICE);
            return true;
        } else {
            return false;
        }
    }
}
