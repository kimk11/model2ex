package actionContoller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import forward.ForwardAction;
import interfaceAction.InterfaceAction;

public class UserLogoutAction implements InterfaceAction {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.invalidate();
		
		ForwardAction forwardAction = new ForwardAction();
		forwardAction.setForward(true);
		forwardAction.setPath("/login.kjw");
		return forwardAction;
	}

}
