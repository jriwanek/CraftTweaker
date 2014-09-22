/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zenscript.parser.expression;

import stanhebben.zenscript.IZenCompileEnvironment;
import stanhebben.zenscript.compiler.IScopeMethod;
import stanhebben.zenscript.expression.partial.IPartialExpression;
import stanhebben.zenscript.type.ZenType;
import zenscript.runtime.IAny;
import zenscript.util.ZenPosition;

/**
 *
 * @author Stanneke
 */
public class ParsedExpressionAssign extends ParsedExpression {
	private final ParsedExpression left;
	private final ParsedExpression right;
	
	public ParsedExpressionAssign(ZenPosition position, ParsedExpression left, ParsedExpression right) {
		super(position);
		
		this.left = left;
		this.right = right;
	}
	
	@Override
	public IPartialExpression compile(IScopeMethod environment, ZenType predictedType) {
		IPartialExpression cLeft = left.compile(environment, predictedType);
		
		return cLeft.assign(
				getPosition(),
				right.compile(environment, cLeft.getType()).eval()
		);
	}

	@Override
	public IAny eval(IZenCompileEnvironment environment) {
		return null;
	}
}
