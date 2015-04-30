
public class MathExpression extends Expression
{
	private Expression leftOperand;
	private Expression rightOperand;
	private OpExpression theOp;
	
	public MathExpression(Expression leftOperand, Expression rightOperand, OpExpression theOp)
	{
		this.leftOperand = leftOperand;
		this.rightOperand = rightOperand;
		this.theOp = theOp;
	}

}
