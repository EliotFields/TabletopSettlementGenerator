package model;

import java.util.ArrayList;

public class TownBuilder {
	
		public static final int NAME_ANY = 0;
		public static final int NAME_AMERICAN = 1;
		public static final int NAME_GERMAN = 2;
		public static final int NAME_ENGLISH = 3;
		
		public static final int DEMO_SHORT = 100;
		public static final int DEMO_LONG = 101;
	
		private NameGenerator _ng;
		private FlavorGenerator _fg;
		private DemoGenerator _dg;
		
		private int _nameSwitch;
		private int _demoSwitch;
		
		private String _name;
		private int _pop;				
		
		private ArrayList<String> _flavor;
		private ArrayList<String> _shops;
		
		public TownBuilder() {
			_ng = new NameGenerator();
			_fg = new FlavorGenerator();
			_dg = new DemoGenerator();
			
			_nameSwitch = NAME_ANY;
			_demoSwitch = DEMO_SHORT;
			
			_name = _ng.getAny();
			_pop = _dg.getPopulation();
			
			randFlavor();
			randDemo();
			
		}
		
		public void nameSet(int setting) {
			_nameSwitch = setting;
		}
		
		public void demoSet(int setting) {
			_demoSwitch = setting;
		}
		
		public void popUpdate(int p) throws IllegalArgumentException {
			if (p != _pop) {
				if (p >= 0) {
				_pop = p;
				randDemo();
				}
				else {
					throw new IllegalArgumentException();
				}
			}
		}
		
		public void randAll() {
			randName();
			randPop();
			randFlavor();
			randDemo();
		}
		
		public void randName() {
			switch (_nameSwitch) {
			case NAME_ANY: _name = _ng.getAny();
			break;
			case NAME_AMERICAN: _name = _ng.getAmerican();
			break;
			case NAME_GERMAN: _name = _ng.getGerman();
			break;
			case NAME_ENGLISH: _name = _ng.getEnglish();
			break;
			}
		}
		
		public void randPop() {
			_pop = _dg.getPopulation();
		}
		
		public void randFlavor() {
			_flavor = new ArrayList<String>();
			_flavor.add("Government: " +_fg.getGovernment());
			_flavor.add("Ruler Status: " +_fg.getRulerStatus());
			_flavor.add("Racial Relations: " +_fg.getRaceRelations());
			_flavor.add("Known For: " +_fg.getKnownFor());
			_flavor.add("Notable Trait: " +_fg.getNotableTrait());
			_flavor.add("Current Crisis: " +_fg.getCalamity());
		}
		
		public void randDemo() {
			if (_demoSwitch == DEMO_SHORT) {
				_shops = _dg.getShopsCommon(_pop);
			} else if (_demoSwitch == DEMO_LONG) {
				_shops = _dg.getShopsExtended(_pop);
			}
		}
		
		public String name() {
			return _name;
		}
		
		public int population() {
			return _pop;
		}
		
		public String popCategory(int p) {
			if (p < 1) {
				return "Empty Settlement";
			} else if (p < 101) {
				return "Hamlet";
			} else if (p < 801) {
				return "Village";
			} else if (p < 4001) {
				return "Small Town";
			} else if (p < 8001) {
				return "Large Town";
			} else if (p < 12001) {
				return "Small City";
			} else if (p < 25001) {
				return "Large City";
			} else {
				return "Metropolis";
			}
		}
		
		public String flavor() {
			String ret = "";
			for (String s: _flavor) {
				ret += s;
				ret += "\n";
			}
			ret = ret.substring(0, ret.length()-1);
			return ret;
		}
		
		public String demographics() {
			String ret = "";
			for (String s: _shops) {
				ret += s;
				ret += "\n";
			}
			ret = ret.substring(0, ret.length()-1);
			return ret;
		}
		
}
