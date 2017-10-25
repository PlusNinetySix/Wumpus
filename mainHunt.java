/**
 * 
 * @author JGore & Hayden N. Walters
 *
 */
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class mainHunt 
{

	public static void main(String[] args) throws IOException
	{
		Scanner fin=new Scanner(new FileReader("rooms.txt"));
		int n=Integer.valueOf(fin.nextLine());
			rooms [] a=new rooms[n];
			
			for(int i=0;i<n;i++)
			{
				a[i] = new rooms(i+1);
			}
			for(int i=0;i<n;i++)
			{
				String[] b=fin.nextLine().split(" ");
				String description=fin.nextLine();
				int adj1=Integer.valueOf(b[1]);
				int adj2=Integer.valueOf(b[2]);
				int adj3=Integer.valueOf(b[3]);
				rooms[] adjs= { a[adj1-1], a[adj2-1], a[adj3-1]};
				a[i].setAdj(adjs);
				a[i].setDesc(description);
			}
				
			
			
				fin.close();
				
		System.out.println("Welcome to Hunt the Wumpus!");
		System.out.println("You are in room 1.");
		System.out.println("You have 3 arrows left.");
		
		int arrow = 3;
		
		Scanner cin=new Scanner(System.in);
		System.out.println("What will you do?");
		String command;
		
		while(true)
		{
			command = cin.nextLine();
			
			if(command.equalsIgnoreCase("Shoot"))
			{
				System.out.println("Which room?");
				arrow=arrow-1;
				System.out.println("You now have " + arrow + " arrow(s) left");
				
				if(arrow==0)
				{
					System.out.println("You have no more arrows left. Game over!");
					break;
				}
			}
			if(command.equalsIgnoreCase("Move"))
			{
				System.out.println("To which room?");
				
			}
			if(command.equalsIgnoreCase("Quit"))
			{
				System.out.println("Goodbye!");
				break;
			}
		}
		cin.close();
	}

}
