package grpc.smartsafety;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GUIApplication implements ActionListener {
	
	private JTextField entry1, reply1;
	private JTextField entry2, reply2;
	
	private JPanel getSmartLockJPanel() {

		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

		JLabel label = new JLabel("Enter value")	;
		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entry1 = new JTextField("",10);
		panel.add(entry1);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button = new JButton("Invoke Smart Lock");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		reply1 = new JTextField("", 10);
		reply1 .setEditable(false);
		panel.add(reply1 );

		panel.setLayout(boxlayout);

		return panel;

	}

	private JPanel getSmartLightJPanel() {

		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

		JLabel label = new JLabel("Enter value")	;
		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entry2 = new JTextField("",10);
		panel.add(entry2);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button = new JButton("Invoke Smart Light");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		reply2 = new JTextField("", 10);
		reply2 .setEditable(false);
		panel.add(reply2 );

		panel.setLayout(boxlayout);

		return panel;

	}
	
	public static void main(String[] args) {

		GUIApplication gui = new GUIApplication();

		gui.build();
	}
	
	private void build() { 

		JFrame frame = new JFrame("Service Controller Sample");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Set the panel to add buttons
		JPanel panel = new JPanel();

		// Set the BoxLayout to be X_AXIS: from left to right
		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);

		panel.setLayout(boxlayout);

		// Set border for the panel
		panel.setBorder(new EmptyBorder(new Insets(50, 100, 50, 100)));
	
		panel.add( getSmartLockJPanel() );
		panel.add( getSmartLightJPanel() );
	
		// Set size for the frame
		frame.setSize(300, 300);

		// Set the window to be visible as the default to be false
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource();
		String label = button.getActionCommand();  

		if (label.equals("Invoke Smart Lock")) {
			System.out.println("Smart Lock to be invoked ...");
			
			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50061).usePlaintext().build();
			smartSafetyGrpc.smartSafetyBlockingStub blockingStub = smartSafetyGrpc.newBlockingStub(channel);
			
			lockRequest req = lockRequest.newBuilder().setLock(entry1.getText()).build();
			lockResponse response = blockingStub.smartLock(req);
			
			reply1.setText( String.valueOf( response.getUnlock()) );
		}
			
		else if (label.equals("Invoke Smart Light")) {
				System.out.println("Smart Light to be invoked ...");
				ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50061).usePlaintext().build();
				smartSafetyGrpc.smartSafetyBlockingStub blockingStub = smartSafetyGrpc.newBlockingStub(channel);
				
				lightRequest req = lightRequest.newBuilder().setLightOn(entry2.getText()).build();
				lightResponse response = blockingStub.smartLight(req);
				
				reply2.setText( String.valueOf( response.getLightOff()) );
			}
		else{
			
		}
				
	}
		
}
	

	
