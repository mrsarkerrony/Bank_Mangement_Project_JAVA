package controllers;
import java.lang.*;
import models.*;

public class WithdrawController
{
	public void insertWithdraw(Withdraw w)
	
	{
	  Withdraw withdraws[]=this.getAllWithdraw();
	  for(int i=0;i<withdraws.length;i++)
	  {
		  if(withdraws[i]==null)
		  {
			  withdraws[i]=w;
			  break;
		  }
	  }
	  this.write(withdraws);
	}
	
	
	public void updateWithdraw(Withdraw w)
	{
		Withdraw withdraws[]=this.getAllWithdraw();
		for(int i=0;i<withdraws.length;i++)
		{
			if(withdraws[i]!=null)
			{
				if(withdraws[i].getWithdrawId().equals(w.getWithdrawId()))
				{
					withdraws[i]=w;
				}
				
			
			}
		}
	this.write(withdraws);
	}
	
	
	
	public void deleteAccount(String WithdrawId)
	{
		Withdraw withdraws[]=this.getAllWithdraw();
		for(int i=0;i<withdraws.length;i++)
		{
			if(withdraws[i]!=null)
			{
				if(withdraws[i].getWithdrawId().equals(WithdrawId))
				{
					withdraws[i]=null;
				}
			}
		}
		this.write(withdraws);
		
	}
	
	public Withdraw searchWithdraw(String WithdrawId)
	{
		Withdraw withdraws[]=this.getAllWithdraw();
		for(int i=0;i<withdraws.length;i++)
		{
			if(withdraws[i]!=null)
			{
				if(withdraws[i].getWithdrawId().equals(WithdrawId))
				{
					return withdraws[i];
				}
			}
		}
		return null;
		
	}
	
	public Withdraw[] searchByUserId(String userId)
	{
		Withdraw withdraws[]=this.getAllWithdraw();
		Withdraw targetA[]=new Withdraw[100];
		
		for(int i=0;i<withdraws.length;i++)
		{
			if(withdraws[i]!=null)
			{
				if(withdraws[i].getUserId().equals(userId))
				{
					targetA[i]=withdraws[i];
				}
			}
		}
		return targetA;
	}
	
	
	public Withdraw searchByAccountId(String accountId)
	{
		Withdraw withdraws[]=this.getAllWithdraw();
		Withdraw targetA[]=new Withdraw[100];
		
		for(int i=0;i<withdraws.length;i++)
		{
			if(withdraws[i]!=null)
			{
				if(withdraws[i].getAccountId().equals(accountId))
				{
					targetA[i]=withdraws[i];
				}
			}
		}
		return targetA;
	}
	
	
	public Withdraw[]  getAllWithdraw()
	{
		String fileName="controllers/data/withdraws.txt";
		
		FileIO fio=new FileIO();
		
		String data[]=new String[100];
		data=fio.readFile(fileName);
		
		Withdraw withdraws[]=new Withdraw[100];
		
		for(int i=0;i<data.length;i++)
		{
			
			if(data[i]!=null)
			{
				Withdraw w=new Withdraw();
				withdraws[i]=w.formWithdraw(data[i]);
			}
		}
		
		return withdraws;
		
	}
	
	public void write(Withdraw withdraws[])
	{
		String data[]=new String [100];
		for(int i=0;i<data.length;i++)
		{
			if(withdraws[i]!=null)
			{
				data[i]=withdraws[i].toStringWithdraw();
				
			}
		}
		String fileName="controllers/data/withdraws.txt";
		FileIO fio=new FileIO();
		fio.writeFile(fileName,data);
	}
}