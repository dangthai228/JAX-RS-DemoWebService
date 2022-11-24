package com.thaind.control;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.thaind.model.User;

public class UserDAO extends DAO {
	//getOne
	public User getUser(int id)
	{
		String sql="Select * from employee where id="+id;
		User u= new User();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			if(rs.next())
			{
				u.setId(id);
				u.setUsername(rs.getString("name"));
				u.setEmail(rs.getString("email"));
				u.setPhone(rs.getString("phone"));
				u.setAddress(rs.getString("address"));
				u.setPosition(rs.getString("position"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			u=null;
			e.printStackTrace();
		}
		return u;
	}
	//GetAll
	public ArrayList<User> getAllUser()
	{
		String sql="Select * from employee ";
		ArrayList<User> list= new ArrayList<>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			while(rs.next())
			{
				User u= new User();
				u.setId(rs.getInt("id"));
				u.setUsername(rs.getString("name"));
				u.setEmail(rs.getString("email"));
				u.setPhone(rs.getString("phone"));
				u.setAddress(rs.getString("address"));
				u.setPosition(rs.getString("position"));
				list.add(u);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return list;
	}
	//Insert 
	public boolean InsertUser(User user) {
		boolean kq= false;
		String sql="insert into employee(name,email,phone,address,position) values(?,?,?,?,?) ";
		try {
			this.con.setAutoCommit(false);
			 PreparedStatement ps = con.prepareStatement(sql);
			 ps.setString(1, user.getUsername());
			 ps.setString(2, user.getEmail());
			 ps.setString(3, user.getPhone());
			 ps.setString(4, user.getAddress());
			 ps.setString(5, user.getPosition());
			 ps.executeUpdate();
			 kq=true;
			
		} catch (Exception e) {
			// TODO: handle exception
			try {
				this.con.rollback(); 
			} catch (Exception ee) {
				// TODO: handle exception
				kq=false;
				ee.printStackTrace();
			}
		} finally {
			try {
				this.con.setAutoCommit(true); 
			} catch (Exception e) {
				// TODO: handle exception
				kq=false;
				e.printStackTrace();
			}
		}
		return kq;
	}
	
	//UpdateUser
	public boolean UpdateUser(User user) {
		boolean kq= false;
		String sql="update employee set name = ?, email =?, phone =?, address=?, position = ? where id="+user.getId();
		try {
			this.con.setAutoCommit(false);
			 PreparedStatement ps = con.prepareStatement(sql);
			 ps.setString(1, user.getUsername());
			 ps.setString(2, user.getEmail());
			 ps.setString(3, user.getPhone());
			 ps.setString(4, user.getAddress());
			 ps.setString(5, user.getPosition());
			 ps.executeUpdate();
			 kq=true;
			
		} catch (Exception e) {
			// TODO: handle exception
			try {
				this.con.rollback(); 
			} catch (Exception ee) {
				// TODO: handle exception
				kq=false;
				ee.printStackTrace();
			}
		} finally {
			try {
				this.con.setAutoCommit(true); 
			} catch (Exception e) {
				// TODO: handle exception
				kq=false;
				e.printStackTrace();
			}
		}
		return kq;
	}
	
	
	//Delete User
	public boolean DeleteUser(int id) {
		boolean kq= false;
		String sql="Delete from employee  where id="+id;
		try {
			this.con.setAutoCommit(false);
			 PreparedStatement ps = con.prepareStatement(sql);
			 ps.executeUpdate();
			 kq=true;
			
		} catch (Exception e) {
			// TODO: handle exception
			try {
				this.con.rollback(); 
			} catch (Exception ee) {
				// TODO: handle exception
				kq=false;
				ee.printStackTrace();
			}
		} finally {
			try {
				this.con.setAutoCommit(true); 
			} catch (Exception e) {
				// TODO: handle exception
				kq=false;
				e.printStackTrace();
			}
		}
		return kq;
	}
}
