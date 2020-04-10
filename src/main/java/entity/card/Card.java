package entity.card;

import entity.record.Record;
import entity.VipUser;

import java.util.Set;

public class Card {
    private int id;
    private String type;
    private Boolean availability;
    private VipUser vipUser;
    private Set<Record> recordSet;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public String getType() {return type;}

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public void setType(String type) {this.type = type;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (id != card.id) return false;
        if (type != null ? !type.equals(card.type) : card.type != null) return false;
        if (availability != null ? !availability.equals(card.availability) : card.availability != null) return false;
        if (vipUser != null ? !vipUser.equals(card.vipUser) : card.vipUser != null) return false;
        if (recordSet != null ? !recordSet.equals(card.recordSet) : card.recordSet != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (vipUser != null ? vipUser.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (availability != null ? availability.hashCode() : 0);
        //result = 31 * result + (recordSet != null ? recordSet.hashCode() : 0);
        return result;
    }

    public VipUser getVipUser() {
        return vipUser;
    }

    public void setVipUser(VipUser vipUser) {
        this.vipUser = vipUser;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", availability=" + availability +
                ", userID=" + vipUser.getId() +
                '}';
    }

    public Set<Record> getRecordSet() {
        return recordSet;
    }

    public void setRecordSet(Set<Record> recordSet) {
        this.recordSet = recordSet;
    }

    public boolean consume() {
        return false;
    }
}
