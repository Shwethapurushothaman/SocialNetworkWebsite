package com.socialappbackend.dao;
import java.util.List;

import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.socialappbackend.model.userdetail;
@Repository("userdao")

public class userdaoimpl implements userdao{

	@Autowired
	SessionFactory sessionFactory;
	
	public userdaoimpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional

	public boolean adduser(userdetail user) 
	{
		try
		{
		sessionFactory.getCurrentSession().save(user);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}
	}
	@Transactional
	public userdetail getuserbyid(int userId) 
	{
		
	    Session session=sessionFactory.openSession();
	    userdetail ud=(userdetail) session.get(userdetail.class,new Integer(userId));
	    session.flush();
	    session.close();
		return ud;
		 
	}
@Transactional
public boolean updateuser(userdetail user)
{
try
	{
	 Session session=sessionFactory.openSession();
	session.saveOrUpdate(user);
	System.out.println("updated successfully");
	session.flush();
	session.close();
	return true;
	}
	catch(Exception e)
	{
	System.out.println(e);
	return false;	
}
}
@Transactional
public boolean deleteuser(userdetail user)
{
try
	{
	sessionFactory.getCurrentSession().delete(user);
	 System.out.println("deleted successfully");
	return true;
	}
	catch(Exception e)
	{
	System.out.println(e);
	return false;	
}
}
@Transactional
public List<userdetail> getalluser()
{
	Session session=sessionFactory.openSession();
	String hql="from userdetail";
	Query query=session.createQuery(hql);
	return query.list();
}
@Transactional
public boolean changeonlinestatus(userdetail user)
{
	try
	{
	user.setIsOnline(user.getStatus());
	sessionFactory.getCurrentSession().saveOrUpdate(user);
	System.out.println("online status updated");
	return true;
}
	catch(Exception e)
	{
		System.out.println(e);
		return false;	
	}
}
}