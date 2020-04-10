package action;

import com.opensymphony.xwork2.ActionContext;
import dao.VipUserDAO;
import entity.VipUser;

import java.util.LinkedList;
import java.util.List;

public class VipUserAction {
    private VipUserDAO vipUserDAO = new VipUserDAO();
    private VipUser vipUser = new VipUser();
    private List<VipUser> vipUsers = new LinkedList<>();

    public VipUser getVipUser() {
        return vipUser;
    }

    public void setVipUser(VipUser vipUser) {
        this.vipUser = vipUser;
    }

    public VipUserDAO getVipUserDAO() {
        return vipUserDAO;
    }

    public void setVipUserDAO(VipUserDAO vipUserDAO) {
        this.vipUserDAO = vipUserDAO;
    }

    /**
     * 注册
     * @return
     */
    public String add() {
        vipUserDAO.add(vipUser);
        return "login";
    }

    /**
     * 用户跟新信息
     * @return
     */
    public String update() {
        vipUserDAO.update(vipUser);
        return "update";
    }

    /**
     * 管理员删除后返回用户管理列表
     * @return
     */
    public String delete() {

        vipUserDAO.delete(vipUser.getId());
        return "list";
    }

    /**
     * 管理员查看所有的用户
     * @return
     */
    public String list() {
        vipUsers = vipUserDAO.listUsers();
        return "list";
    }
    public String login() {
        vipUserDAO.select(vipUser.getTel(), vipUser.getPassword());
        ActionContext.getContext().getSession().put("vipUser", vipUser);
        return "success";
    }
}

