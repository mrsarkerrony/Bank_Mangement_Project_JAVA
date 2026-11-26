package models;
import java.lang.*;
public class Employee extends User
{
	private String designation;
	private double salary;
	
	public Employee ()
	{
		super();
	}
	public Employee(String userId, String name, String gender, int age, String email, String phoneNo, String address, int role, String securityAns, String password, String designation,double salary)
	{
		super(userId,role,securityAns,password);
		this.name=name;
		this.age=age;
		this.gender=gender;
		this.email=email;
		this.phoneNo=phoneNo;
		this.address=address;
		this.designation=designation;
		this.salary=salary;
	}
	
	public void setDesignation(String designation)
	{
		this.designation=designation;
	}
	public void setSalary(double salary)
	{
		this.salary=salary;
	}
	
	public String getDesignation(){
		return this.designation;
	}
	public double getSalary(){
		return this.salary;
	}
	
	public String toStringEmployee()
	{
		String str=this.userId+","+this.name+","+this.gender+","+this.age+","+this.email+","+this.phoneNo+","+this.address+","+this.designation+","+this.salary+"\n";
		
		return str;
	}
	
	public Employee formEmployee(String str)
	{
		String data[]=str.split(",");
		
		Employee em =new Employee();
		em.setUserId(data[0]);
		em.setName(data[1]);
		em.setGender(data[2]);
		em.setAge(Integer.parseInt(data[3]));
		em.setEmail(data[4]);
		em.setPhoneNo(data[5]);
		em.setAddress(data[6]);
		em.setDesignation(data[7]);
		em.setSalary(Double.parseDouble(data[8]));
		
		return em;
		
		
	}
}