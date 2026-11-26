package controllers;

import java.lang.*;
import models.*;

public class AccountController
{
	public void insertAccount(Account ac)
	{
		Account accounts[]=this.getAllAccount();
		for(int i=0;i<accounts.length;i++)
		{
			if(accounts[i]==null)
			{
				accounts[i]=ac;
				break;
			}
		}
		this.write(accounts);
		
		
	}
	
	
	public void updateAccount(Account ac)
	{
		Account accounts[]=this.getAllAccount();
		for(int i=0;i<accounts.length;i++)
		{
			if(accounts[i]!=null)
			{
				if(accounts[i].getAccountId().equals(ac.getAccountId()))
				{
					accounts[i]=ac;
				}	
			}
		}
		this.write(accounts);
		
	}
	
	
	public void deleteAccount(String accountId)
	
	{
		
		Account accounts[]=this.getAllAccount();
		for(int i=0;i<accounts.length;i++)
		{
			if(accounts[i]!=null)
			{
				if(accounts[i].getAccountId().equals(accountId)){
					accounts[i]=null;
				}
			}
		}
		this.write(accounts);
	}
	
	
	public Account searchAccount(String accountId)
	{
		Account accounts[]=this.getAllAccount();
		
		for(int i=0;i<accounts.length;i++)
		{
			if(accounts[i]!=null)
			{
				if(accounts[i].getAccountId().equals(accountId)){
					return accounts[i];
				}
			}
		}
		return null;
	}
	
	public Account[] getAllAccount()
	{
		String fileName="controllers/data/Accounts.txt";
		
		FileIO fio=new FileIO();
		
		String data[]=new String[100];
		data=fio.readFile(fileName);
		
		Account accounts[]=new Account[100];
		
		for(int i=0;i<data.length;i++)
		{
			if(data[i]!=null)
			{
				Account ac=new Account();
				accounts[i]=ac.formAccount(data[i]);
				
			}
		}
		return accounts;
		
	}
	
	public void write(Account accounts[])
	{
		String data[]=new String[100];
		
		for(int i=0;i<data.length;i++)
		{
			if(accounts[i]!=null)
			{
				data[i]=accounts[i].toStringAccount();
			}
		}
		String fileName="controllers/data/Accounts.txt";
		FileIO fio=new FileIO();
		fio.writeFile(fileName,data);
	}
	
}
