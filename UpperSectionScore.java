public class UpperSectionScore extends Score
{
	public int num;
	public UpperSectionScore(String aName, int aNumber)
	{
		name = aName;
		num = aNumber;
		use = false;
	}//method
	public int getDiceScore(DieInterface[] dice)
	{
		if(this.isUsed())
		{
			return this.score;
		}
		else
		{
			score = 0;
			int quantity = 0;
			for(int i = 0; i < dice.length; i++)
			{
				if(dice[i].getFaceValue() == num)
				{
					quantity++;
				}
			}
			score = num * quantity;
			return score;
		}//else
	}//method
}//class