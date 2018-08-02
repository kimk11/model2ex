package actionContoller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import forward.ForwardAction;
import interfaceAction.InterfaceAction;
import Service.UserService;
import dto.Users;
import java.util.ArrayList;

public class SelectUserAction implements InterfaceAction {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		ArrayList<Users> arrayList = new UserService().selectAllUserService();
//		for(Users a : arrayList) {
//			System.out.println(a.getUserId());
//		}
		
		request.setAttribute("users", arrayList);
		
		ForwardAction forwardAction = new ForwardAction();
		forwardAction.setForward(true);
		forwardAction.setPath("/user/selectUserList.jsp");
		return forwardAction;
	}

}
