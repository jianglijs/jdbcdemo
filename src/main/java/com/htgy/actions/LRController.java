package com.htgy.actions;

/*
 * Controller��
 */
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;  
import com.htgy.form.UserForm;
import com.htgy.service.impl.ServiceImpl;
import com.htgy.view.View;

@Controller //@Controller���ڱ�ע���Ʋ����(��struts�е�action)
public class LRController {
    @Resource
    private ServiceImpl sI;
    @Resource
    private View view;

    //��ת��ע��ҳ��
    @RequestMapping("/toRegist") // ����URL��ַӳ��
    public ModelAndView toRegist(){  
        return new ModelAndView("regist"); // �ֶ�ʵ����ModelAndView�����תҳ�棬Ч����ͬ�����淵���ַ����ķ���
        //return new ModelAndView(new RedirectView("../index.jsp"));  �����ض���ʽ��תҳ�� 
        //return new ModelAndView("redirect:../index.jsp"); ��һ�ּ򵥵ķ���
    }
    //��ת����¼ҳ��
    @RequestMapping({"/","/toLogin"}) // "/"��ʾ������ҳ������
    public String toLogin(){
        return "login"; 

    }
    //��¼
    @RequestMapping("/doLogin")
    protected ModelAndView doLogin(UserForm userForm){
        // request��response���ط�Ҫ�����ڷ����У�����ò��ϵĻ�����ȥ��
        // ֧�ֲ���Ϊ������
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

    //ע��
    @RequestMapping("/doRegist")
    protected ModelAndView doRegist(UserForm userform){
        String account = userform.getAccount();
        String passFirst = userform.getPassFirst();
        String passSecond = userform.getPassSecond();
        String username = userform.getUsername();
        System.out.println("doRegist user = "+ userform.toString());
        //�ж�
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