package controllers;
import java.lang.*;
import models.*;

public class LoanController
{
	public void insertLoan(Loan l)
	{
		Loan loans[]=this.getAllLoan();
		for(int i=0;i<loans.length;i++)
		{
			if(loans[i]==null)
			{
				loans[i]=l;
				break;
			}
		 
		}
		this.write(loans);
	}
	
	public void updateLoan(Loan l)
	{
		Loan loans[]=this.getAllLoan();
		for(int i=0;i<loans.length;i++)
		{
			if(loans[i]!=null)
			{
				if(loans[i].getLoanId().equals(l.getLoanId()))
				{
					loans[i]=l;
				}
			}
		}
		this.write(loans);
	}
	
	
	public void deleteLoan(String loanId)
	{
		Loan loans[]=this.getAllLoan();
		for(int i=0;i<loans.length;i++)
		{
			if(loans[i]!=null)
			{
				if(loans[i].getLoanId().equals(loanId))
				{
					loans[i]=null;
				}
			}
		}
		this.write(loans);
		
	}
	
	
	public Loan searchByLoanId(String loanId)
	{
		Loan loans[]=this.getAllLoan();
		for(int i=0;i<loans.length;i++)
		{
			if(loans[i]!=null)
			{
				if(loans[i].getLoanId().equals(loanId))
				{
					return loans[i];
				}
			}
		}
		return null;
		
	}
	
	
	/*public Loan[] searchByUserId(String userId)
	{
		Loan loans[]=this.getAllLoan();
		Loan targetuser[]=new Loan[100];
		
		for(int i=0;i<loans.length;i++)
		{
			if(loans[i]!=null)
			{
				if(loans[i].getUserId().equals(userId))
				{
					targetuser[i]=loans[i];
				}
			}
		}
		return targetuser;
	}*/
	
	
	public Loan[] searchByAccountId(String accountId)
	{
	Loan loans[]=this.getAllLoan();
		Loan targetuser[]=new Loan[100];
		
		for(int i=0;i<loans.length;i++)
		{
			if(loans[i]!=null)
			{
				if(loans[i].getAccountId().equals(accountId))
				{
					targetuser[i]=loans[i];
				}
			}
		}
		return targetuser;
	}
	
	public Loan[] getAllLoan()
	{
		String fileName="controllers/data/Loans.txt";
		FileIO fio=new FileIO();
		
		String data[]=new String [100];
		data=fio.readFile(fileName);
		
		Loan loans[]=new Loan[100];
		for(int i=0;i<loans.length;i++)
		{
			if(data[i]!=null)
			{
				Loan l=new Loan();
				loans[i]=l.formLoan(data[i]);
				
			}
		}
		return loans;
	}
	
	
public void write(Loan loans[])
{
	String data[]=new String[100];
	for(int i=0;i<data.length;i++)
	{
		if(loans[i]!=null)
		{
			data[i]=loans[i].toStringLoan();
		}
	}
	String fileName="controllers/data/Loans.txt";
		FileIO fio=new FileIO();
		fio.writeFile(fileName,data);
}
	
}