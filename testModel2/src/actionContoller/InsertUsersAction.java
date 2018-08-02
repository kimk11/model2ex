package actionContoller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import forward.ForwardAction;
import interfaceAction.InterfaceAction;
import Service.UserService;
import dto.Users;

public class InsertUsersAction implements InterfaceAction {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Users users = new Users();
		users.setUserId(request.getParameter("userId"));
		users.setUserPw(request.getParameter("userPw"));
		users.setUserName(request.getParameter("userName"));
		
		new UserService().insertUserService(users);
		
		ForwardAction forwardAction = new ForwardAction();
		forwardAction.setForward(false);
		forwardAction.setPath("/user/list.kjw");
		
		return forwardAction;
	}

}
