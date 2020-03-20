package algoritm;

import java.util.*;
import java.util.concurrent.TimeUnit;


public class A_star{
	
	int round;

	
	public A_star() {
	}
	
	public ArrayList<Node> pathfinder(final Node Start, Node End) {//A*-algoritmen. Setter start og end node med findnode metoden.

		final Node end = End;
		ArrayList<Node> closedList = new ArrayList<Node>(); //generer listene som skal brukes. 
		ArrayList<Node> openList = new ArrayList<Node>();
		Node start = Start;
		start.g = 0;//setter g til start lik null s? den kan regnes ut i Node klassen. 
		openList.add(start);//adder start til nodelisten 
		Node current_Node;
		current_Node = Start;
		int i= 0;
        Timer t = new Timer();

        while(!closedList.contains(end)) {//kj?rer loopen til vi har funnet m?l
			i = i + 1;
			if(openList.size() > 1) {
				Collections.sort(openList, new Comparator<Node>() {
					@Override
					public int compare(Node n1, Node n2) {
						return Double.compare(n1.f, n2.f);
					}
				});
			}


			closedList.add(0, openList.get(0));//flytter den beste noden over til closedlist, og av openlist
			openList.remove(0);
			
			current_Node = closedList.get(0);
			for (Node node : current_Node.adjecent) {//g?r igjennom alle nodene vedsidenav denne som er lovelige
				
				
				if(openList.contains(node)) {//hvis noden er p? openlist allerede betyr det at den har regnet ut f allerede. her sjekker vi om den nye 
						if(current_Node.g + 1 < node.g) {//ruten er bedre en den forrige og kalkulerer f p? nytt og bytter parent
							node.parent = current_Node;
							if(node.x != node.parent.x && node.y != node.parent.y) {
								node.cost = Math.sqrt(2);
							}
							else {
								node.cost = 1;
							}
							node.g = node.parent.g + node.cost;
							node.h = Math.max(Math.abs(node.x - end.x), Math.abs(node.y - end.y));
							node.f = node.h + node.g;
							Collections.sort(openList, new Comparator<Node>() {
								@Override
								public int compare(Node n1, Node n2) {
								   return Double.compare(n1.f, n2.f);
								 }
							});
						}

				}
				
				if(closedList.contains(node) ) {//hvis noden er p? closedlist skal vi ignorere den ? hoppe videre med continue
					continue;
					
				}


				else {
					if (!openList.contains(node) && !node.occupied) {//hvis noden ikke er p? opnelist skal vi legge den inn, gi den parentnode som current og regne ut f.
						openList.add(node);
						node.parent = current_Node;
						if (node.x != node.parent.x && node.y != node.parent.y) {
							node.cost = Math.sqrt(2);
						} else {
							node.cost = 1;
						}
						node.g = node.parent.g + node.cost;
						node.h = Math.max(Math.abs(node.x - end.x), Math.abs(node.y - end.y));
						node.f = node.h + node.g;

					}

				}
			
						
							
			}		
					
				
		}	
				
		
		ArrayList<Node> finalPath = new ArrayList<Node>();//lager listen vi legger de fungerende nodene i for ? f? final path.
        finalPath.add(end);//legger til endnode
        while(!finalPath.contains(start)) {//kj?rer loopen til vi har startnode i listen. Da har vi funnet veien
            finalPath.add(0, finalPath.get(0).parent); //legger her til parent til den f?rste noden for ? jobbe seg bakover.
        }
        //setter tilslutt listen lik variabelen for classen.

        return finalPath;
		
			
			
			
	
	}

	
	


}
