package action;

import dao.AdministratorDAO;
import dao.CardDAO;
import dao.VipUserDAO;
import entity.Administrator;
import entity.VipUser;
import entity.card.PrepaidCard;
import org.apache.struts2.interceptor.validation.SkipValidation;
import java.util.List;

public class AdministratorAction extends SuperAction {
    private static final long serialVersionUID = 1L;
    private Administrator administrator = new Administrator();

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public String login()  {
        AdministratorDAO administratorDAO = new AdministratorDAO();
        Administrator curAdministrator = administratorDAO.select(administrator.getUsername());
        if(curAdministrator == null) {
            return "account_error";
        }
        else if (!curAdministrator.getPassword().equals(administrator.getPassword())) {
            return "password_error";
        } else {
            session.setAttribute("curAdministrator", curAdministrator);
            return "admin_login_success";
        }
    }
    @SkipValidation
    public String logout() {
        if(session.getAttribute("curAdministrator")!=null)
        {
            session.removeAttribute("curAdministrator");
        }
        if(session.getAttribute("vipUserList")!=null)
        {
            session.removeAttribute("vipUserList");
        }
        if(session.getAttribute("allPrepaidCard")!=null)
        {
            session.removeAttribute("allPrepaidCard");
        }

        return "admin_logout";
    }
    public String selectAllUser() {
        VipUserDAO vipUserDAO =new VipUserDAO();
        List<VipUser> vipUserList = vipUserDAO.listUsers();
        session.setAttribute("vipUserList",vipUserList);
        return "selectAllUser";
    }
    public String selectAllCard() {
        CardDAO cardDAO = new CardDAO();
        List<PrepaidCard> allPrepaidCard = cardDAO.allPrepaidCard();
        session.setAttribute("allPrepaidCard",allPrepaidCard);
        return "selectAllCard";
    }

}
