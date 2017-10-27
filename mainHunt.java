/**
 * 
 * @author JGore & Hayden N. Walters
 *
 */
import java.io.*;
import java.util.*;
import java.util.ArrayList;

public class mainHunt 
{
	static rooms[] blah;
	
	public static void main(String[] args) throws IOException
	{
		Scanner fin=new Scanner(new FileReader("rooms.txt"));
		int n=Integer.valueOf(fin.nextLine());
			//rooms [] a=new rooms[n];
			
			for(int i=0;i<n;i++)
			{
				blah[i] = new rooms(i+1);
			}
			for(int i=0;i<n;i++)
			{	
				String[] b=fin.nextLine().split(" ");
				String description=fin.nextLine();				
				int adj1=Integer.valueOf(b[1]);
				int adj2=Integer.valueOf(b[2]);
				int adj3=Integer.valueOf(b[3]);
				rooms[] adjs= {blah[adj1-1], blah[adj2-1], blah[adj3-1]};
				blah[i].setAdj(adjs);
				blah[i].setDesc(description);

				//System.out.println(a[i]);
			}
			
			List<rooms> L = new ArrayList<rooms>();
			for(int i=0;i<n;i++)
			{
				L.add(blah[i]);
			}
			int roll = (int)(L.size()*Math.random());
			L.remove(roll).setWumpus();
			int rollS1 = (int)(L.size()*Math.random());
			L.remove(rollS1).setSpider();
			int rollS2 = (int)(L.size()*Math.random());
			L.remove(roll).setSpider();
			int rollP1 = (int)(L.size()*Math.random());
			L.remove(rollP1).setPit();
			int rollP2 = (int)(L.size()*Math.random());
			L.remove(rollP2).setPit();
			
				fin.close();
					
		System.out.println("Welcome to Hunt the Wumpus!");
		System.out.println("You are in room 1.");
		System.out.println("You have 3 arrows left.");
		
		int arrow = 3;
		int currentRoom = 1;
		
		System.out.println(roll + " Wumpus");
		//System.out.println();
		
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
				
				if(blah[currentRoom-1].isAdj(blah[Integer.valueOf(command)-1]))
				{
					int guess = Integer.valueOf(command);
					arrow=arrow-1;
					System.out.println("You now have " + arrow + " arrow(s) left");
					System.out.println("What will you do?");
					if(arrow<=0)
					{
						System.out.println("You have no arrows left. Game over!");
						break;
					}
				}
				else
				{
					System.out.println("You can't shoot there! Try again.");
					System.out.println("What will you do?");
				}
				if(blah[currentRoom-1].hasWumpus())
				{
					System.out.println("Game over!");
					break;
				}
				
			}
			if(command.equalsIgnoreCase("M"))
			{
				System.out.println("To which room?");
				command = cin.nextLine();
				
				if(blah[currentRoom-1].isAdj(blah[Integer.valueOf(command)-1]))
				{
					Integer.valueOf(command);
					currentRoom=Integer.valueOf(command);
					System.out.println("You are in room " + currentRoom);
					System.out.println(blah[currentRoom-1]);
					System.out.println("What will you do?");
				}
				else
				{
					System.out.println("You can't go that way! Try again.");
					System.out.println("You are in room " + currentRoom);
					System.out.println("What will you do?");
				}
				if(currentRoom==roll)
				{
					
				}
				if(currentRoom==roll)
				{
					System.out.println("Wumpus has killed you. Game over!");
					break;
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