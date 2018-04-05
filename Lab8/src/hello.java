
public class hello {
	import java.util.Scanner;

	public class SocSecProcessor {



		/**

		 * @param args

		 */

		public static boolean isValid(String socNo) throws SocSecException

		{

			int dashpos=0;

			boolean flag=true;

			if(socNo.length() != 11)

			{

				flag=false;

				System.out.println("Social Security Number must be of 11 charcters");

				throw new SocSecException();

			}

			else if( !(socNo.charAt(3) == '-' && socNo.charAt(6)=='-'))

			{

				System.out.println("Invalid Social Security Number cause due to bad dash places it should look like xxx-xx-xxxx");

				throw new SocSecException();

			}

			else

			{

				for(int i=0; i < socNo.length();i++)

				{

					if(socNo.charAt(i)>'A' && socNo.charAt(i) < 'z')

					{

						flag=false;

						System.out.println("Invalid Social Security Number can't contain any alphabates");

						throw new SocSecException();

					}

				}

			}

			return flag;

		}

		public static void main(String[] args) {

			// TODO Auto-generated method stub

			String choice="";

			do

			{

				Scanner sc=new Scanner(System.in);

				try

				{

					System.out.println("Please Enter Name :");

					String name =sc.next();

					System.out.println("Enter Social Security Number");

					String socNo=sc.next();

					boolean b=isValid(socNo);

					if(b)

					{

						System.out.println("Name is : "+name);

						System.out.println("Social Security Number :"+socNo+" is valid");

					}

					else

					{

						throw new SocSecException();

					}

				}

				catch(SocSecException e)

				{

					e.getMessage();

				}

				System.out.println("Want to continue : press y to yes and any other key to no");

				choice = sc.next();

				if(choice.length() > 1)

				{

					choice = choice.substring(0,1);

				}

			}while(choice.equalsIgnoreCase("y"));

		}



	}


}
