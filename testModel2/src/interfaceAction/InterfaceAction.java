package interfaceAction;

import forward.ForwardAction;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
public interface InterfaceAction {
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
