package controllers;

import java.lang.*;
import models.*;

public class DepositController
{
	public void insertDeposit(Deposit de)
	{
		Deposit deposits[]=this.getAllDeposit();
		for(int i=0;i<deposits.length;i++)
		{
			if(deposits[i]==null)
			{
				deposits[i]=de;
				break;
			}
		}
		this.write(deposits);
		
		
	}
	
	
	public void updateDeposit(Deposit de)
	{
		Deposit deposits[]=this.getAllDeposit();
		for(int i=0;i<deposits.length;i++)
		{
			if(deposits[i]!=null)
			{
				if(deposits[i].getDepositId().equals(de.getDepositId()))
				{
					deposits[i]=de;
				}	
			}
		}
		this.write(deposits);
		
	}
	
	
	public void deleteDeposit(String DepositId)
	
	{
		
		Deposit deposits[]=this.getAllDeposit();
		for(int i=0;i<deposits.length;i++)
		{
			if(deposits[i]!=null)
			{
				if(deposits[i].getDepositId().equals(DepositId)){
					deposits[i]=null;
				}
			}
		}
		this.write(deposits);
	}
	
	
	public Deposit searchDeposit(String DepositId)
	{
		Deposit deposits[]=this.getAllDeposit();
		
		for(int i=0;i<deposits.length;i++)
		{
			if(deposits[i]!=null)
			{
				if(deposits[i].getDepositId().equals(DepositId)){
					return deposits[i];
				}
			}
		}
		return null;
	}
	
	
	public Deposit searchByUserId(String userId)
	{
		Deposit deposits[]=this.getAllDeposit();
		Deposit targetU[]=new Deposit[100];
		for(int i=0;i<deposits.length;i++)
		{
			if(deposits[i]!=null)
			{
				if(deposits[i].getUserId().equals(userId))
				{
					targetU[i]=deposits[i];
				}
			}
		}
		return targetU;
	}
	
	
	
	public Deposit searchByAccountId(String accountId)
	{
		Deposit deposits[]=this.getAllDeposits();
		Deposit targetU[]=new Deposit[100];
		for(int i=0;i<deposits.length;i++)
		{
			if(deposits[i]!=null)
			{
				if(deposits[i].getAccountId().equals(accountId))
				{
					targetU[i]=deposits[i];
				}
			}
		}
		return targetU;
	}
	public Deposit[] getAllDeposit()
	{
		String fileName="controllers/data/Deposits.txt";
		
		FileIO fio=new FileIO();
		
		String data[]=new String[100];
		data=fio.readFile(fileName);
		
		Deposit deposits[]=new Deposit[100];
		
		for(int i=0;i<data.length;i++)
		{
			if(data[i]!=null)
			{
				Deposit de=new Deposit();
				deposits[i]=de.formDeposit(data[i]);
				
			}
		}
		return deposits;
		
	}
	
	public void write(Deposit deposits[])
	{
		String data[]=new String[100];
		
		for(int i=0;i<data.length;i++)
		{
			if(deposits[i]!=null)
			{
				data[i]=deposits[i].toStringDeposit();
			}
		}
		String fileName="controllers/data/Deposits.txt";
		FileIO fio=new FileIO();
		fio.writeFile(fileName,data);
	}
	
}
