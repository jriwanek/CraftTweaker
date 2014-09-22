/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stanhebben.zenscript.symbols;

import stanhebben.zenscript.compiler.IScopeMethod;
import stanhebben.zenscript.expression.partial.IPartialExpression;
import stanhebben.zenscript.expression.partial.PartialStaticGetter;
import zenscript.symbolic.method.IMethod;
import zenscript.util.ZenPosition;

/**
 *
 * @author Stanneke
 */
public class SymbolJavaStaticGetter implements IZenSymbol {
	private final IMethod method;
	
	public SymbolJavaStaticGetter(IMethod method) {
		this.method = method;
	}

	@Override
	public IPartialExpression instance(ZenPosition position, IScopeMethod environment) {
		return new PartialStaticGetter(position, environment, method);
	}
}
