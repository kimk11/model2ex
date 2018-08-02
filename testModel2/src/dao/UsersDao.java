package dao;

import dto.Users;
import util.Close;
import util.DriverConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

public class UsersDao {
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	
	//users ���̺� ������ �Է�
	//���� ture:����, false:����
	public boolean insertUsers(Users users) {
		boolean bCheck = false;
		String sql = "INSERT INTO users (user_id, user_pw, user_name) VALUES (?, ?, ?)";
		try {
			preparedStatement = DriverConnection.getConnectionInfo().prepareStatement(sql);
			preparedStatement.setString(1, users.getUserId());
			preparedStatement.setString(2, users.getUserPw());
			preparedStatement.setString(3, users.getUserName());
			int check = preparedStatement.executeUpdate();
			if(1==check) bCheck = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			new Close(preparedStatement);
		}
		
		return bCheck;
	}
	
	//users ���̺� ��ü ��ȸ
	public ArrayList<Users> selectAllUsers(){
		ArrayList<Users> arrayList = new ArrayList<>();
		String sql = "SELECT user_id, user_pw, user_name FROM users";
		try {
			preparedStatement = DriverConnection.getConnectionInfo().prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Users users = new Users();
				users.setUserId(resultSet.getString(1));
				users.setUserPw(resultSet.getString(2));
				users.setUserName(resultSet.getString(3));
				arrayList.add(users);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			new Close(preparedStatement, resultSet);
		}
		return arrayList;
	}
	
	//users ���̺� ���̵� ��й�ȣ üũ �޼���
	//���ϰ� 0:���̵�, 1:��й�ȣ ����ġ, 2:�Ѵ� ��ġ
	public int loginCheck(Users users) {
		int check = 0;
		String sql = "SELECT user_id, user_pw FROM users WHERE user_id = ?";
		try {
			preparedStatement = DriverConnection.getConnectionInfo().prepareStatement(sql);
			preparedStatement.setString(1, users.getUserId());
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				if(users.getUserPw().equals(resultSet.getString(2))) {
					check = 2;
				}else {
					check = 1;
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			new Close(preparedStatement, resultSet);
		}
		return check;
	}
	
	//users ���̺� �Ѹ� ��ȸ
	//���̵� ����
	public Users selectOneUser(String userId) {
		Users users = new Users();
		String sql = "SELECT user_id, user_pw, user_name FROM users WHERE user_id = ?";
		try {
			preparedStatement = DriverConnection.getConnectionInfo().prepareStatement(sql);
			preparedStatement.setString(1, userId);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				users.setUserId(resultSet.getString(1));
				users.setUserPw(resultSet.getString(2));
				users.setUserName(resultSet.getString(3));
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			new Close(preparedStatement, resultSet);
		}
		return users;
	}
}
