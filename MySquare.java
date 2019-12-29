public class MySquare extends MyRectangle
{
	public MySquare(){}
	public MySquare(int x, int y, int side)
	{
		startX = x;
		startY = y;
		width = side;
		height = side;
	}
	public String toString()
	{
	StringBuilder A = new StringBuilder();
		A.append("Width: " + width);
		A.append(" Height: " + height);
		A.append(" X: " + startX);
		A.append(" Y: " + startY);
		return A.toString();
	}
	public void setSize(int w, int h)
	{
		if(w != h)
		{
			System.out.println("Sides must be equal. 20 != 40 so no action taken");
		}
		else
		width = w;
		height = h;
	}
	public void setSide(int side)
	{
		side = width;
		side = height;
	}
}