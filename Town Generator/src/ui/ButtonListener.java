package ui;

import model.TownBuilder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {

	private Interface _interface;
	private TownBuilder _model;
	
	public ButtonListener(Interface in, TownBuilder tb) {
		_interface = in;
		_model = tb;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("randAll")) {
			_model.randAll();
			_interface.update();
		}
		else if (e.getActionCommand().equals("randName")) {
			_model.randName();
			_interface.update();
		}
		else if (e.getActionCommand().equals("randPop")) {
			_model.randPop();
			_model.randDemo();
			_interface.update();
		}
		else if (e.getActionCommand().equals("randFlavor")) {
			_model.randFlavor();
			_interface.update();
		}
		else if (e.getActionCommand().equals("randDemo")) {
			_model.randDemo();
			_interface.update();
		}
	}

}
