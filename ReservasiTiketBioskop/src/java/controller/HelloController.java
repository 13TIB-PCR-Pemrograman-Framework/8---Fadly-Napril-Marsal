/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import service.HelloService;

/**
 *
 * @author LabGSG
 */
public class HelloController extends SimpleFormController {
    
    public HelloController() {
        //Initialize controller properties here or 
        //in the Web Application Context

        setCommandClass(User.class);
        setCommandName("name");
        setSuccessView("helloView");
        setFormView("nameView");
    }
    
    @Override
    protected void doSubmitAction(Object command) throws Exception {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
protected ModelAndView onSubmit(
            HttpServletRequest request,
            HttpServletResponse response,
            Object command,
            BindException errors) throws Exception {

        User name = (User) command;
        ModelAndView mv = new ModelAndView(getSuccessView());
        mv.addObject("nama", helloService.tampilNama(name.getNama()));
       
        mv.addObject("alamat", helloService.tampilAlamat(name.getAlamat()));
        mv.addObject("telp", helloService.tampilTelp(name.getTelp()));
        mv.addObject("email", helloService.sayEmail(name.getEmail()));
        return mv;
}
private HelloService helloService;
public void setHelloService(HelloService helloService) {
    this.helloService = helloService;
}
    //Use onSubmit instead of doSubmitAction 
    //when you need access to the Request, Response, or BindException objects
    /*
     @Override
     protected ModelAndView onSubmit(
     HttpServletRequest request, 
     HttpServletResponse response, 
     Object command, 
     BindException errors) throws Exception {
     ModelAndView mv = new ModelAndView(getSuccessView());
     //Do something...
     return mv;
     }
     */
}
