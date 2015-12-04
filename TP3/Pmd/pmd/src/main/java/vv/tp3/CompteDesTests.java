package vv.tp3;

import java.util.Iterator;
import java.util.List;
import net.sourceforge.pmd.lang.java.ast.ASTAnnotation;
import net.sourceforge.pmd.lang.java.ast.ASTName;
import net.sourceforge.pmd.lang.java.rule.AbstractJavaRule;

public class CompteDesTests extends AbstractJavaRule {

	int c = 0;
	
	
	
	public Object visit(ASTAnnotation node, Object data) {
		
		List<ASTName> n = node.findDescendantsOfType(ASTName.class);
		Iterator<ASTName> i = n.iterator();
		
		while (i.hasNext()) {
			ASTName nom = (ASTName) i.next();
			if(nom.getImage().equals("test")) {
				//addViolation(data, node); 
				c++;
			}
		}
		
		
		return super.visit(node, data);
	}
}