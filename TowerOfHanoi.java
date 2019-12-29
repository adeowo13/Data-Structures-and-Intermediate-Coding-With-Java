/*
Ade Owodunni
CS0401
Project 2
*/
public class TowerOfHanoi
{
	private Pole[] p = new Pole [3];
	private StringBuilder toh = new StringBuilder();
	
	TowerOfHanoi()
	{
		Pole1 = new Pole(7,7,'|');
		Pole2 = new Pole(7,7,'|');
		Pole3 = new Pole(7,7,'|');
		
		p[0] = Pole1;
		p[1] = Pole2;
		p[2] = Pole3;
		
		for(int i = 0; i < 7; i++)
		{
			Disk nDisk = new Disk(7-i);
			p[0].addDisk(nDisk);
		}
	}
	TowerOfHanoi(int aNumberOfDisks)
	{
		Pole1 = new Pole(aNumberOfDisks,aNumberOfDisks,'|');
		Pole2 = new Pole(aNumberOfDisks,aNumberOfDisks,'|');
		Pole3 = new Pole(aNumberOfDisks,aNumberOfDisks,'|');
		
		p[0] = Pole1;
		p[1] = Pole2;
		p[2] = Pole3;
		
		for(int i = 0; i < aNumberOfDisks; i++)
		{
			Disk nDisk = new Disk(aNumberOfDisks-i);
			p[0].addDisk(nDisk);
		}
	}
	public Disk peekTopDisk(int aPoleNumber)
	{
		if(aPoleNumber == 1)
		{
			return p[0].peekTopDisk();
		}
		else if(aPoleNumber == 2)
		{
			return p[1].peekTopDisk();
		}
		else if(aPoleNumber == 3)
		{
			return p[2].peekTopDisk();
		}
		else
		{
			return null;
		}
	}
	public int getNumberOfDisks(int aPoleNumber)
	{
		if(aPoleNumber == 1)
		{
			return p[0].getNumberOfDisks();
		}
		else if(aPoleNumber == 2)
		{
			return p[1].getNumberOfDisks();
		}
		else if(aPoleNumber == 3)
		{
			return p[2].getNumberOfDisks();
		}
		else
		{
			return -1;
		}
	}
	public String toString()
	{
		String pole1 = p[0].toString();
		String pole2 = p[1].toString();
		String pole3 = p[2].toString();
		
		String[] fPole1 = pole1.toString();
		String[] fPole2 = pole2.toString();
		String[] fPole3 = pole3.toString();
		
		for(int a = 0; a < p[0].getMaxDiskSize()+1; a++)
		{
			toh.append(" ");
		}
		toh.append("1");
		for(int b = 0; b < p[0].getMaxDiskSize()+1; b++)
		{
			toh.append(" ");
		}
		for(int c = 0; c < p[1].getMaxDiskSize()+1; c++)
		{
			toh.append(" ");
		}
		toh.append("2");
		for(int d = 0; d < p[1].getMaxDiskSize()+1; d++)
		{
			toh.append(" ");
		}
		for(int e = 0; e < p[2].getMaxDiskSize()+1; e++)
		{
			toh.append(" ");
		}
		toh.append("3/n");
		
		
		for(f = 0; f < p[0].getMaxNumberOfDisks()+1; f++)
		{
			toh.append(fPole1[f]+fPole2[f]+fPole3[f]+ "/n");
		}
		for(g = 0; g < ((p[0].getMaxDiskSize())*6)+3; g++)
		{
			toh.append("=");
		}
		return toh.toString();
		
	}
	public boolean move(int fromPole, int toPole)
	{
		Disk mDisk = p[fromPole-1].peekTopDisk();
		p[toPole-1].addDisk(mDisk);
		p[fromPole-1].removeDisk();
		
		if(poles[fromPole -1].peekTopDisk() != mDisk && p[toPole-1].peekTopDisk() == mDIsk)
		{
			return true;
		}
		else
			return false;
	}
	public void reset()
	{
		for(int a = 0; a < p[1].getNumberOfDisks(); a++)
		{
			poles[1].removeDisk();
		}
		for(int b = 0; b < p[2].getNumberOfDisks(); b++)
		{
			poles[2].removeDisk();
		}
		for(int c = 0; c < p[2].getNumberOfDisks(); c++)
		{
			poles[0].removeDisk();
		}
		for(int d = 0; d < p[0].getNumberOfDisks(); d++)
		{
			Disk nDisk = new Disk(poles[0].getMaxDiskSize() - k;
			p[0].addDisk(nDisk);
		}
	}
}