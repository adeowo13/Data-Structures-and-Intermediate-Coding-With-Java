import java.util.Arrays;
public class Straight extends Score
{
	public int consecutives;
	public Straight(String aName, int numconsecutivesFaces)
	{
		name = aName;
		use = false;
		consecutives = numconsecutivesFaces;
	}
	public int getDiceScore(DieInterface[] dice) 
	{
		if (this.isUsed()) 
		{
			return this.score;
		} 
		else 
		{
			score = 0;
			int []faces = new int[dice.length];
			for(int i = 0; i < dice.length; i++)
			{
				faces[i] = dice[i].getFaceValue();
			}
			Arrays.sort(faces);
			int counter = 0;
			for (int a = 0; a < dice.length - 1; a++) 
			{
  				if (dice[a].getFaceValue() + 1 == dice[a + 1].getFaceValue())
  				{
  					counter++;
  				}
  			}
  			if(counter >= consecutives - 1 && consecutives == 4)
  			{
  				score = 30;
  				return score;
  			}
  			else if(counter >= consecutives - 1 && consecutives == 5)
  			{
  				score = 70;
  				return score;
  			}
  			else
  				return score;
		}//else
	}//method
}//class