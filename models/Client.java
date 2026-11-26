package models;
import java.lang.*;
public class Client extends User
{
	private String membershipType;
	
	public Client()
	{
		super();
	}
	public Client (String userId, String name, String gender, int age, String email, String phoneNo, String address, int role, String securityAns, String password,String membershipType)
	{
		super(userId,role,securityAns,password);
		this.name=name;
		this.age=age;
		this.gender=gender;
		this.email=email;
		this.phoneNo=phoneNo;
		this.address=address;
		this.membershipType=membershipType;
	}
	public void setMembershipType(String membershipType){
		this.membershipType=membershipType;
	}
	public String getMembershipType(){
		return this.membershipType;
	}
	
	public String toStringClient()
	{
		String str=this.userId+","+this.name+","+this.gender+","+this.age+","+this.email+","+this.phoneNo+","+this.address+","+this.membershipType+"\n";
		return str;
	}
	public Client formClient(String str){
		String data[]=str.split(",");
		
		Client cl=new Client();
		cl.setUserId(data[0]);
		cl.setName(data[1]);
		
		cl.setGender(data[2]);
		cl.setAge(Integer.parseInt(data[3]));
		cl.setEmail(data[4]);
		cl.setPhoneNo(data[5]);
		cl.setAddress(data[6]);
		cl.setMembershipType(data[7]);
		
		return cl;
		
	}
}
	
	