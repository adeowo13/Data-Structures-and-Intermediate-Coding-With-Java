/*
Ade Owodunni
CS0401
Project 2
*/
public class Pole
{
	private int mnd; // number of disks stacked
	private int mds; // number of disks spaces horizontal
	private int nd; // number of disks currently 
	
	private char apc;
	private Disk[] disks = new Disk[mnd];
	 
	public Pole(int aMaxNumberOfDisk, int aMaxDiskSize, char aPoleChar)
	{
 		if(aMaxNumberOfDisk < 1)
 		{
 			this.mnd = 1;
 		}else
 		 this.mnd = aMaxNumberOfDisk;
 		 
 		if(aMaxDiskSize < 1)
 		{
 			this.mds = 1;
 		}else
 		this.mds = aMaxDiskSize;
 		//disks = new Disk [mnd];
 		this.apc = aPoleChar;
 	}
 	public Pole(int aMaxNumberOfDisk, int aMaxDiskSize)
 	{
 		if(aMaxNumberOfDisk < 1)
 		{
 			this.mnd = 1;
 		}else
 		 this.mnd = aMaxNumberOfDisk;
 		 
 		if(aMaxDiskSize < 1)
 		{
 			this.mds = 1;
 		}else
 		this.mds = aMaxDiskSize;

 		this.apc = '|';
 	}
 	public Pole(int aMaxNumberOfDisk)
 	{
 		if(aMaxNumberOfDisk < 1)
 		{
 			this.mnd = 1;
 			this.mds = 1;
 		}
 		else
 		{
			 this.mnd = aMaxNumberOfDisk;
			 this.mds = aMaxNumberOfDisk;
 		}
 		this.apc = '|';
 	}
 	public int getMaxNumberOfDisks()
 	{
 		return this.mnd;
 	}
 	public int getMaxDiskSize()
 	{
 		return this.mds;
 	}
 	public int getNumberOfDisks()
 	{
 		int counter = 0;
 		for(int i = 0; i < disks.length; i++)
 		{
 			if(disks[i] != null)
 			{
 				counter++;
 			}
 		}
 		this.nd = counter;
 		return this.nd;
 	}
 	public Disk peekTopDisk()
 	{
 		disks = new Disk [mnd];
 		if(this.nd == 0)
 		{
 			return null;
 		}
 		else 
 		{
 			return disks[nd];
 		}
 	}
 	public boolean addDisk(Disk aDisk)
 	{
 		if(this.nd == this.mnd)
 		{
 			return false;
 		}
 		else 
 		{
 			for(int z = 0; z > disks.length; z++)
 			{
 				if(disks[z] == null)
 				{
 					disks[z] = new Disk[aDisk];
 					z = disks.length;
 				}
 			}
 			return true;
 		}
 	}
 	public Disk removeDisk()
 	{
 		if(this.nd == 0)
 		{
 			return null;
 		}
 		else 
 		{
 			return disks[nd];
 		}
 	}
 	public String toString()
 	{
		StringBuilder P = new StringBuilder();
		for(int i = 0; i < this.mnd + 1; i++)
		{
			for(int o = 0; o < this.mds; o++)
			{
				P.append(" ");
			}
			P.append(this.apc);
		
			for(int a = 0; a < this.mds; a++)
			{
				P.append(" ");
			}
			P.append("\n");
			
		}
		
		for(int i = nd; i < 0; i++)
		{
			P.append(disks[i-1].toString());
			P.append("\n");
		}
		return P.toString();
	}
	
	public static void main(String[] args)
	{
		Pole aPole = new Pole(5);
		aPole.addDisk(new Disk(4));
		aPole.addDisk(new Disk(2));
		aPole.addDisk(new Disk(1));
		System.out.println(aPole);
	}
}
