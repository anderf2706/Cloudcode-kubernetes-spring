package algoritm;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class main extends JPanel {


	public static Map<Integer, Node> nodedict = new HashMap<Integer, Node>();
	public static ArrayList<Node> allnodes = new ArrayList<Node>();
	public static int nodewidth;
	public static ArrayList<Node> finallist  = new ArrayList<Node>();


	public void makenodes(int nodewidth){
		main.nodewidth = nodewidth;
		for (int i = 0; i < nodewidth; i += 1) {
			for (int j = 0; j < nodewidth; j += 1) {
				Node node = new Node(i * (1000/120), j * (1000/120), this);
				allnodes.add(node);
				nodedict.put(node.id, node);



			}
		}
		for (Node node: allnodes) {
			node.makeClosest(node.id, node.adjecent);
		}



	}

	public void pathfinder(int startX, int startY, int endX, int endY){
		Node start = nodedict.get(100*startX + (100 - startY));
		Node end = nodedict.get(100*endX + (100 - endY));
		A_star astar = new A_star();
		finallist = astar.pathfinder(start, end);

	}

	public void render(){
		JFrame jp = new JFrame();
		final panel panel = new panel();
		jp.setContentPane(panel);
		jp.pack();
		jp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jp.setSize(1920, 1080);
		jp.setResizable(false);
		jp.setLocation(0, 0);
		jp.setLocationRelativeTo(null);

		jp.setVisible(true);
		jp.repaint();

	}

	public void makeobst(){

	}

	public static void main(String[] args) {
		main main = new main();
		main.makenodes(100);
		System.out.println(allnodes);
		System.out.println(allnodes.size());
		main.pathfinder(3,20,90,56);
		main.render();


	}

}
