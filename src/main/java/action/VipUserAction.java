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

    public VipUser getVipUser() {
        return vipUser;
    }

    public void setVipUser(VipUser vipUser) {
        this.vipUser = vipUser;
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
    易错：由于没有输入对象的id，所以网页的vipUser.getId()是0
    我们修改的时候其他属性用vipUser.getXX()
    但是查询数据库的时候应该用session.getAttribute()里的id
    否者Exception occurred during processing request：null
*/
    public String updatePersonInfo() {
        VipUserDAO vipUserDAO = new VipUserDAO();
        VipUser curVipUser= (VipUser)session.getAttribute("curVipUser");
        //System.out.println("网页里的数据：" + vipUser.getName() +" " + vipUser.getNo());
        vipUserDAO.updatePersonInfo(curVipUser.getId(),vipUser);//根据填入信息跟新数据库
        VipUser newSessionVipUser = vipUserDAO.select(curVipUser.getTel());
        session.setAttribute("curVipUser",newSessionVipUser);//用数据库的信息更新session
        return "save_success";
    }
    public String updatePassword() {
        VipUserDAO vipUserDAO = new VipUserDAO();
        VipUser curVipUser= (VipUser)session.getAttribute("curVipUser");
        vipUserDAO.updatePassword(curVipUser.getId(),vipUser.getPassword());//根据填入信息跟新数据库
        VipUser newSessionVipUser = vipUserDAO.select(curVipUser.getTel());
        session.setAttribute("curVipUser",newSessionVipUser);//用数据库的信息更新session
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