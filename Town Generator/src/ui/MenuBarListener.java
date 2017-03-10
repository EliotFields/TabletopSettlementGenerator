package ui;

import model.TownBuilder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class MenuBarListener implements ActionListener {

	private Interface _interface;
	private TownBuilder _model;
	
	public MenuBarListener(Interface in, TownBuilder tb) {
		_interface = in;
		_model = tb;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		if (s.equals("export")) {
			JFileChooser fc = new JFileChooser();
			fc.setSelectedFile(new File(_model.name() + ".csv"));
			fc.setFileFilter(new FileNameExtensionFilter(".csv", "csv"));
			int confirm;
			confirm = fc.showSaveDialog(null);
			if (confirm == JFileChooser.APPROVE_OPTION) {
				try {
					FileWriter fw = new FileWriter(fc.getSelectedFile());
					fw.write(_interface.export());
					JOptionPane.showMessageDialog(null, "File export successful!");
					fw.close();
				}
				catch (IOException ex) {
					JOptionPane.showMessageDialog(null, "Error: invalid file", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		else if (s.equals("exit")) {
			System.exit(0);
		}
		else if (s.equals("nameAny")) {
			_model.nameSet(TownBuilder.NAME_ANY);
		}
		else if (s.equals("nameAmerican")) {
			_model.nameSet(TownBuilder.NAME_AMERICAN);
		}
		else if (s.equals("nameGerman")) {
			_model.nameSet(TownBuilder.NAME_GERMAN);
		}
		else if (s.equals("nameEnglish")) {
			_model.nameSet(TownBuilder.NAME_ENGLISH);
		}
		else if (s.equals("demoShort")) {
			_model.demoSet(TownBuilder.DEMO_SHORT);
		}
		else if (s.equals("demoLong")) {
			_model.demoSet(TownBuilder.DEMO_LONG);
		}
	}

}
