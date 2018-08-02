package actionContoller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import forward.ForwardAction;
import interfaceAction.InterfaceAction;

import dto.Users;
import Service.UserService;

public class UserLoginAction implements InterfaceAction {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Users users = new Users();
		users.setUserId(request.getParameter("userId"));
		users.setUserPw(request.getParameter("userPw"));
		
		users = new UserService().userLogin(users);
		
		if(users == null) {
			request.setAttribute("check", "아이디와 비밀번호를 확인해주세요.");
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("userSessionName", users.getUserName());
		}
		
		ForwardAction forwardAction = new ForwardAction();
		forwardAction.setForward(true);
		forwardAction.setPath("/login/userLoginForm.jsp");
		return forwardAction;
	}

}
