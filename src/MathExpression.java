
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

	public String toString()
	{
		if(leftOperand instanceof MathExpression && rightOperand instanceof MathExpression)
		{
			return "(" + leftOperand.toString() + ")" + theOp.toString() + "(" + rightOperand.toString() + ")";
		}
		if(leftOperand instanceof MathExpression)
		{
			return "(" + leftOperand.toString() + ")" + theOp.toString() + rightOperand.toString();
		}
		if(rightOperand instanceof MathExpression)
		{
			return leftOperand.toString() + theOp.toString() + "(" + rightOperand.toString() + ")";
		}
		return leftOperand.toString() + theOp.toString()+ rightOperand.toString();
	}
}
