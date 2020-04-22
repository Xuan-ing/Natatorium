package action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.VipUserDAO;
import entity.VipUser;
import org.apache.struts2.interceptor.validation.SkipValidation;


public class LoginAction extends SuperAction {

    private static final long serialVersionUID = 1L;
    private VipUser vipUser = new VipUser();

    public VipUser getVipUser() {
        return vipUser;
    }

    public void setVipUser(VipUser vipUser) {
        this.vipUser = vipUser;
    }

    public String login()  {
        VipUserDAO vipUserDAO = new VipUserDAO();
        VipUser curVipUser = vipUserDAO.select(vipUser.getTel());
        if(curVipUser == null) {
            return "account_error";
        }
        else if (!curVipUser.getPassword().equals(vipUser.getPassword())) {
            return "password_error";
        } else {
            session.setAttribute("curVipUser", curVipUser);
            return "login_success";
        }
    }
    @SkipValidation
    public String logout() {
        if(ActionContext.getContext().getSession().get("curVipUser")!=null)
        {
            session.removeAttribute("curVipUser");
        }

        return "logout";
    }

}

