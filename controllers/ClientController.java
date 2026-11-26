package controllers;
import java.lang.*;
import models.*;

public class ClientController
{
	public void insertClient(Client c)
	{
		Client clients[]=this.getAllClient();
		for(int i=0;i<clients.length;i++)
		{
			if(clients[i]==null)
			{
				
				clients[i]=c;
				break;
				
			}
		
		}
			this.write(clients);
		
		
		
	}
	
	public void updateClient(Client c)
	{
		Client clients[]=this.getAllClient();
		
		for(int i=0;i<clients.length;i++)
		{
			if(clients[i]!=null)
			{
				if(clients[i].getUserId().equals(c.getUserId()))
				{
					clients[i]=c;
				}
				
			}
			this.write(clients);
		}
		
		
	}
	
	
	public Client searchClient(String userId)
	{
		Client clients[]=this.getAllClient();
		for(int i=0;i<clients.length;i++){
		if(clients[i]!=null)
			{
				if(clients[i].getUserId().equals(userId))
				{
					return clients[i];
				}
				
			}
		}
		return null;
		
	}
	
	public void deleteClient(String userId)
	{Client clients[]=this.getAllClient();
		
		for(int i=0;i<clients.length;i++)
		{
			if(clients[i]!=null)
			{
				if(clients[i].getUserId().equals(userId))
				{
					clients[i]=null;
				}
				
			}
		}
		this.write(clients);
	}
	
	public Client[] getAllClient()
	{
		String fileName="controllers/data/Clients.txt";
		FileIO fio=new FileIO();
		
		String data[]=new String [100];
		data=fio.readFile(fileName);
		
		Client clients[]=new Client[100];
		
		for(int i=0;i<data.length;i++)
		{
			if(data[i]!=null)
			{
				Client c=new Client();
				clients[i]=c.formClient(data[i]);
			}
		}
		return clients;
	}
	
	
	public void write(Client clients[])
	{
		String data[]=new String[100];
		
		for(int i=0;i<data.length;i++)
		{
			if(clients[i]!=null)
			{
				data[i]=clients[i].toStringUser();
			}
		}
		
		String fileName="controllers/data/Clients.txt";
		FileIO fio=new FileIO();
		fio.writeFile(fileName, data);
		
	}
}