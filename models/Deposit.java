package models;
import java.lang.*;

public class Deposit
{
	private String depositId;
	private String accountId;
	private double amount;
	private String date;
	
	public Deposit()
	{
		
	}
	public Deposit(String depositId,String accountId,double amount,String date)
	{
		this.depositId=depositId;
		this.accountId=accountId;
		this.amount=amount;
		this.date=date;
	}
	public void setDepositId(String depositId)
	{
		this.depositId=depositId;
	}
	public void setAccountId(String acountId)
	{
		this.accountId=accountId;
	}
	public void setAmount(double amount)
	{
		this.amount=amount;
	}
	public void setDate(String date)
	{
		this.date=date;
	}
	
	public String getDepositId(){
		return this.depositId;
	}
	public String getAccountId(){
		return this.accountId;
	}
	public double getAmount(){
		return this.amount;
	}
	public String getDate(){
		return this.date;
	}
	
	public String toStringDeposit()
	{
		String str=this.depositId+","+this.accountId+","+this.amount+","+this.date+"\n";
		return str;
	}
	
	public Deposit formDeposit(String str)
	{
		String data[]=str.split(",");
		
		Deposit d=new Deposit();
		d.setDepositId(data[0]);
		d.setAccountId(data[1]);
		d.setAmount(Double.parseDouble(data[2]));
		d.setDate(data[3]);
		
		return d;
	}
}