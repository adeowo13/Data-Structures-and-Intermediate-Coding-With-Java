public class FullHouse extends Score
{
	public FullHouse(String aName)
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
			int tOAK = 0;
			int pair = 0;
			int c1 = 0;
			int c2 = 0;
			first: for(int i = 0; i < dice.length; i++)
			{
				second: for(int a = 0; a < dice.length; a++)
				{
					int counter1 = 0;
					if(dice[i].getFaceValue() == dice[a].getFaceValue())
					{
						counter1++;
						if(counter1 == 3)
						{
							tOAK = dice[i].getFaceValue();
							c1 = counter1;
							break first;
						}	
					}
				}//second
			}//first
			third: for(int b = 0; b < dice.length; b++)
			{
				int counter2 = 0;
				fourth: for(int c = 0; c < dice.length; c++)
				{
					if(dice[b].getFaceValue() == dice[c].getFaceValue())
					{
						counter2++;
						if(counter2 == 2)
						{
							pair = dice[b].getFaceValue();
							c2 = counter2;
							break third;
						}	
					}
				}//fourth
			}//third
			if((c1 == 3 && c2 == 2) && (pair != tOAK))
			{
				score = 25;
				return score;
			}
			else
			return 0;	
		}//else
	}
}