package models;
import java.lang.*;

public class Admin extends User
{
	private String adminType;
	
	public Admin()
	{
		super();
	}
	public Admin(String userId, String name, String gender, int age, String email, String phoneNo, String address, int role, String securityAns, String password, String adminType)
	{
		super(userId,role,securityAns,password);

		this.name=name;
		this.age=age;
		this.gender=gender;
		this.email=email;
		this.phoneNo=phoneNo;
		this.address=address;
		this.adminType=adminType;
	}
	public void setAdminType(String adminType)
	{
		this.adminType=adminType;
	}
	public String getAdminType(){
		return adminType;
	}
	
	public String toStringAdmin()
	{
		String str=this.userId+","+this.name+","+this.gender+","+this.age+","+this.email+","+this.phoneNo+","+this.address+","+this.adminType+"\n";
		return str;
		
		
	}
	public Admin formAdmin(String str)
	{
		
		String data[]= str.split(",");
		
		Admin ad=new Admin();
		ad.setUserId(data[0]);
		ad.setName(data[1]);
		ad.setGender(data[2]);
		ad.setAge(Integer.parseInt(data[3]));
		ad.setEmail(data[4]);
		ad.setPhoneNo(data[5]);
		ad.setAddress(data[6]);
		ad.setAdminType(data[7]);
		
		return ad;

		
	}
	
}