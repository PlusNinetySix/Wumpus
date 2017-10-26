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
				rooms[] adjs= {a[adj1-1], a[adj2-1], a[adj3-1]};
				a[i].setAdj(adjs);
				a[i].setDesc(description);

				//System.out.println(a[i]);
			}
				fin.close();
				
				
		System.out.println("Welcome to Hunt the Wumpus!");
		System.out.println("You are in room 1.");
		System.out.println("You have 3 arrows left.");
		
		int arrow = 3;
		int currentRoom = 1;
		int wumpusRoom=(int)(2+15*Math.random());
		int pitRoom1=(int)(2+15*Math.random());
		int pitRoom2=(int)(2+15*Math.random());
		int spiderRoom1=(int)(2+15*Math.random());
		int spiderRoom2=(int)(2+15*Math.random());
		
		System.out.println(wumpusRoom + " Wumpus");
		System.out.println(pitRoom1 + " Pit Room #1");
		System.out.println(pitRoom2 + " Pit Room #2");
		System.out.println(spiderRoom1 +  " Spider Room #1");
		System.out.println(spiderRoom2 + " Spider Room #2");
		
		
		Scanner cin=new Scanner(System.in);
		System.out.println("What will you do?");
		String command;
		
		while(true)
		{
			command = cin.nextLine();
			
			if(command.equalsIgnoreCase("S"))
			{
				System.out.println("Which room?");
				command = cin.nextLine();
				
				if(a[currentRoom-1].isAdj(a[Integer.valueOf(command)-1]))
				{
					Integer.valueOf(command);
					arrow=arrow-1;
					System.out.println("You now have " + arrow + " arrow(s) left");
					System.out.println("What will you do?");
				}
				else
				{
					System.out.println("You can't shoot there! Try again.");
					System.out.println("What will you do?");
				}
			}
			if(command.equalsIgnoreCase("M"))
			{
				System.out.println("To which room?");
				command = cin.nextLine();
				
				if(a[currentRoom-1].isAdj(a[Integer.valueOf(command)-1]))
				{
					Integer.valueOf(command);
					currentRoom=Integer.valueOf(command);
					System.out.println("You are in room " + currentRoom);
					System.out.println(a[currentRoom-1]);
					System.out.println("What will you do?");
				}
				else
				{
					System.out.println("You can't go that way! Try again.");
					System.out.println("You are in room " + currentRoom);
					System.out.println("What will you do?");
				}
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