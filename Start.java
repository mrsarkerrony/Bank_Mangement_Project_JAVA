import java.lang.*;
import views.*;
import controllers.*;


public class Start
{
	public static void main(String[] args)
	{
		
		
		LoginFrame lf=new LoginFrame();
		lf.setVisible(true);
		
		FileIO fio=new FileIO();
		String fileName="controllers/data/Users.txt";
		/*String data[]=new String[2];
		data[0]="A-22,1,rabby,1234\n";
		data[1]="A-33,2,asif,12345\n";
		fio.writeFile(fileName,data);*/
		
		String data1[]=fio.readFile(fileName);
		
		for(int i=0;i<data1.length;i++)
		{
			if(data1[i]!=null)
			{
				System.out.println(data1[i]);
			}
			
		}
		
		
		
		/*FileIO fio=new FileIO();
		String fileName="controllers/data/Employees.txt";
		String data[]=new String[1];
		data[0]="A-33,Asif,male,35,asif@gmail.com,012345678,dhaka,2,asif,1234,employee,23000\n";
		
		fio.writeFile(fileName,data);
		
		String data1[]=fio.readFile(fileName);
		
		for(int i=0;i<data1.length;i++)
		{
			if(data1[i]!=null)
			{
				System.out.println(data[i]);
			}
			
		}*/
		
		
		
	
}

}