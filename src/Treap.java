import java.util.ArrayList;


public class Treap<P extends Comparable<P> & getP> {

    private TreapNode<P> root;

	
    public void add(P p) {

	if (root == null) {
	    root = new TreapNode<P>(p);
	    root.parent = null;
	}
	else root.add(p);
    }
	
    public int count() {
	if (root == null) {
	    return 0;
	}
	else return root.count();
    }

    public void setRoot(TreapNode<P> r) {
	root = r;
    }

    public TreapNode<P> getRoot() {return root;
    }

    public void printMe() {
	if (root == null) {
	    System.out.println("Empty tree");
	}
	else root.printMe();
    }
	public void printPriorities(){
		if(root == null){
			System.out.println("Empty Tree");
		}
		else{
			root.printPriorities();
		}
	}
	public P smallest(){
		if(root == null){
			return null;
		}
		else{
			return root.smallest();
		}
	}
	public int countLeaves(){
		int count = 0;
		if(root == null){
			return count;
		}
		else{
			return count + root.countLeaves();
		}
	}
	public int height(){
		int h = 0;
		if(root == null){
			return -1;
		}
		else{
			return root.height();
		}
	}
	public boolean inBalance(int limit){
		if(root == null){
			return true;
		}
		else{
			return root.inBalance(limit);
		}
	}
	public void delete(P person){
		if(root != null){
			if(person.compareTo(root.p) == 0){
				TreapNode<P> newRoot = root.delete(person);
				root = newRoot;
			}
			else{
				root.delete(person);
			}
		}
		else{
			System.out.println("Error: Root is null");
		}
	}
	public void search(P person){
		if(root == null){
			System.out.println("Person not found");
		}
		else{
			TreapNode<P> searchResult = root.search(person);
			if(searchResult != null){
				System.out.println("Found: " + searchResult.p.toString());
			}
			else{
				System.out.println("Person not found");
			}
		}
	}
	public int countG(P p){
		if(root != null){
			return root.countG(p);
		}
		else{
			return 0;
		}
	}
	public void getNodesInOrder(ArrayList<TreapNode<P>> a){
		if(this.root != null){
			root.getNodesInOrder(a);
		}
	}
	public void truncate(int limit){
		if(root != null){
			root.truncate(limit);
		}
	}
	public void rotateDelete (P target){
		if(root != null){
			if(target.compareTo(root.p) != 0){
				root.rotateDelete(target);
			}
			else{
				System.out.println("Error: Attempting to delete the blank root");
			}
		}
		else{
			System.out.println("Error: Root is null");
		}
	}
}

