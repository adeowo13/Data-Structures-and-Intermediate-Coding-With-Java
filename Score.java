public abstract class Score implements ScoreInterface
{
	 String name;
	 int score;
	 boolean use = false;
	public String getName()
	{
		return name;
	}
	public int getScore()
	{
		if(use)
		{
			return score;
		}
		else
		{
			return 0;
		}
	}
	public void setScore(DieInterface[] dice)
	{
		score = getDiceScore(dice);
		use = true;
	}
	public boolean isUsed()
	{
		return use;
	}
	public void reset()
	{
		use = false;
		score = 0;
	}
	public String toString()
	{
		String scoreString = String.format("%3d", score);
		return name + ": " + scoreString;
	}
}