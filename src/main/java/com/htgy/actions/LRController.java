package com.htgy.actions;

/*
 * Controller类
 */
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;  
import com.htgy.form.UserForm;
import com.htgy.service.impl.ServiceImpl;
import com.htgy.view.View;

@Controller //@Controller用于标注控制层组件(如struts中的action)
public class LRController {
    @Resource
    private ServiceImpl sI;
    @Resource
    private View view;

    //跳转到注册页面
    @RequestMapping("/toRegist") // 请求URL地址映射
    public ModelAndView toRegist(){  
        return new ModelAndView("regist"); // 手动实例化ModelAndView完成跳转页面，效果等同于下面返回字符串的方法
        //return new ModelAndView(new RedirectView("../index.jsp"));  采用重定向方式跳转页面 
        //return new ModelAndView("redirect:../index.jsp"); 另一种简单的方法
    }
    //跳转到登录页面
    @RequestMapping({"/","/toLogin"}) // "/"表示访问首页的请求
    public String toLogin(){
        return "login"; 

    }
    //登录
    @RequestMapping("/doLogin")
    protected ModelAndView doLogin(UserForm userForm){
        // request和response不必非要出现在方法中，如果用不上的话可以去掉
        // 支持参数为表单对象
    	System.out.println("doLogin");
        String account = userForm.getAccount();
        String password = userForm.getPassword();
        if(account.equals("")&&password.equals("")){
            return new ModelAndView(view.getLogin(),sI.dealNull());
        }
        else if(sI.doquery(account,password)){
            return new ModelAndView(view.getLoginSuccess(),sI.loginSuccess());
        }
        else{
            return new ModelAndView(view.getLogin(),sI.error());
        }
    }

    //注册
    @RequestMapping("/doRegist")
    protected ModelAndView doRegist(UserForm userform){
        String account = userform.getAccount();
        String passFirst = userform.getPassFirst();
        String passSecond = userform.getPassSecond();
        String username = userform.getUsername();
        System.out.println("doRegist user = "+ userform.toString());
        //判断
        if(account.equals("")||passFirst.equals("")
                ||passSecond.equals("")||username.equals("")){
            return new ModelAndView(view.getRegist(),sI.intact());
        }
        else if(account.length()<4||passFirst.length()<4
                ||passSecond.length()<4){
            return new ModelAndView(view.getRegist(),sI.correct());
        }
        else if(!passFirst.equals(passSecond)){
            return new ModelAndView(view.getRegist(),sI.consistent());
        }

        else if(sI.queryAccount(account)){
            return new ModelAndView(view.getRegist(),sI.accountExist());
        }
        else if(sI.queryUsername(username)){
            return new ModelAndView(view.getRegist(),sI.usernameExist());
        }
        else{
            sI.insert(account,passFirst,username);
            return new ModelAndView(view.getRegistSuccess());
        }
    }
}