package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.UserService;
import actionContoller.InsertUsersAction;
import actionContoller.SelectUserAction;
import actionContoller.UserLoginAction;
import actionContoller.UserLogoutAction;
import interfaceAction.InterfaceAction;
import sun.rmi.server.Dispatcher;
import forward.ForwardAction;


@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPocess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPocess(request, response);
	}
	
	protected void doPocess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		String path = request.getContextPath();
		String uri = request.getRequestURI();
		String command = uri.substring(path.length());
		
		ForwardAction forwardAction = null;
		InterfaceAction interfaceAction = null;
		
		if(command.equals("/user/insertForm.kjw")) {
			forwardAction  = new ForwardAction();
			forwardAction.setForward(true);
			forwardAction.setPath("/user/insertUserForm.jsp");
		}else if(command.equals("/user/insertAction.kjw")) {
			
			interfaceAction = new InsertUsersAction();
			try {
				forwardAction = interfaceAction.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/user/list.kjw")) {
			interfaceAction = new SelectUserAction();
			try {
				forwardAction = interfaceAction.execute(request, response);
//				System.out.println(forwardAction.getPath()+"<<contoller");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/login.kjw")){
			forwardAction = new ForwardAction();
			forwardAction.setForward(true);
			forwardAction.setPath("/login/userLoginForm.jsp");
		}else if(command.equals("/login/action.kjw")) {
			interfaceAction = new UserLoginAction();
			try {
				forwardAction = interfaceAction.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/logout/action.kjw")) {
			interfaceAction = new UserLogoutAction();
			try {
				forwardAction = interfaceAction.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(forwardAction != null) {
			if(forwardAction.isForward()) {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forwardAction.getPath());
				dispatcher.forward(request, response);
			}else {
				response.sendRedirect(forwardAction.getPath());
			}
		}
	}

}
