package com.socialappbackend.dao;

import java.util.List;

import com.socialappbackend.model.userdetail;
public interface userdao {
	
public boolean adduser(userdetail user);
public boolean updateuser(userdetail user);
public boolean deleteuser(userdetail user);
public List<userdetail> getalluser();
public userdetail getuserbyid(int userId);
public boolean changeonlinestatus(userdetail user);
}
