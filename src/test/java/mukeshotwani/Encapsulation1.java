package mukeshotwani;

import org.testng.annotations.Test;

public class Encapsulation1 
{
	private String name;
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public static void main(String[] args) {
		
	Encapsulation1 en=new Encapsulation1();
	en.setName("mr titan");
	System.out.println(en.getName());
}
}