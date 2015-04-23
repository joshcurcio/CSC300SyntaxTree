
public class Parser 
{
	private String theStmt;
	private int pos;
	
	public Parser(String theStmt)
	{
		this.theStmt = theStmt;
		this.pos = 0;
	}
	
	void parse()
	{
		this.parse_stmt();
	}
	
	private void parse_stmt()
	{
		theStmt = theStmt.replaceAll("\\s","");
		System.out.println(theStmt);
		//Print each time it reads something like:
		
		// Read VarName = a;
		String varName = "";
		for (int i = this.pos; i < theStmt.indexOf("="); i++)
		{
			varName = varName + theStmt.charAt(i);
			pos++;
		}
		pos++; 
		System.out.println("var Name: " + varName);
		
		// REading: math-expr
		String mathExpr = theStmt.substring(pos);
		System.out.println("Reading Math Expr: " + mathExpr);
		parse_math_expr();
		
		
		//read var name
		
		//read a math_expr

	}
	
	private void parse_math_expr()
	{
		String reading = "";
		if(theStmt.indexOf("(") == pos)
		{
			for(int i = pos; i <= theStmt.indexOf(")"); i++)
			{
				reading = reading + theStmt.charAt(i);
				pos++;
			}
			System.out.println("Reading Left: " + reading);
			parse_math(reading);
			System.out.println("Op: " + theStmt.charAt(pos));
			pos++;
			String parseRight = theStmt.substring(pos,theStmt.length()-1);
			System.out.println("Reading Right: " + parseRight);
		}
		else
		{
			System.out.println("Reading Left: " + theStmt.charAt(pos));
			pos++;
			System.out.println("Op: " + theStmt.charAt(pos));
			pos++;
			System.out.println("Reading Right: " + theStmt.substring(pos,theStmt.length()-1));
			parse_math(theStmt.substring(pos,theStmt.length()-1));
		}
	}
	
	private void parse_math(String toParse)
	{
		int currPos = 0;
		String toLeft = "";
		for(int i = 1; i < toParse.indexOf(")"); i++)
		{
			toLeft = toLeft + toParse.charAt(i);
		}
		if(toLeft.charAt(currPos) != '(')
		{
			System.out.println("Reading Left: " + toLeft.charAt(currPos));
			currPos++;
			System.out.println("Op: " + toLeft.charAt(currPos));
			currPos++;
			//System.out.println(currPos);
			
			
			if(toLeft.charAt(currPos) != '(')
			{
				System.out.println("Reading Right: " + toLeft.substring(currPos));
			}
			else
			{
				parse_math(toLeft.substring(currPos));
			}
		}
		else
		{
			parse_math(toLeft.substring(currPos));
		}
		
	}
}
