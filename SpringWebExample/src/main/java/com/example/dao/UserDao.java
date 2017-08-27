package com.example.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.example.anotatedconfiguration.HibernateConnector;
import com.example.model.User;



@Repository
public class UserDao {
	
	private static List<User> users = new ArrayList<>();

	public List<User> getAllUsers() {
		 Session session = null;
	        try {
	            session = HibernateConnector.getInstance().getSession();
	            Query query = session.createQuery("From User");
	 
	            List queryList = query.list();
	            if (queryList != null && queryList.isEmpty()) {
	                return null;
	            } else {
	                System.out.println("list " + queryList);
	                return users;
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        } finally {
	            session.close();
	        }
	}

	public User getUser(String userName) {
		Session session = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            Query query = session.createQuery("from appuser u where u.username = :username");
            query.setParameter("username", userName);
 
            List queryList = query.list();
            if (queryList != null && queryList.isEmpty()) {
                return null;
            } else {
                return (User) queryList.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
	}

	public Integer deleteUser(String userName) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Integer updateUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Integer createUser(User user) {
		Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            System.out.println("session : "+session);
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            System.out.println("Controller userID: " + user.getUserId());
            return user.getUserId();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
	}

}
