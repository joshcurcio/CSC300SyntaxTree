
public class Driver 
{
	public static void main(String[] args)
	{
		Parser p = new Parser("     a =      (a * (a+b ))  -  c;");
		p.parse();
		
		VarDefStatement vds = p.getSyntaxTree();
		System.out.println(vds);
	}
}
