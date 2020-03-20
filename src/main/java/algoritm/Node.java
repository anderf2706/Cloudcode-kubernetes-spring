package algoritm;

import java.io.Serializable;
import java.util.*;

public class Node implements Serializable {
	ArrayList<Node> adjecent = new ArrayList<Node>();

	public int x;
	public int y;
	int id;
	static int count = 1;
	Node parent;
	public boolean occupied = false;
	double f;
	double g;
	double h;
	double cost;

	public Node(int x, int y, main main) {
		this.x = x;
		this.y = y;

		this.id = count++;


	}

	public void makeClosest(int id, ArrayList<Node> list){
			if (main.nodedict.containsKey(id + 1)) {
				list.add(main.nodedict.get(id + 1));
			}
			if (main.nodedict.containsKey(id - 1)) {
				list.add(main.nodedict.get(id - 1));
			}
			if (main.nodedict.containsKey(id + main.nodewidth)) {
				list.add(main.nodedict.get(id + main.nodewidth));
			}
			if (main.nodedict.containsKey(id - main.nodewidth)) {
				list.add(main.nodedict.get(id - main.nodewidth));
			}
			if (main.nodedict.containsKey(id + (main.nodewidth + 1))) {
				list.add(main.nodedict.get(id + (main.nodewidth + 1)));
			}
			if (main.nodedict.containsKey(id + (main.nodewidth - 1))) {
				list.add(main.nodedict.get(id + (main.nodewidth - 1)));
			}
			if (main.nodedict.containsKey(id - (main.nodewidth + 1))) {
				list.add(main.nodedict.get(id - (main.nodewidth + 1)));
			}
			if (main.nodedict.containsKey(id - (main.nodewidth - 1))) {
				list.add(main.nodedict.get(id - (main.nodewidth - 1)));
			}
		}

}
