package vv.tp3;

import net.sourceforge.pmd.lang.java.ast.ASTBooleanLiteral;
import net.sourceforge.pmd.lang.java.ast.ASTBreakStatement;
import net.sourceforge.pmd.lang.java.ast.ASTExpression;
import net.sourceforge.pmd.lang.java.ast.ASTReturnStatement;
import net.sourceforge.pmd.lang.java.ast.ASTWhileStatement;
import net.sourceforge.pmd.lang.java.rule.AbstractJavaRule;

public class WhileEchap extends AbstractJavaRule {
	
    public Object visit(ASTWhileStatement node, Object data) {
		
    	ASTExpression e= node.getFirstChildOfType(ASTExpression.class);
    	if (e.hasDescendantOfType(ASTBooleanLiteral.class)) {
    		if (e.jjtGetChild(0).jjtGetNumChildren()==1) {
    			if(!node.hasDecendantOfAnyType(ASTBreakStatement.class,ASTReturnStatement.class)) addViolation(data, node);
    		
    		}
    	}
    	
    	return super.visit(node, data);
    }

}
