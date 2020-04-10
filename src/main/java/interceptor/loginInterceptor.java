package interceptor;

import action.VipUserAction;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import entity.VipUser;

import java.util.Map;

public class loginInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        Object object = actionInvocation.getAction();
        if(object != null) {
            return actionInvocation.invoke();
        }
        return "loginError";
    }
}
