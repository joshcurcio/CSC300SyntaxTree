
public class VarExpression extends Expression
{
	private String varName;
	
	public VarExpression(String varName)
	{
		this.varName = varName;
	}
	
	public String toString()
	{
		return varName;
	}

}
