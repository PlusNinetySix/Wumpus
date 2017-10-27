/**
 * 
 * @author JGore & Hayden N. Walters
 *
 */
public class rooms 
{
	int roomNum;
	boolean wumpus=false;
	boolean spider=false;
	boolean pit=false;
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
	public boolean hasWumpus()
	{
		return wumpus;
	}
	public boolean hasSpider()
	{
		return spider;
	}
	public boolean hasPit()
	{
		return pit;
	}
	public void setWumpus()
	{
		wumpus=true;
	}
	public void setSpider()
	{
		spider=true;
	}
	public void setPit()
	{
		pit=true;
	}
	public String toString()
	{
		return desc + "\nRooms you can move to:" + " " + Adj[0].roomNum+ " " + Adj[1].roomNum + " " + Adj[2].roomNum;
	}
}
