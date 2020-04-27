package milu.entity;

public class TeamSoccer extends TeamAbs {
	private int level = -1;

	public int getLevel()
	{
		return this.level;
	}
	
	public void setLevel( int level )
	{
		this.level = level;
	}
	
	
	@Override
	public TeamSoccer clone() throws CloneNotSupportedException
	{
		TeamAbs clone = super.clone();
		return (TeamSoccer)clone;
	}
}
