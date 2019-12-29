public class Chance extends Score
{
	public Chance(String aName)
	{
		name = aName;
		use = false;
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
			for(int i = 0; i < dice.length; i++)
			{
				score = score + dice[i].getFaceValue();
			}
			return score;
		}//else
	}
}