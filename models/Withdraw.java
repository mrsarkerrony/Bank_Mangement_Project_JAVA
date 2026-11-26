package models;
import java.lang.*;

public class Withdraw
{
	private String withdrawId;
	private String accountId;
	private double amount;
	private String date;
	
	public Withdraw()
	{
		
	}
	public Withdraw(String withdrawId,String accountId,double amount,String date)
	{
		this.withdrawId=withdrawId;
		this.accountId=accountId;
		this.amount=amount;
		this.date=date;
	}
	public void setWithdrawId(String withdrawId)
	{
		this.withdrawId=withdrawId;
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
	
	public String getWithdrawId(){
		return this.withdrawId;
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
	
	public String toStringWithdraw()
	{
		String str=this.withdrawId+","+this.accountId+","+this.amount+","+this.date+"\n";
		return str;
	}
	
	public Withdraw formWithdraw(String str)
	{
		String data[]=str.split(",");
		
		Withdraw w=new Withdraw();
		w.setWithdrawId(data[0]);
		w.setAccountId(data[1]);
		w.setAmount(Double.parseDouble(data[2]));
		w.setDate(data[3]);
		
		return w;
	}
}