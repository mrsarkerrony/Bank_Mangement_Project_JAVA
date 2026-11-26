package controllers;
import java.lang.*;
import models.*;
//import java.io.*;

public class AdminController
{
	public void insertAdmin(Admin a)
	{
		Admin admins[]=this.getAllAdmin();
		for(int i=0;i<admins.length;i++)
		{
			if(admins[i]==null)
			{
				admins[i]=a;
				break;
				
			}
		}
		this.write(admins);
		
		
	}
	
	public void updateAdmin(Admin a)
	{
		Admin admins[]=this.getAllAdmin();
		
		for(int i=0;i<admins.length;i++)
		{
			if(admins[i]!=null)
			{
				if(admins[i].getUserId().equals(a.getUserId()))
				{
					admins[i]=a;
				}
				
			}
			this.write(admins);
		}
		
		
	}
	
	
	public Admin searchAdmin(String userId)
	{
		Admin admins[]=this.getAllAdmin();
		for(int i=0;i<admins.length;i++){
		if(admins[i]!=null)
			{
				if(admins[i].getUserId().equals(userId))
				{
					return admins[i];
				}
				
			}
		}
		return null;
		
	}
	
	public void deleteAdmin(String userId)
	{Admin admins[]=this.getAllAdmin();
		
		for(int i=0;i<admins.length;i++)
		{
			if(admins[i]!=null)
			{
				if(admins[i].getUserId().equals(userId))
				{
					admins[i]=null;
				}
				
			}
		}
		
	this.write(admins);
	}
	
	public Admin[] getAllAdmin()
	{
		String fileName="controllers/data/Admins.txt";
		FileIO fio=new FileIO();
		
		String data[]=new String [100];
		data=fio.readFile(fileName);
		
		Admin admins[]=new Admin[100];
		
		for(int i=0;i<data.length;i++)
		{
			if(data[i]!=null)
			{
				Admin a=new Admin();
				admins[i]=a.formAdmin(data[i]);
			}
		}
		return admins;
	}
	
	
	public void write(Admin admins[])
	{
		String data[]=new String[100];
		
		for(int i=0;i<data.length;i++)
		{
			if(admins[i]!=null)
			{
				data[i]=admins[i].toStringAdmin();
			}
		}
		
		String fileName="controllers/data/Admins.txt";
		FileIO fio=new FileIO();
		fio.writeFile(fileName, data);
		
	}
}