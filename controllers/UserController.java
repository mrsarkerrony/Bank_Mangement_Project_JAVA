package controllers;

import java.lang.*;
import models.*;

public class UserController
{
	public void insertUser(User u)
	{
		User users[]=this.getAllUser();
		for(int i=0;i<users.length;i++)
		{
			if(users[i]==null)
			{
				users[i]=u;
				break;
			}
		}
		this.write(users);
		
		
	}
	
	
	public void updateUser(User u)
	{
		User users[]=this.getAllUser();
		for(int i=0;i<users.length;i++)
		{
			if(users[i]!=null)
			{
				if(users[i].getUserId().equals(u.getUserId()))
				{
					users[i]=u;
				}	
			}
		}
		this.write(users);
		
	}
	
	
	public void deleteUser(String userId)
	
	{
		
		User users[]=this.getAllUser();
		for(int i=0;i<users.length;i++)
		{
			if(users[i]!=null)
			{
				if(users[i].getUserId().equals(userId)){
					users[i]=null;
				}
			}
		}
		this.write(users);
	}
	
	
	public User searchUser(String userId)
	{
		User users[]=this.getAllUser();
		
		for(int i=0;i<users.length;i++)
		{
			if(users[i]!=null)
			{
				if(users[i].getUserId().equals(userId)){
					return users[i];
				}
			}
		}
		return null;
	}
	
	public User[] getAllUser()
	{
		String fileName="controllers/data/Users.txt";
		
		FileIO fio=new FileIO();
		
		String data[]=new String[100];
		data=fio.readFile(fileName);
		
		User users[]=new User[100];
		
		for(int i=0;i<data.length;i++)
		{
			if(data[i]!=null)
			{
				User u=new User();
				users[i]=u.formUser(data[i]);
				
			}
		}
		return users;
		
	}
	
	public void write(User users[])
	{
		String data[]=new String[100];
		
		for(int i=0;i<data.length;i++)
		{
			if(users[i]!=null)
			{
				data[i]=users[i].toStringUser();
			}
		}
		String fileName="controllers/data/Users.txt";
		FileIO fio=new FileIO();
		fio.writeFile(fileName,data);
	}
	
}
