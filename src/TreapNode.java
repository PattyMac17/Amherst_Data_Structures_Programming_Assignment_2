import java.util.ArrayList;
import java.util.Random;

public class TreapNode<P extends Comparable<P> & getP> {
	static Random rn = new Random(004);

	P p;
	TreapNode<P> right, left, parent;
	int priority;
	//Citing Sources: I used our online textbook listed on our moodle
	// page section 7.2 as a reference while completing this assignment

	public TreapNode(P p){
		this.p = p;
	}


	public TreapNode<P> add(P newP) {
		int compare = p.compareTo(newP);
		if (compare == 0)
			return this;
		if (compare < 0) {
			if (right == null) {
				right = new TreapNode<P>(newP);
				right.priority = rn.nextInt(10000) + 1;
				right.parent = this;
				if(this.right.priority < this.priority){
					bubbleUp(this.right);
				}
				return right;
			}
			else {
				return right.add(newP);
			}
		}
		else {
			if (left == null) {
				left = new TreapNode<P>(newP);
				left.priority = rn.nextInt(10000) + 1;
				left.parent = this;
				if(this.left.priority < this.priority){
					bubbleUp(this.left);
				}
				return left;
			}
			else {
				return left.add(newP);
			}
		}
	}


	public void leftRotate(TreapNode<P> Child){
		TreapNode<P> Parent = Child.parent;
		Child.parent = Parent.parent;
		if(Parent.p.compareTo(Parent.parent.p) < 0){
			Parent.parent.left = Child;
		}
		else{
			Parent.parent.right = Child;
		}
		if(Child.left != null){
			TreapNode<P> B = Child.left;
			Child.left = Parent;
			Parent.parent = Child;
			Parent.right = B;
			B.parent = Parent;
		}
		else{
			Child.left = Parent;
			Parent.parent = Child;
			Parent.right = null;
		}
	}
	public void rightRotate(TreapNode<P> Child){
		TreapNode<P> Parent = Child.parent;
		Child.parent = Parent.parent;
		if(Parent.p.compareTo(Parent.parent.p) < 0){
			Parent.parent.left = Child;
		}
		else{
			Parent.parent.right = Child;
		}
		if(Child.right != null){
			TreapNode<P> B = Child.right;
			Child.right = Parent;
			Parent.parent = Child;
			Parent.left = B;
			B.parent = Parent;
		}
		else{
			Child.right = Parent;
			Parent.parent = Child;
			Parent.left = null;
		}
	}
	public void bubbleUp(TreapNode<P> node){
		while(node.parent != null && node.priority < node.parent.priority){
			if(node.parent.left == node){
				rightRotate(node);
			}
			else{
				leftRotate(node);
			}
		}
	}
	public void setPriority(int p){
		this.priority = p;
	}


	public int count() {
		int ret = 1;

		if (right != null)
			ret = ret + right.count();
		if (left != null)
			ret = ret + left.count();

		return ret;
	}

