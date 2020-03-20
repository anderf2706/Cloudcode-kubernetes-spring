package algoritm;

import javax.swing.*;
import java.awt.*;

public class panel extends JPanel {

	@Override
	public void paintComponent(final Graphics g){
		g.setColor(Color.RED);
		for(Node node: main.allnodes){
			g.fillRect(node.x, node.y, 4, 4);
		}
		g.setColor(Color.GREEN);
		for (Node node: main.finallist
			 ) {
			g.fillRect(node.x, node.y, 4, 4);

		}
	}
}
