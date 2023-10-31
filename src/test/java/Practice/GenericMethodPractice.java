package Practice;

public class GenericMethodPractice {

	public static void main(String[] args)//caller
	{
		
	/*1.	int a=10;
	    	int b=20;
		    int c = a+b;
	    	System.out.println(c);// compleatly hard coded data
		*/
	//2.1	add();//calling static method
		
		int  sum = add(10,20);//calling generic method
	System.out.println(sum);
	
	}
/*2	public static void add()//called
	{
		//its a simple static method
		//we have hard code 10+20 so not generic method
		int a=10;
		int b=20;
		int c = a+b;
		System.out.println(c);
	}
*/
	// Generic method
	public static int add(int a,int b)//called //
	//when ever u have to get data from caller parametarize the method
	{
		int c = a+b;
	//	System.out.println(c); we can not use print statment 
		//it is caller deecetion to use it 
		//so return it to caller
		return c;
		
	}

}
