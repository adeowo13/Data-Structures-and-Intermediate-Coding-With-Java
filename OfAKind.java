
public class OfAKind extends Score {
	int requiredNum;

	public OfAKind(String aName, int numSumFaces) {
		name = aName;
		requiredNum = numSumFaces;
		used = false;
	}

	public int getDiceScore(DieInterface[] dice) {
		if (this.isUsed()) {
			return this.score;
		} else {
			score = 0;
			int count = 0;
			int ones = 0;
			int twos = 0;
			int threes = 0;
			int fours = 0;
			int fives = 0;
			int sixes = 0;
			for (DieInterface die : dice) {
				switch (die.getFaceValue()) {
				case 1:
					ones++;
					break;
				case 2:
					twos++;
					break;
				case 3:
					threes++;
					break;
				case 4:
					fours++;
					break;
				case 5:
					fives++;
					break;
				case 6:
					sixes++;
					break;

				}
			}
			if (ones >= requiredNum) {
				for (DieInterface die : dice) {
					score += die.getFaceValue();
				}
				if (requiredNum == 5) {
					score = 50;
				}
				return score;

			} else if (twos >= requiredNum) {
				for (DieInterface die : dice) {
					score += die.getFaceValue();
				}
				if (requiredNum == 5) {
					score = 50;
				}
				return score;
			} else if (threes >= requiredNum) {
				for (DieInterface die : dice) {
					score += die.getFaceValue();
				}
				if (requiredNum == 5) {
					score = 50;
				}
				return score;
			} else if (fours >= requiredNum) {
				for (DieInterface die : dice) {
					score += die.getFaceValue();
				}
				if (requiredNum == 5) {
					score = 50;
				}
				return score;
			} else if (fives >= requiredNum) {
				for (DieInterface die : dice) {
					score += die.getFaceValue();
				}
				if (requiredNum == 5) {
					score = 50;
				}
				return score;
			} else if (sixes >= requiredNum) {
				for (DieInterface die : dice) {
					score += die.getFaceValue();
				}
				if (requiredNum == 5) {
					score = 50;
				}
				return score;
			} else {
				return 0;
			}

		}
	}

}
