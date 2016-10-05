import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
public class Tree<E> {

private static class Node<E> {
E data;
Node<E> parent;
List<Node> children = new ArrayList<Node>();

public Node(E data) {this.data = data;}

public void addChild(Node<E> child){
child.parent = this;
this.children.add(child);
}
}

private Node<E> root;

public Tree() {}

public Tree(Node<E> root) {this.root = root;}

public static Tree createSampleTree() {
/* Will create this sample tree.
  a
/ | \
/ | \
b c d
/| |\ |
/ / \ \ j
e f g h i 
*/
Node a = new Node("a"); 
Node b = new Node("b");
Node c = new Node("c"); 
Node d = new Node("d");
a.addChild(b); 
a.addChild(c);
a.addChild(d);
Node e = new Node("e"); 
Node f = new Node("f");
Node g = new Node("g"); 
Node h = new Node("h");
Node i = new Node("i");
b.addChild(e); b.addChild(f);
b.addChild(g); b.addChild(h);
b.addChild(i);

Node j = new Node("j");
d.addChild(j);
return new Tree(a);
}

private void displayHelper(Node<E> n, int indent) {
System.out.printf("%"+indent+"s\n", n.data.toString());
for (Node<E> c : n.children) displayHelper(c, indent + 3); 
}
public void display() {
displayHelper(root, 3);
}
//HW: Write a recursive method to return the height of tree.
// The height of a tree is the longest path from the root
// to a leaf node. Hint: the height of a node is 
// 1 + max height of the children.

public int getHeight(){
return getHeight(root); 
}

private int getHeight(Node<E> n){
if (n == null) return 0;
int longest = 0;
for(Node<E> c:n.children){
int h = getHeight(c);
if (longest < h) longest = h;
}
return 1 + longest;
}

//HW: Write a recursive method that returns the level of the 
// first node that containts item. 
// -a private recursive method that returns a node for a given item.
// -a private recurisve method that returns the level of a given node.
public int getLevel(E item){
Node<E> n = findNode(root, item);
if (n == null) return 0;
return getLevel(n);
} 

private Node<E> findNode(Node<E> n, E item){
if (n.data.equals(item)) return n;
Node<E> node = null;
for(Node<E> c:n.children){
node = findNode(c, item);
if (node != null) break;
}
return node;
}

private int getLevel(Node<E> n){
if (n == null) return 0;
return 1 + getLevel(n.parent);
}

//HW: write method that returns an iterator that would allow
// access to data in the tree in a depth first search
// hints: do a depth first search, collect the nodes in a list.
// return the iterator of the list as the tree's iterator.
public Iterator<E> iterator(){
ArrayList<E> list = new ArrayList<E>();
depthFirst(root, list);
return list.iterator();
}

private void depthFirst(Node<E> n, ArrayList<E> list){
if ( n == null) return;
list.add(n.data);
for(Node<E> c:n.children){
depthFirst(c, list);
}
}

public static void main(String[] args) {
Tre e tree = Tree.createSampleTree();
tree.display();
System.out.println(tree.getHeight());
System.out.println(tree.getLevel("a"));
System.out.println(tree.getLevel("c"));
System.out.println(tree.getLevel("j"));
Iterator i = tree.iterator();
while(i.hasNext()){
System.out.println(i.next());
}
}
}