/**
 * 
 * @author JGore & Hayden N. Walters
 *
 */
import java.util.*;
public class rooms 
{
	int roomNum;
	String desc;
	rooms[] Adj;
	
	public rooms(int roomNum)
	{
		this.roomNum = roomNum;
	}
	public void setAdj(rooms[] Adj)
	{
		this.Adj = Adj;
	}
	public void setDesc(String desc)
	{
		this.desc = desc;
	}
	public boolean isAdj(rooms r)
	{
		boolean isAdj = false;
		
		for (int i=0;i<Adj.length;i++)
		{
			if(r==Adj[i])
			{
				isAdj=true;
			}
		}
		return isAdj;
	}
	public String toString()
	{
		return roomNum + desc;
	}
}
