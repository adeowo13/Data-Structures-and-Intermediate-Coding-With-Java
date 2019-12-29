import java.util.*;
public class Die implements DieInterface
{
	public Random r = new Random();
	public int fValue;
	public void Die()
	{
		int random = r.nextInt(6);
		fValue = random + 1;
	}
	public void setFaceValue(int v)
	{
		fValue = v;
	}
	public int getFaceValue()
	{
		return fValue;
	}
	public int roll()
	{
		int random = r.nextInt(6);
		fValue = random + 1;
		return fValue;
	}
	public String toString()
	{
		StringBuilder b = new StringBuilder();
		b.append("Die: " + fValue);
		return b.toString();
	}
}