	public void printMe() {

		System.out.println(p);
		if (left != null)
			left.printMe();
		if (right != null)
			right.printMe();
	}
	public void printPriorities(){
		System.out.println(this.toString());
		if (left != null)
			left.printPriorities();
		if (right != null)
			right.printPriorities();
	}
	public P smallest(){
		if(this.left == null){
			return this.p;
		}
		else{
			return this.left.smallest();
		}
	}
	public int countLeaves(){
		int count = 0;
		if(this.left == null && this.right == null){
			count++;
		}
		else{
			if(this.left != null){
				count += this.left.countLeaves();
			}
			if(this.right != null){
				count += this.right.countLeaves();
			}
		}
		return count;
	}
	public int height(){
		if(this.left == null && this.right == null){
			return 0;
		}
		else{
			int l = 0;
			int r = 0;
			if(this.left != null){
				l = 1 + this.left.height();
			}
			if(this.right != null){
				r = 1 + this.right.height();
			}
			if(l >= r){
				return l;
			}
			else{
				return r;
			}
		}
	}
	public boolean inBalance(int limit){
		if(this.left == null && this.right == null){
			return true;
		}
		else{
			int l = 0;
			int r = 0;
			if(this.left != null){
				l = left.height();
			}
			if(this.right != null){
				r = right.height();
			}
			if(Math.abs(l - r) > limit){
				return false;
			}
			else{
				return true;
			}
		}
	}
	public TreapNode<P> delete(P person){
		TreapNode<P> target = this.search(person);
		if(target != null){
			return remove(target);
		}
		else{
			System.out.println("Target not found");
			return null;
		}
	}
	public void rotateDelete(P person){
		TreapNode<P> target = this.search(person);
		if(target != null){
			target.setPriority(100000);
			bubbleDown(target);
			System.out.println("removing node:" + target.toString());
			if(target.parent.left == target){
				target.parent.left = null;
			}
			else{
				target.parent.right = null;
			}
			target.parent = null;
		}
		else{
			System.out.println("Target not found");
		}
	}
	public void bubbleDown(TreapNode<P> node){
		while(node.left != null || node.right != null){
			if(node.left == null){
				leftRotate(node.right);
			}
			else{
				if(node.right == null){
					rightRotate(node.left);
				}
				else{
					if(node.right.priority > node.left.priority){
						rightRotate(node.left);
					}
					else{
						leftRotate(node.right);
					}
				}
			}
		}
	}
	public TreapNode<P> search(P person){
		if(person.compareTo(this.p) == 0){
			return this;
		}
		else{
			if(person.compareTo(this.p) > 0){
				if(this.right != null){
					return this.right.search(person);
				}
				else{
					return null;
				}
			}
			else{
				if(this.left != null){
					return this.left.search(person);
				}
				else{
					return null;
				}
			}
		}
	}
	public TreapNode<P> remove(TreapNode<P> target){
		if(target.left == null && target.right == null){
			if(target.parent != null){
				if(target.p.compareTo(target.parent.p) < 0){
					target.parent.left = null;
				}
				else{
					target.parent.right = null;
				}
			}
			else{
				target = null;
			}
			return null;
		}
		if(target.left == null && target.right != null){
			TreapNode<P> toReturn = target.right;

			//System.out.println("right child deletion: " + target.p.toString());
			if(target.parent != null){
				TreapNode<P> PARENT = target.parent;
				if(target.p.compareTo(target.parent.p) < 0){
					PARENT.left = toReturn;
					toReturn.parent = PARENT;
					//target.parent.left = target.right;
				}
				else{
					//target.parent.right = target.right;
					PARENT.right = toReturn;
					toReturn.parent = PARENT;
				}
			}
			else{
				toReturn.parent = null;
			}
			return toReturn;
		}
		if(target.left != null && target.right == null){
			TreapNode<P> toReturn = target.left;
			//System.out.println("left child deletion: " + target.p.toString());
			if(target.parent != null){
				TreapNode<P> PARENT = target.parent;
				if(target.p.compareTo(target.parent.p) < 0){
					PARENT.left = toReturn;
					toReturn.parent = PARENT;
				}
				else{
					PARENT.right = toReturn;
					toReturn.parent = PARENT;
				}
			}
			else{
				toReturn.parent = null;
			}
			return toReturn;
		}
		if(target.left != null && target.right != null){
			TreapNode toReturn = target;
			//System.out.println("two child deletion: " + target.p.toString());
			P replacement = target.right.smallest();
			TreapNode<P> toRemove = search(replacement);
			target.p = replacement;
			remove(toRemove);
			return toReturn;
		}
		return null;
	}
	public int countG(P p){
		if(this.p.compareTo(p) > 0){
			if(this.left == null && this.right == null){
				return 1;
			}
			else{
				int toReturn = 1;
				if(this.left != null){
					toReturn += this.left.countG(p);
				}
				if(this.right != null){
					toReturn += this.right.countG(p);
				}
				return toReturn;
			}
		}
		else{
			if(this.right != null){
				return this.right.countG(p);
			}
			else{
				return 0;
			}
		}
	}
	public void getNodesInOrder(ArrayList<TreapNode<P>> a){
		if(this.left != null){
			this.left.getNodesInOrder(a);
		}
		a.add(this);
		if(this.right != null){
			this.right.getNodesInOrder(a);
		}
	}
	public void truncate(int limit){
		int thisPVal = this.p.getP();
		limit -= thisPVal;
		if(this.left != null){
			if(this.left.p.getP() <= limit){
				this.left.truncate(limit);
			}
			else{
				System.out.println("Left delete: " + this.left.p.toString());
				this.left = null;
			}
		}
		if(this.right != null){
			if(this.right.p.getP() <= limit){
				this.right.truncate(limit);
			}
			else{
				System.out.println("Right delete: " + this.right.p.toString());
				this.right = null;
			}
		}
	}
	public String toString(){
		return "Key: " + this.p.toString() + " | Priority: " + this.priority;
	}
}

