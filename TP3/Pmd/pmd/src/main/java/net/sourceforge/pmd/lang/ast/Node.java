/* Generated By:JJTree: Do not edit this line. Node.java */

package net.sourceforge.pmd.lang.ast;

import java.util.List;

import net.sourceforge.pmd.lang.dfa.DataFlowNode;

import org.jaxen.JaxenException;
import org.w3c.dom.Document;

/* All AST nodes must implement this interface.  It provides basic
   machinery for constructing the parent and child relationships
   between nodes. */

public interface Node {

    /**
     * This method is called after the node has been made the current
     * node.  It indicates that child nodes can now be added to it.
     */
    void jjtOpen();

    /**
     * This method is called after all the child nodes have been
     * added.
     */
    void jjtClose();

    /**
     * This pair of methods are used to inform the node of its
     * parent.
     */
    void jjtSetParent(Node parent);

    Node jjtGetParent();

    /**
     * This method tells the node to add its argument to the node's
     * list of children.
     */
    void jjtAddChild(Node child, int index);

    /**
     * This method returns a child node.  The children are numbered
     * from zero, left to right.
     *
     * @param index the child index. Must be nonnegative and less than
     *          {@link #jjtGetNumChildren}.
     */
    Node jjtGetChild(int index);

    /**
     * Return the number of children the node has.
     */
    int jjtGetNumChildren();

    int jjtGetId();

    String getImage();

    void setImage(String image);

    boolean hasImageEqualTo(String image);

    int getBeginLine();

    int getBeginColumn();

    int getEndLine();

    int getEndColumn();

    DataFlowNode getDataFlowNode();

    void setDataFlowNode(DataFlowNode dataFlowNode);

    boolean isFindBoundary();

    Node getNthParent(int n);

    <T> T getFirstParentOfType(Class<T> parentType);

    <T> List<T> getParentsOfType(Class<T> parentType);

    /**
     * Traverses the children to find all the instances of type childType.
     *
     * @see #findDescendantsOfType(Class) if traversal of the entire tree is needed.
     *
     * @param childType class which you want to find.
     * @return List of all children of type childType. Returns an empty list if none found.
     */
    <T> List<T> findChildrenOfType(Class<T> childType);

    /**
     * Traverses down the tree to find all the descendant instances of type descendantType.
     *
     * @param targetType class which you want to find.
     * @return List of all children of type targetType. Returns an empty list if none found.
     */
    <T> List<T> findDescendantsOfType(Class<T> targetType);

    /**
     * Traverses down the tree to find all the descendant instances of type descendantType.
     *
     * @param targetType class which you want to find.
     * @param results list to store the matching descendants
     * @param crossFindBoundaries if <code>false</code>, recursion stops for nodes for which {@link #isFindBoundary()} is <code>true</code>
     */
    <T> void findDescendantsOfType(Class<T> targetType, List<T> results, boolean crossFindBoundaries);

    /**
     * Traverses the children to find the first instance of type childType.
     *
     * @see #getFirstDescendantOfType(Class) if traversal of the entire tree is needed.
     *
     * @param childType class which you want to find.
     * @return Node of type childType. Returns <code>null</code> if none found.
     */
    <T> T getFirstChildOfType(Class<T> childType);

    /**
     * Traverses down the tree to find the first descendant instance of type descendantType.
     *
     * @param descendantType class which you want to find.
     * @return Node of type descendantType. Returns <code>null</code> if none found.
     */
    <T> T getFirstDescendantOfType(Class<T> descendantType);

    /**
     * Finds if this node contains a descendant of the given type.
     *
     * @param type the node type to search
     * @return <code>true</code> if there is at least one descendant of the given type
     */
    <T> boolean hasDescendantOfType(Class<T> type);

    /**
     * Returns all the nodes matching the xpath expression.
     *
     * @param xpathString the expression to check
     * @return List of all matching nodes. Returns an empty list if none found.
     * @throws JaxenException
     */
    List<? extends Node> findChildNodesWithXPath(String xpathString) throws JaxenException;

    /**
     * Checks whether at least one descendant matches the xpath expression.
     *
     * @param xpathString the expression to check
     * @return true if there is a match
     */
    boolean hasDescendantMatchingXPath(String xpathString);

    /**
     * Get a DOM Document which contains Elements and Attributes representative
     * of this Node and it's children.  Essentially a DOM tree representation of
     * the Node AST, thereby allowing tools which can operate upon DOM to
     * also indirectly operate on the AST.
     */
    Document getAsDocument();
    
    /**
     * Get the user data associated with this node.  By default there is no data,
     * unless it has been set via {@link #setUserData(Object)}.
     * @return The user data set on this node.
     */
    Object getUserData();

    /**
     * Set the user data associated with this node.
     * <p>
     * PMD itself will never set user data onto a node.  Nor should any Rule
     * implementation, as the AST nodes are shared between concurrently executing
     * Rules (i.e. it is <strong>not</strong> thread-safe).
     * <p> 
     * This API is most useful for external applications looking to leverage
     * PMD's robust support for AST structures, in which case application
     * specific annotations on the AST nodes can be quite useful.
     * 
     * @param userData The data to set on this node.
     */
    void setUserData(Object userData);
}
