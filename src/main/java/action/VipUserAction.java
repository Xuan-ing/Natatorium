package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.VipUserDAO;
import entity.VipUser;

import java.util.LinkedList;
import java.util.List;

public class VipUserAction extends ActionSupport {
    private VipUserDAO vipUserDAO = new VipUserDAO();
    private VipUser vipUser = new VipUser();
    private List<VipUser> vipUsers = new LinkedList<>();
    private String username;
    private String password;

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public List<VipUser> getVipUsers() {
        return vipUsers;
    }

    public void setVipUsers(List<VipUser> vipUsers) {
        this.vipUsers = vipUsers;
    }

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

    @Override
    public String execute() throws Exception {
        System.out.println("获取值："+username+" "+password);
        vipUser = vipUserDAO.select(username, password);
        //System.out.println(vipUser.getId());
        if(vipUser == null) {
            return "loginError";
        }
        ActionContext.getContext().getSession().put("vipUser", vipUser);
        return "success";
    }
}

