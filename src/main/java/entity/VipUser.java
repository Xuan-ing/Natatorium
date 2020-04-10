package entity;

import entity.card.Card;

import java.util.Objects;
import java.util.Set;

public class VipUser {
    private int id;
    private String name;
    private String tel;
    private String no;
    private String password;
    private Set<Card> cardSet;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VipUser vipUser = (VipUser) o;

        if (id != vipUser.id) return false;
        if (!Objects.equals(name, vipUser.name)) return false;
        if (!Objects.equals(tel, vipUser.tel)) return false;
        if (!Objects.equals(no, vipUser.no)) return false;
        if (!Objects.equals(password, vipUser.password)) return false;
        if (!Objects.equals(cardSet, vipUser.cardSet)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (tel != null ? tel.hashCode() : 0);
        result = 31 * result + (no != null ? no.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    public Set<Card> getCardSet() {
        return cardSet;
    }

    public void setCardSet(Set<Card> cardSet) {
        this.cardSet = cardSet;
    }
}
