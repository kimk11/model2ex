package Service;

import java.util.ArrayList;

import dao.UsersDao;
import dto.Users;
import util.Close;
import util.DriverConnection;
import util.Rollback;

public class UserService {
	private UsersDao usersDao; 
	public UserService() {
		usersDao = new UsersDao();
	}
	
	//회원가입 메서드
	//리턴 ture : commit, false : rollback
	public boolean insertUserService(Users users) {
		boolean insertCheck = false;
		try {
			boolean check = usersDao.insertUsers(users);
			if(check) {
				DriverConnection.connection.commit();
				insertCheck = true;
			}else {
				new Rollback(DriverConnection.connection);
			}
		}catch (Exception e) {
			// TODO: handle exception
			new Rollback(DriverConnection.connection);
			e.printStackTrace();
		}finally {
			new Close(DriverConnection.connection);
		}
		
		return insertCheck;
	}
	
	//회원목록 전체 리스트
	public ArrayList<Users> selectAllUserService(){
		ArrayList<Users> arrayList = null;
		try {
			arrayList = new UsersDao().selectAllUsers();
			
//			for(Users a : arrayList) {
//				System.out.println(a.getUserId());
//			}
			
			if(arrayList != null) {
				DriverConnection.connection.commit();

			}else {
				new Rollback(DriverConnection.connection);
			}
		} catch (Exception e) {
			// TODO: handle exception
			new Rollback(DriverConnection.connection);
			e.printStackTrace();
		}finally {
			new Close(DriverConnection.connection);
		}
		return arrayList;
	}
	
	//login 처리 메서드
	public Users userLogin(Users users) {
		Users user = null;
		try {
			int check = usersDao.loginCheck(users);
			if(check==2) {
				user = usersDao.selectOneUser(users.getUserId());
			}
			if(user != null) {
				DriverConnection.connection.commit();
			}else {
				new Rollback(DriverConnection.connection);
			}
		} catch (Exception e) {
			// TODO: handle exception
			new Rollback(DriverConnection.connection);
			e.printStackTrace();
		}finally {
			new Close(DriverConnection.connection);
		}
		return user;
	}
}
