package ui;

import model.*;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class Interface implements Runnable {
	
	private JFrame _top;
	private JMenuBar _menu;
	private JMenu _file, _settings;
	private JMenuItem _export, _exit;
	private JMenu _nameSettings, _demoSettings;
	private JRadioButtonMenuItem _nameAny, _nameAmerican, _nameGerman, _nameEnglish, _demoShort, _demoLong;
	private ButtonGroup _bgName, _bgDemo;
	
	private JPanel _namePanel;
	private JPanel _sizePanel;
	private JPanel _flavorPanel;
	private JPanel _demoPanel;
	private JPanel _buttonPanel;
	
	private JTextField _name;
	private JTextField _pop;
	private JTextField _popCat;
	private JTextArea _flavor;
	private JTextArea _demo;
	
	private JButton _randAll;
	private JButton _randName;
	private JButton _randPop;
	private JButton _randFlavor;
	private JButton _randDemo;
	
	private TownBuilder _model;
	
	@Override
	public void run() {
		_model = new TownBuilder();
		_top = new JFrame("Settlement Generator");
		_top.setLayout(new GridBagLayout());
		
		buildMenuBar();		
		buildNamePanel();
		buildSizePanel();
		buildFlavorPanel();
		buildDemoPanel();
		buildButtons();
		
		_top.setJMenuBar(_menu);
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		_top.add(_namePanel, c);
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 1;
		_top.add(_sizePanel, c);
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 2;
		_top.add(_flavorPanel, c);
		c = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 0;
		c.gridheight = 3;
		_top.add(_demoPanel, c);
		c = new GridBagConstraints();
		c.gridx = 2;
		c.gridy = 0;
		c.gridheight = GridBagConstraints.REMAINDER;
		c.anchor = GridBagConstraints.NORTH;
		c.insets = new Insets(22,3,3,3);
		_top.add(_buttonPanel, c);
		
		_model.demoSet(TownBuilder.DEMO_LONG);
		_model.randAll();
		update();
		
		_top.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_top.pack();
		_top.setMinimumSize(new Dimension(_top.getWidth(), _top.getHeight()));
		_top.setVisible(true);
	}
	
	public void update() {
		_name.setText(_model.name());
		_pop.setText("" + _model.population());
		_popCat.setText(_model.popCategory(_model.population()));
		_flavor.setText(_model.flavor());
		_demo.setText(_model.demographics());
	}
	
	public void updateDemo() {
		_popCat.setText(_model.popCategory(_model.population()));
		_demo.setText(_model.demographics());
	}
		
	public String export() {
		String ret = "NAME\n";
		ret += _name.getText() + "\n\n";
		ret += "POPULATION\n";
		ret += _pop.getText() + "\n";
		ret += _popCat.getText() + "\n\n";
		ret += "CHARACTERISTICS\n";
		ret += _flavor.getText() + "\n\n";
		ret += "SHOPS AND BUSINESSES\n";
		ret += _demo.getText();
		
		return ret;
	}
	
	private void buildNamePanel() {
		_namePanel = new JPanel(new GridLayout(2,0));
		JLabel l = new JLabel("Name");
		l.setHorizontalAlignment(JLabel.CENTER);
		_namePanel.add(l);
		_name = new JTextField();
		_namePanel.add(_name);
		_namePanel.setPreferredSize(new Dimension(325,45));
	}
	
	private void buildSizePanel() {
		_sizePanel = new JPanel(new GridLayout(3,0));
		JLabel l = new JLabel("Population");
		l.setHorizontalAlignment(JLabel.CENTER);
		_sizePanel.add(l);
		_pop = new JTextField();
		_pop.getDocument().addDocumentListener(new TextFieldListener(_pop, this, _model));
		_sizePanel.add(_pop);
		_popCat = new JTextField();
		_popCat.setEditable(false);
		_sizePanel.add(_popCat);
		_sizePanel.setPreferredSize(new Dimension(325,70));
	}

	private void buildFlavorPanel() {
		_flavorPanel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(3,3,3,3);
		_flavorPanel.add(new JLabel("Characteristics"), c);
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 1;
		c.gridheight = GridBagConstraints.REMAINDER;
		c.insets = new Insets(0,3,3,3);
		_flavor = new JTextArea();
		_flavor.setLineWrap(true);
		_flavor.setEditable(false);
		_flavor.setPreferredSize(new Dimension(325,435));
		_flavorPanel.add(_flavor, c);
	}

	private void buildDemoPanel() {
		_demoPanel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(3,3,3,3);
		_demoPanel.add(new JLabel("Shops and Businesses"), c);
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 1;
		c.insets = new Insets(0,3,3,3);
		_demo = new JTextArea();
		_demo.setEditable(false);
		_demo.setPreferredSize(new Dimension(200,550));
		_demoPanel.add(_demo, c);
	}
	
	private void buildButtons() {
		GridLayout g = new GridLayout(5,0);
		g.setVgap(3);
		_buttonPanel = new JPanel(g);
		_randAll = new JButton("Randomize All");
		_randAll.setActionCommand("randAll");
		_randAll.addActionListener(new ButtonListener(this, _model));
		_randName = new JButton("Randomize Name");
		_randName.setActionCommand("randName");
		_randName.addActionListener(new ButtonListener(this, _model));
		_randFlavor = new JButton("Randomize Characteristics");
		_randFlavor.setActionCommand("randFlavor");
		_randFlavor.addActionListener(new ButtonListener(this, _model));
		_randPop = new JButton("Randomize Population");
		_randPop.setActionCommand("randPop");
		_randPop.addActionListener(new ButtonListener(this, _model));
		_randDemo = new JButton("Randomize Shops");
		_randDemo.setActionCommand("randDemo");
		_randDemo.addActionListener(new ButtonListener(this, _model));
		_buttonPanel.add(_randAll);
		_buttonPanel.add(_randName);
		_buttonPanel.add(_randPop);
		_buttonPanel.add(_randFlavor);
		_buttonPanel.add(_randDemo);
	}
	
	private void buildMenuBar() {
		_menu = new JMenuBar();
		
		_file = new JMenu("File");
		_export = new JMenuItem("Export to CSV File");
		_export.setActionCommand("export");
		_export.addActionListener(new MenuBarListener(this, _model));
		_exit = new JMenuItem("Exit");
		_exit.setActionCommand("exit");
		_exit.addActionListener(new MenuBarListener(this, _model));
		
		_file.add(_export);
		_file.add(_exit);
		
		_settings = new JMenu("Settings");
		_bgName = new ButtonGroup();
		_bgDemo = new ButtonGroup();
		_nameSettings = new JMenu("Name Generator");
		_nameAny = new JRadioButtonMenuItem("Any Style");
		_nameAny.setActionCommand("nameAny");
		_nameAny.addActionListener(new MenuBarListener(this, _model));
		_nameAmerican = new JRadioButtonMenuItem("American Style");
		_nameAmerican.setActionCommand("nameAmerican");
		_nameAmerican.addActionListener(new MenuBarListener(this, _model));
		_nameGerman = new JRadioButtonMenuItem("German Style");
		_nameGerman.setActionCommand("nameGerman");
		_nameGerman.addActionListener(new MenuBarListener(this, _model));
		_nameEnglish = new JRadioButtonMenuItem("English Style");
		_nameEnglish.setActionCommand("nameEnglish");
		_nameEnglish.addActionListener(new MenuBarListener(this, _model));
		_bgName.add(_nameAny);
		_bgName.add(_nameAmerican);
		_bgName.add(_nameGerman);
		_bgName.add(_nameEnglish);
		_nameSettings.add(_nameAny);
		_nameSettings.add(_nameAmerican);
		_nameSettings.add(_nameGerman);
		_nameSettings.add(_nameEnglish);
		_nameAny.setSelected(true);
		
		_demoSettings = new JMenu("Shop Types");
		_demoShort = new JRadioButtonMenuItem("Short List");
		_demoShort.setActionCommand("demoShort");
		_demoShort.addActionListener(new MenuBarListener(this, _model));
		_demoLong = new JRadioButtonMenuItem("Extended List");
		_demoLong.setActionCommand("demoLong");
		_demoLong.addActionListener(new MenuBarListener(this, _model));
		_bgDemo.add(_demoShort);
		_bgDemo.add(_demoLong);
		_demoSettings.add(_demoShort);
		_demoSettings.add(_demoLong);
		_demoLong.setSelected(true);
		
		_settings.add(_nameSettings);
		_settings.add(_demoSettings);
		
		_menu.add(_file);
		_menu.add(_settings);
	}
}
