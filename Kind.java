public class Kind extends Score
{
	int numF;
	public Kind(String aName, int numSameFaces)
	{
		name = aName;
		numF = numSameFaces;
		use = false;
	}
	public int getDiceScore(DieInterface [] dice)
	{
		if(this.isUsed())
		{
			return this.score;
		}
		else
		{
			int one = 0;
			int two = 0;
			int three = 0;
			int four = 0;
			int five = 0;
			int six = 0;
			score = 0;
			for(int i = 0; i < dice.length; i++)
			{
				switch(dice[i].getFaceValue())
				{
					case 1:
						one++;
						break;
					case 2:
						two++;
						break;
					case 3:
						three++;
						break;
					case 4:
						four++;
						break;
					case 5:
						five++;
						break;
					case 6:
						six++;
						break;
				}//switch
			}//for(counter)
			if(one >= numF)
			{
				for(int a = 0; a < dice.length; a++)
				{
					score = score + dice[a].getFaceValue();
				}
				if(numF == 5)
				{
					score = 50;
				}
			return score;
			}//one
			else if(two >= numF)
			{
				for(int b = 0; b < dice.length; b++)
				{
					score = score + dice[b].getFaceValue();
				}
				if(numF == 5)
				{
					score = 50;
				}
			return score;
			}//two
			else if(three >= numF)
			{
				for(int c = 0; c < dice.length; c++)
				{
					score = score + dice[c].getFaceValue();
				}
				if(numF == 5)
				{
					score = 50;
				}
			return score;
			}//three
			else if(four >= numF)
			{
				for(int d = 0; d < dice.length; d++)
				{
					score = score + dice[d].getFaceValue();
				}
				if(numF == 5)
				{
					score = 50;
				}
			return score;
			}//four
			else if(five >= numF)
			{
				for(int e = 0; e < dice.length; e++)
				{
					score = score + dice[e].getFaceValue();
				}
				if(numF == 5)
				{
					score = 50;
				}
			return score;
			}//five
			else if(six >= numF)
			{
				for(int f = 0; f < dice.length; f++)
				{
					score = score + dice[f].getFaceValue();
				}
				if(numF == 5)
				{
					score = 50;
				}
			return score;
			}//six
			else
				return 0;
		}//big if-else
	}//method
}//class