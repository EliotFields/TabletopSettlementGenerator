package ui;

import model.TownBuilder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TextFieldListener implements DocumentListener {

	private Interface _interface;
	private TownBuilder _model;
	private JTextField _box;
	
	public TextFieldListener(JTextField t, Interface in, TownBuilder tb) {
		_interface = in;
		_model = tb;
		_box = t;
	}
	
	@Override
	public void insertUpdate(DocumentEvent e) {
		String s = _box.getText();
		int p;
		if (s != null && s.length() > 0) {
		try {
			p = Integer.parseInt(s);
			_model.popUpdate(p);
			_interface.updateDemo();
		}
		catch (IllegalArgumentException ex) {
			JOptionPane.showMessageDialog(_box, "Error: Invalid population", "Error", JOptionPane.WARNING_MESSAGE);
			_model.popUpdate(0);
			_interface.updateDemo();
		}
		}
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		String s = _box.getText();
		int p;
		if (s != null && s.length() > 0) {
		try {
			p = Integer.parseInt(s);
			_model.popUpdate(p);
			_interface.updateDemo();
		}
		catch (IllegalArgumentException ex) {
			JOptionPane.showMessageDialog(_box, "Error: Invalid population", "Error", JOptionPane.WARNING_MESSAGE);
			_model.popUpdate(0);
			_interface.updateDemo();
		}
		}
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		String s = _box.getText();
		int p;
		if (s != null && s.length() > 0) {
		try {
			p = Integer.parseInt(s);
			_model.popUpdate(p);
			_interface.updateDemo();
		}
		catch (IllegalArgumentException ex) {
			JOptionPane.showMessageDialog(_box, "Error: Invalid population", "Error", JOptionPane.WARNING_MESSAGE);
			_model.popUpdate(0);
			_interface.updateDemo();
		}
		}
	}
}
