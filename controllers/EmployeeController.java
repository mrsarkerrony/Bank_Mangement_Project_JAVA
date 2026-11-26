package controllers;
import java.lang.*;
import models.*;

public class EmployeeController
{
	public void insertEmployee(Employee e)
	{
		Employee employees[]=this.getAllEmployee();
		for(int i=0;i<employees.length;i++)
		{
			if(employees[i]==null)
			{
				employees[i]=e;
				break;
				
			}
		}
		this.write(employees);
		
		
	}
	
	public void updateEmployee(Employee e)
	{
		Employee employees[]=this.getAllEmployee();
		
		for(int i=0;i<employees.length;i++)
		{
			if(employees[i]!=null)
			{
				if(employees[i].getUserId().equals(e.getUserId()))
				{
					employees[i]=e;
				}
				
			}
		}
		this.write(employees);
		
	}
	
	
	public Employee searchEmployee(String userId)
	{
		Employee employees[]=this.getAllEmployee();
		for(int i=0;i<employees.length;i++){
		if(employees[i]!=null)
			{
				if(employees[i].getUserId().equals(userId))
				{
					return employees[i];
				}
				
			}
		}
		return null;
		
	}
	
	public void deleteEmployee(String userId)
	{Employee employees[]=this.getAllEmployee();
		
		for(int i=0;i<employees.length;i++)
		{
			if(employees[i]!=null)
			{
				if(employees[i].getUserId().equals(userId))
				{
					employees[i]=null;
				}
				
			}
		}
		this.write(employees);
	}
	
	public Employee[] getAllEmployee()
	{
		String fileName="controllers/data/Employee.txt";
		FileIO fio=new FileIO();
		
		String data[]=new String [100];
		data=fio.readFile(fileName);
		
		Employee employees[]=new Employee[100];
		
		for(int i=0;i<data.length;i++)
		{
			if(data[i]!=null)
			{
				Employee e=new Employee();
				employees[i]=e.formEmployee(data[i]);
			}
		}
		return employees;
	}
	
	
	public void write(Employee employees[])
	{
		String data[]=new String[100];
		
		for(int i=0;i<data.length;i++)
		{
			if(employees[i]!=null)
			{
				data[i]=employees[i].toStringEmployee();
			}
		}
		
		String fileName="controllers/data/Employee.txt";
		FileIO fio=new FileIO();
		fio.writeFile(fileName, data);
		
	}
}