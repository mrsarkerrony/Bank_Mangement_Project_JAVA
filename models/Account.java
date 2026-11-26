package models;
import java.lang.*;

public class Account
{
	protected String accountId;
	private String userId;
	private double balance;
	private String accountType;
	private double interestRate;
	
	public Account ()
	{
		
	}
	
	public Account(String accountId,String userId,double balance ,String accountType,double interestRate)
	{
		this.accountId=accountId;
		this.userId=userId;
		this.balance=balance;
		this.accountType=accountType;
		this.interestRate=interestRate;
		
	}
	
	public void setAccountId(String accountId)
	{
		this.accountId=accountId;
	}
	public void setUserId(String userId)
	{
		this.userId=userId;
	}
	public void setBalance(double balance)
	{
		this.balance=balance;
	}
	
	public void setAccountType(String accountType)
	{
		this.accountType=accountType;
	}
	public void setInterestRate(double interestRate)
	{
		this.interestRate=interestRate;
	}
	
	public String getAccountId(){
		return this.accountId;
	}
public String getUserId(){
	return this.userId;
}

   public double getBalance(){
	   return this.balance;
   }
   public String getAccountType(){
	   return this.accountType;
   }
   public double getInterestRate(){
	   return this.interestRate;
   }
   
   public String toStringAccount()
   {
	   String str=this.accountId+","+this.userId+","+this.balance+","+this.accountType+","+this.interestRate+"\n"; 
	   return str;
   }
   
   public Account formAccount(String str)
   {
	   String data[]=str.split(",");
	   
	   Account ac=new Account();
	   ac.setAccountId(data[0]);
	   ac.setUserId(data[1]);
	   ac.setBalance(Double.parseDouble(data[2]));
	   ac.setAccountType(data[3]);
	   ac.setInterestRate(Double.parseDouble(data[4]));
	   
	   return ac;
   }
}