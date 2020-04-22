package action;

import com.opensymphony.xwork2.ModelDriven;
import dao.VipUserDAO;
import entity.VipUser;

import java.util.List;

public class VipUserAction extends SuperAction implements ModelDriven<VipUser> {

    private VipUser vipUser = new VipUser();
    private static final long serialVersionUID = 1L;

    @Override
    public VipUser getModel() {
        return this.vipUser;
    }

    /**
     * 直接添加当前用户---注册
     *
     */

    public String add() {
        VipUserDAO vipUserDAO = new VipUserDAO();
        vipUserDAO.add(vipUser);//根据填入信息
        return "add_success";
    }

    /*
    管理员根据点击的id，修改对应用户的信息
    id作为参数，由链接传递进来
     */
    public String update() {
        int id = Integer.parseInt(request.getParameter("id"));
        VipUserDAO vipUserDAO = new VipUserDAO();
        VipUser user = vipUserDAO.get(id);
        session.setAttribute("update_user",user);
        return "update_success";
    }
    /*
    用户自己更新信息
    易错：更新的对象应该是查询后再修改，而不是直接修改登入的。
    这会导致.OptimisticLockException
*/
    public String save() {
        VipUserDAO vipUserDAO = new VipUserDAO();
        vipUserDAO.update(vipUser);//根据填入信息
        return "save_success";
    }
    /**
     * 根据前端传入的id
     * 管理员删除后返回用户管理列表
     *
     */
    public String delete() {
        VipUserDAO vipUserDAO = new VipUserDAO();
        int id = Integer.parseInt(request.getParameter("id"));//根据选中表中数据
        vipUserDAO.delete(id);
        return "delete_success";
    }

    /**
     * 管理员查看所有的用户
     *
     */
    public String list() {
        VipUserDAO vipUserDAO = new VipUserDAO();
        List<VipUser> vipUsers = vipUserDAO.listUsers();
        if(vipUsers!=null&&vipUsers.size()>0) {
            session.setAttribute("vipUsers",vipUsers);
        }
        return "list";
    }
    /*
    管理员查询某个用户
     */
    public String inquire() {
        VipUserDAO vipUserDAO = new VipUserDAO();
        VipUser user = vipUserDAO.get(vipUser.getId());//根据搜索框输入的id
        session.setAttribute("vipUser_selected",user);
        return "inquire_success";
    }


}