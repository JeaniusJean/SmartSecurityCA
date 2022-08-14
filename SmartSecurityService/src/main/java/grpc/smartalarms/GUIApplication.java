package grpc.smartalarms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;

public class GUIApplication implements ActionListener {
	
	private JTextField entry1, reply1;
	private JTextField entry2, reply2;
	private int clicks = 0;
	JLabel label = new JLabel("\"Number of clicks:  0     \"")	;
	
	private JPanel getSmokeAlarmJPanel() {
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
	
	private JPanel getAlarmSystemJPanel() {
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
	
		panel.add( getSmokeAlarmJPanel() );
		panel.add( getAlarmSystemJPanel() );
	
		// Set size for the frame
		frame.setSize(300, 300);

		// Set the window to be visible as the default to be false
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		 clicks++;
		 label.setText("Number of clicks:  " + clicks);
	

		if (label.equals("Invoke Smoke Alarm")) {
			System.out.println("Invoke Smoke Alarm to be invoked ...");
			
			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50062).usePlaintext().build();
			smartAlarmsGrpc.smartAlarmsStub asyncStub = smartAlarmsGrpc.newStub(channel);
			
			smokeRequest req = smokeRequest.newBuilder().setSmoke(entry1.getText()).build();
			
			//smokeResponse response = asyncStub.smokeAlarm(req, null);
			
			//reply1.setText( String.valueOf( response.getLatitude()) );
		}
			
		
}
}

