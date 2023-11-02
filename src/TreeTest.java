public class TreeTest {

    public static void main(String[] args) {

	new TreeTest().process();
    }

    public void process() {
		Treap<Person> sampleTree = new Treap<Person>();
		sampleTree.add(new Person("", ""));
		sampleTree.getRoot().setPriority(0);
		//System.out.println("Root Test: " + sampleTree.getRoot().toString());

		//sampleTree.printMe();

		/*sampleTree.add(new Person("J","Test"));

		sampleTree.add(new Person("D","Test"));
		sampleTree.add(new Person("B","Test"));
		sampleTree.add(new Person("C","Test"));

		sampleTree.add(new Person("G","Test"));
		sampleTree.add(new Person("A","Test"));
		sampleTree.add(new Person("H", "Test"));
		sampleTree.add(new Person("F", "Test"));
		sampleTree.add(new Person("K", "Test"));

        sampleTree.printPriorities();/*

		sampleTree.add(new Person("E","Test"));
		sampleTree.add(new Person("F","Test"));

		sampleTree.add(new Person("I","Test"));

		/*sampleTree.add(new Person("J","Test"));
		sampleTree.add(new Person("K","Test"));
		sampleTree.add(new Person("L","Test"));
		sampleTree.add(new Person("M","Test"));*/

		/*sampleTree.add(new Person("H","Test"));
		sampleTree.add(new Person("D","Test"));
		sampleTree.add(new Person("B","Test"));
		sampleTree.add(new Person("I","Test"));
		sampleTree.add(new Person("K","Test"));
		sampleTree.add(new Person("A","Test"));*/

		/*sampleTree.add(new Person("D", "1"));
		sampleTree.add(new Person("B", "1"));
		sampleTree.add(new Person("C", "1"));
		sampleTree.add(new Person("A", "1"));
		sampleTree.add(new Person("E", "1"));
		sampleTree.add(new Person("F", "1"));

		/*sampleTree.add(new Person("K", "1"));
		sampleTree.add(new Person("F", "1"));
		sampleTree.add(new Person("B", "1"));
		sampleTree.add(new Person("A", "1"));
		sampleTree.add(new Person("C", "1"));
		sampleTree.add(new Person("H", "1"));
		sampleTree.add(new Person("G", "1"));
		sampleTree.add(new Person("J", "1"));
		sampleTree.add(new Person("L", "1"));
		sampleTree.add(new Person("N", "1"));
		sampleTree.add(new Person("M", "1"));
		sampleTree.add(new Person("O", "1"));*/





		/*System.out.println(sampleTree.count());
		sampleTree.printMe();

		System.out.println("\nBegin testing:\n");
		String s1 = "ABC", s2 = "DEF", s3 = "DFE";
		System.out.println("ABC.compareTo(DEF) = " + s1.compareTo(s2));
		System.out.println("DEF.compareTo(ABC) = " + s2.compareTo(s1));
		System.out.println("ABC.compareTo(ABC) = " + s1.compareTo(s1));
		System.out.println("DFE.compareTo(DEF) = " + s3.compareTo(s2));
		System.out.println();

		System.out.println("Smallest: " + sampleTree.smallest());
		System.out.println("Number of Leaf Nodes: " + sampleTree.countLeaves());
		System.out.println("Height: " + sampleTree.height());

		//so far so good


		System.out.println("Balanced: " + sampleTree.inBalance(1));
		System.out.println("Sum Max: " + sampleTree.maxPVals());
		System.out.println("Sum Min: " + sampleTree.minPVals());
		System.out.println("Truncate Test: ");
		//sampleTree.truncate(5);


		//System.out.println("MaxPVal: " + sampleTree.maxPVals());
		sampleTree.method(5);

		System.out.println();
		System.out.println("Full Tree: ");
		sampleTree.printMe();
		//System.out.println("Delete F: ");
		//sampleTree.search(new Person("F", "1"));
		//System.out.println("Removing F: ");
		//sampleTree.delete(new Person("F", "1"));

		//sampleTree.printMe();
		//System.out.println("Removing B: ");
		//sampleTree.delete(new Person("B", "1"));

		//sampleTree.printMe();
		//sampleTree.search(new Person("A", "1"));
		//sampleTree.delete(new Person("A", "1"));

		//sampleTree.printMe();
		/*sampleTree.delete(new Person("C", "1"));

		//sampleTree.printMe();
		//sampleTree.delete((new Person("F", "1")));

		sampleTree.printMe();
		sampleTree.delete((new Person("E", "1")));

		sampleTree.printMe();
		sampleTree.delete((new Person("B", "1")));

		sampleTree.printMe();*/

		/*TreapNode<Person> root = sampleTree.getRoot();
		if(root.parent != null){
			System.out.println("has a parent");
		}
		else{
			System.out.println("parent is null");
		}*/
		/*System.out.println("Removing D: ");
		sampleTree.delete((new Person("D","1")));
		sampleTree.printMe();
		System.out.println("New Root:");
		System.out.println(sampleTree.getRoot().p.toString());
		System.out.println("Removing E: ");
		sampleTree.delete((new Person("E","1")));
		sampleTree.printMe();
		System.out.println("New Root:");
		System.out.println(sampleTree.getRoot().p.toString());
		System.out.println("Removing F: ");
		sampleTree.delete((new Person("F","1")));
		sampleTree.printMe();
		System.out.println("New Root:");
		System.out.println(sampleTree.getRoot().p.toString());
		System.out.println("Removing B: ");
		sampleTree.delete((new Person("B","1")));
		sampleTree.printMe();
		System.out.println("New Root:");
		System.out.println(sampleTree.getRoot().p.toString());
		System.out.println("Removing C: ");
		sampleTree.delete(new Person("C", "1"));
		sampleTree.printMe();
		System.out.println("New Root:");
		System.out.println(sampleTree.getRoot().p.toString());
		System.out.println("Removing A: ");
		sampleTree.delete(new Person("A", "1"));
		sampleTree.printMe();
		//System.out.println("New Root:");
		//System.out.println(sampleTree.getRoot().p.toString());*/
		/*System.out.println("CountG: " + sampleTree.countG(new Person("O", "1")));
		ArrayList<TreapNode<Person>> a = new ArrayList<TreapNode<Person>>();
		sampleTree.getNodesInOrder(a);
		System.out.println("Array elements:");
		for(TreapNode<Person> p : a){
			System.out.println(p.p);
		}
		System.out.println(a.size());
		sampleTree.add(new Person("D", "1"));
		sampleTree.add(new Person("B", "1"));
		sampleTree.add(new Person("C", "1"));
		sampleTree.add(new Person("A", "1"));
		sampleTree.add(new Person("E", "1"));
		sampleTree.add(new Person("F", "1"));
		sampleTree.add(new Person("Z", "1"));
		sampleTree.add(new Person("X", "1"));
		sampleTree.add(new Person("Y", "1"));
		sampleTree.printMe();
		sampleTree.truncate(4);
		System.out.println("Post Truncate:");
		sampleTree.printMe();

		*/sampleTree.add(new Person("A", "1"));
		sampleTree.add(new Person("B", "1"));
		sampleTree.add(new Person("C", "1"));
		sampleTree.add(new Person("D", "1"));
		sampleTree.add(new Person("E", "1"));
		sampleTree.printPriorities();
		sampleTree.rotateDelete(new Person("", ""));
		sampleTree.printPriorities();
    }
}
