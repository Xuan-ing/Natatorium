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
    //以下绑定前端取出的值
    private String tel;//账号即电话号码
    private String password;
    private String name;
    private String no;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getNo() {
        return no;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getTel() {
        return tel;
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
    public String updatePersonInfo() {
        System.out.println("获取值：" + name + " " + no);
        vipUser.setName(name);
        vipUser.setNo(no);
        vipUserDAO.update(vipUser);
        return "updatePersonInfo";
    }
    public String updatePassword() {
        vipUser.setPassword(password);
        vipUserDAO.update(vipUser);
        return "updatePassword";
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
        System.out.println("获取值：" + tel + " " + password);
        vipUser = vipUserDAO.select(tel);
        //System.out.println(vipUser.getId());
        if (!vipUser.getPassword().equals(password)) {
            return "loginError";
        }
        ActionContext.getContext().getSession().put("vipUser", vipUser);
        return "success";
    }
}

