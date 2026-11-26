package models;
import java.lang.*;

public class Loan

{
	private String loanId;
	private String accountId;
	private double amount;
	private String date;
	
	public Loan()
	{
		
	}
	public Loan(String loanId,String accountId,double amount,String date)
	{
		this.loanId=loanId;
		this.accountId=accountId;
		this.amount=amount;
		this.date=date;
	}
	public void setLoanId(String loanId)
	{
		this.loanId=loanId;
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
	
	public String getLoanId(){
		return this.loanId;
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
	
	public String toStringLoan()
	{
		String str=this.loanId+","+this.accountId+","+this.amount+","+this.date+"\n";
		return str;
	}
	
	public Loan formLoan(String str)
	{
		String data[]=str.split(",");
		
		Loan l=new Loan();
		l.setLoanId(data[0]);
		l.setAccountId(data[1]);
		l.setAmount(Double.parseDouble(data[2]));
		l.setDate(data[3]);
		
		return l;
	}
}