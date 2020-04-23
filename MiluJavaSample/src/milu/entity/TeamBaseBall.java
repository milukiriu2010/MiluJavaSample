package milu.entity;

public class TeamBaseBall extends TeamAbs {
	public enum LEAGUE
	{
		CENTRAL,
		PACIFIC,
		UNKOWN
	}
	
	private LEAGUE league = LEAGUE.UNKOWN;
	
	/*
	public TeamBaseBall()
	{
	}
	*/
	
	public LEAGUE getLeague()
	{
		return this.league;
	}

	public void setLeague( LEAGUE league )
	{
		this.league = league;
	}
	
	@Override
	public TeamBaseBall clone() throws CloneNotSupportedException
	{
		TeamBaseBall clone = (TeamBaseBall) super.clone();
		return (TeamBaseBall)clone;
	}	

}
