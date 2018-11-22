package ui.view;

import domain.model.Person;
import domain.model.ShopService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class SignUp extends RequestHandler {

    PersonOverview personOverview = new PersonOverview();



    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<String> error = new ArrayList<>();
        Person p = new Person();

        getUserId(p,request,error);
        getFirstName(p,request,error);
        getLastName(p,request,error);
        getEmail(p,request,error);
        getPass(p,request,error);

        if(error.size()==0){
            try{
                getService().addPerson(p);
                personOverview.setService(getService());
                return personOverview.handleRequest(request,response);
            }catch (IllegalArgumentException e){
                request.setAttribute("errors",e.getMessage());
                return "signUp.jsp";
            }
        }
        else{
            request.setAttribute("errors",error);
            return "signUp.jsp";
        }
    }

    private void getUserId(Person p, HttpServletRequest request, ArrayList<String>error)
    {
        String id = request.getParameter("userid");
        try{
            p.setUserid(id);
            request.setAttribute("PreId",id);

        }catch(Exception ex){
            error.add(ex.getMessage());
        }
    }

    private void getFirstName(Person p, HttpServletRequest request, ArrayList<String>error)
    {
        String fname = request.getParameter("firstName");
        try{
            p.setFirstName(fname);
            request.setAttribute("PreFname",fname);

        }catch(Exception ex){
            error.add(ex.getMessage());
        }
    }

    private void getLastName(Person p, HttpServletRequest request, ArrayList<String>error)
    {
        String lname = request.getParameter("lastName");
        try{
            p.setLastName(lname);
            request.setAttribute("PreLname",lname);

        }catch(Exception ex){
            error.add(ex.getMessage());
        }
    }

    private void getEmail(Person p, HttpServletRequest request, ArrayList<String>error)
    {
        String email = request.getParameter("email");
        try{
            p.setEmail(email);
            request.setAttribute("PreEmail",email);

        }catch(Exception ex){
            error.add(ex.getMessage());
        }
    }

    private void getPass(Person p, HttpServletRequest request, ArrayList<String>error)
    {
        String password = request.getParameter("password");
        try{
            p.setHashPassword(password);
            request.setAttribute("PrePass",password);

        }catch(Exception ex){
            error.add(ex.getMessage());
        }
    }
}
