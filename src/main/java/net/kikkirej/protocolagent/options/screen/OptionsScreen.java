package net.kikkirej.protocolagent.options.screen;

import java.awt.GridLayout;

import javax.swing.JFrame;

import net.kikkirej.protocolagent.properties.PropertyKeys;
import net.kikkirej.protocolagent.properties.PropertyManager;

public class OptionsScreen {
	private JFrame frame;
	private PropertyManager propertyManager;

	public OptionsScreen(){
		propertyManager = PropertyManager.getInstance();
		frame = createFrame();
		fillFrame();
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, frame.getHeight());
	}

	private JFrame createFrame() {
		JFrame frame = new JFrame(propertyManager.get(PropertyKeys.FRAMETITLE));
		frame.setVisible(true);
		frame.setAlwaysOnTop(true);
		frame.setLayout(getLayout());
		return frame;
	}

	private GridLayout getLayout() {
		int rows = propertyManager.get(PropertyKeys.ALLFIELDSANDARTS).split(";").length+2;
		GridLayout gridLayout = new GridLayout(rows, 3);
		//gridLayout.
		return gridLayout;
	}
	
	private void fillFrame(){
		FormBuilder formBuilder = new FormBuilder(frame);
		formBuilder.build();
	}
	
}
