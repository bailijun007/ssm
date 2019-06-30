package cn.blj;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.blj.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


//实现Spring拦截器接口 HandlerInterceptor
public class HeaderTokenInterceptor implements HandlerInterceptor {
    @Autowired
//该注解使Spring自动为bean设置get与set。
            JWTUtil jwtUtil;//JWT工具类

    //第一个函数preHandle是预处理函数,比如我们用于拦截登录时,它是第一个工作的。
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        //System.out.println("进入preHandle方法");
        String headerToken = httpServletRequest.getHeader("token");
        //获取我们请求头中的token验证字符
        String tokenStr = httpServletRequest.getParameter("token");
        //getParameter的变量是放在我们请求附带的对象中的字符串,例如post方法中附带的account变量等。
        if (!httpServletRequest.getRequestURI().contains("login")) {
            //检测当前页面,我们设置当页面不是登录页面时对其进行拦截
            //具体方法就是检测URL中有没有login字符串
            if (headerToken == null && tokenStr == null) {
                httpServletResponse.sendRedirect("login.do");
                //如果token不存在的话,我们将页面重定向到login.do,也就是登录页面去。
                return false;
                //当返回值是false的时候,表示拦截器不会进行处理了,我们调用response来进行响应。
            }
            if (tokenStr != null) {
                headerToken = tokenStr;
                //进行token同步,后面我们会对token做验证与更新
            }
            try {
                headerToken = jwtUtil.updateToken(headerToken);
                //对token进行更新与验证
            } catch (Exception e) {
                httpServletResponse.sendRedirect("login.do");
                //当token验证出现异常返回到登录页面
                return false;
            }
            System.out.println("real token:==" + headerToken);
            System.out.println("real Cookie:==" + httpServletRequest.getHeader("Cookie"));
        }
        httpServletResponse.setHeader("token", headerToken);
        //将token加入返回页面的header
        return true;
        //当返回true表示第一个阶段结束,随后会执行postHandle和afterCompletion
    }

    //当请求到达Controller但是未渲染View时进行处理
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }
}