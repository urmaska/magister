package test;

public class RuleSystem {

	public static String reegliSystem(String RIVER, String ERECTED, String PURPOSE, String LENGTH, String LANES, String CLEARG, String TORD, String MATERIAL, String SPAN, String RELL){
		if(MATERIAL.equals("WOOD"))
			 return "WOOD";
		else if(SPAN.equals("MEDIUM") && PURPOSE.equals("RR"))
			 return "SIMPLE-T";
		else if(ERECTED.equals("MODERN") && TORD.equals("DECK"))
			 return "CONT-T";
		else if(CLEARG.equals("G") && RIVER.equals("M") && LENGTH.equals("?"))
			 return "SIMPLE-T";
		else if(LANES.equals("6"))
			 return "ARCH";
		else if(LENGTH.equals("?") && ERECTED.equals("EMERGING"))
			 return "SIMPLE-T";
		else if(PURPOSE.equals("HIGHWAY") && TORD.equals("THROUGH") && RIVER.equals("A") && RELL.equals("S-F"))
			 return "SUSPEN";
		else if(CLEARG.equals("G") && RELL.equals("F") && PURPOSE.equals("RR") && LENGTH.equals("LONG"))
			 return "SIMPLE-T";
		else if(ERECTED.equals("MATURE") && LANES.equals("2") && LENGTH.equals("MEDIUM") && RIVER.equals("O"))
			 return "CANTILEV";
		else if(TORD.equals("THROUGH") && ERECTED.equals("MATURE") && LANES.equals("2") && PURPOSE.equals("HIGHWAY") && LENGTH.equals("LONG"))
			 return "SIMPLE-T";
		else if(MATERIAL.equals("?"))
			 return "?";
		else if(CLEARG.equals("G") && MATERIAL.equals("IRON"))
			 return "SIMPLE-T";
		else if(LANES.equals("4") && RIVER.equals("O"))
			 return "ARCH";
		else if(SPAN.equals("MEDIUM") && RIVER.equals("M") && TORD.equals("DECK"))
			 return "CANTILEV";
		else if(CLEARG.equals("N") && ERECTED.equals("MATURE") && SPAN.equals("LONG") && TORD.equals("DECK"))
			 return "CONT-T";
		else if(RELL.equals("S") && LANES.equals("?"))
			 return "ARCH";
		else if(CLEARG.equals("G") && RELL.equals("F") && MATERIAL.equals("STEEL") && PURPOSE.equals("HIGHWAY") && LANES.equals("?"))
			 return "SIMPLE-T";
		else if(ERECTED.equals("MATURE") && RIVER.equals("A") && LANES.equals("4") && LENGTH.equals("LONG"))
			 return "ARCH";
		else if(LENGTH.equals("MEDIUM") && RIVER.equals("A") && SPAN.equals("LONG"))
			 return "SIMPLE-T";
		else if(PURPOSE.equals("WALK"))
			 return "SUSPEN";
		else if(PURPOSE.equals("HIGHWAY") && CLEARG.equals("?"))
			 return "SUSPEN";
		else if(MATERIAL.equals("IRON") && PURPOSE.equals("AQUEDUCT"))
			 return "SUSPEN";
		else if(RIVER.equals("A") && RELL.equals("?"))
			 return "SUSPEN";
		else if(ERECTED.equals("MATURE") && RIVER.equals("A") && TORD.equals("?"))
			 return "NIL";
		else if(PURPOSE.equals("RR") && SPAN.equals("SHORT"))
			 return "SIMPLE-T";
		else if(LENGTH.equals("MEDIUM") && RIVER.equals("M") && SPAN.equals("SHORT"))
			 return "SUSPEN";
		else if(LANES.equals("4") && RIVER.equals("M") && LENGTH.equals("SHORT"))
			 return "CONT-T";
		else if(RELL.equals("F") && ERECTED.equals("MATURE") && LENGTH.equals("SHORT"))
			 return "ARCH";
		else if(SPAN.equals("LONG") && LENGTH.equals("?") && RIVER.equals("O"))
			 return "SUSPEN";
		else if(LANES.equals("2") && ERECTED.equals("MODERN") && LENGTH.equals("LONG") && RIVER.equals("O"))
			 return "CANTILEV";
		else if(LENGTH.equals("MEDIUM") && ERECTED.equals("MODERN") && RIVER.equals("O"))
			 return "CONT-T";
		else if(PURPOSE.equals("HIGHWAY") && RIVER.equals("M") && RELL.equals("S") && ERECTED.equals("EMERGING"))
			 return "ARCH";
		else if(RELL.equals("F") && LENGTH.equals("MEDIUM") && TORD.equals("DECK"))
			 return "CANTILEV";
		else if(ERECTED.equals("MODERN") && RIVER.equals("M") && RELL.equals("S-F"))
			 return "SIMPLE-T";
		else if(RIVER.equals("M") && LANES.equals("4") && LENGTH.equals("MEDIUM") && ERECTED.equals("MODERN"))
			 return "CANTILEV";
		else if(RIVER.equals("A") && SPAN.equals("MEDIUM") && LENGTH.equals("?"))
			 return "SIMPLE-T";
		else if(LENGTH.equals("MEDIUM") && LANES.equals("2") && RIVER.equals("M") && SPAN.equals("LONG"))
			 return "ARCH";
		return "";
	}
	public static String sagedaseimTunnus(String RIVER, String ERECTED, String PURPOSE, String LENGTH, String LANES, String CLEARG, String TORD, String MATERIAL, String SPAN, String RELL){

		if(PURPOSE.equals("RR")){
			if(SPAN.equals("MEDIUM")){
					return "SIMPLE-T";
			}if(CLEARG.equals("G")){
				if(RELL.equals("F")){
					if(LENGTH.equals("LONG")){
							return "SIMPLE-T";}}
			}if(SPAN.equals("SHORT")){
					return "SIMPLE-T";}
		}if(CLEARG.equals("G")){
			if(RIVER.equals("M")){
				if(LENGTH.equals("?")){
						return "SIMPLE-T";}
			}if(MATERIAL.equals("IRON")){
					return "SIMPLE-T";
			}if(MATERIAL.equals("STEEL")){
				if(RELL.equals("F")){
					if(PURPOSE.equals("HIGHWAY")){
						if(LANES.equals("?")){
								return "SIMPLE-T";}}}}
		}if(MATERIAL.equals("WOOD")){
				return "WOOD";
		}if(RIVER.equals("A")){
			if(PURPOSE.equals("HIGHWAY")){
				if(TORD.equals("THROUGH")){
					if(RELL.equals("S-F")){
							return "SUSPEN";}}
			}if(ERECTED.equals("MATURE")){
				if(LANES.equals("4")){
					if(LENGTH.equals("LONG")){
							return "ARCH";}
				}if(TORD.equals("?")){
						return "NIL";}
			}if(SPAN.equals("MEDIUM")){
				if(LENGTH.equals("?")){
						return "SIMPLE-T";}
			}if(LENGTH.equals("MEDIUM")){
				if(SPAN.equals("LONG")){
						return "SIMPLE-T";}
			}if(RELL.equals("?")){
					return "SUSPEN";}
		}if(ERECTED.equals("MATURE")){
			if(LANES.equals("2")){
				if(LENGTH.equals("MEDIUM")){
					if(RIVER.equals("O")){
							return "CANTILEV";}
				}if(LENGTH.equals("LONG")){
					if(TORD.equals("THROUGH")){
						if(PURPOSE.equals("HIGHWAY")){
								return "SIMPLE-T";}}}
			}if(TORD.equals("DECK")){
				if(CLEARG.equals("N")){
					if(SPAN.equals("LONG")){
							return "CONT-T";}}
			}if(LENGTH.equals("SHORT")){
				if(RELL.equals("F")){
						return "ARCH";}}
		}if(TORD.equals("DECK")){
			if(ERECTED.equals("MODERN")){
					return "CONT-T";
			}if(SPAN.equals("MEDIUM")){
				if(RIVER.equals("M")){
						return "CANTILEV";}
			}if(RELL.equals("F")){
				if(LENGTH.equals("MEDIUM")){
						return "CANTILEV";}}
		}if(ERECTED.equals("EMERGING")){
			if(LENGTH.equals("?")){
					return "SIMPLE-T";
			}if(RELL.equals("S")){
				if(PURPOSE.equals("HIGHWAY")){
					if(RIVER.equals("M")){
							return "ARCH";}}}
		}if(LANES.equals("4")){
			if(RIVER.equals("O")){
					return "ARCH";
			}if(RIVER.equals("M")){
				if(LENGTH.equals("SHORT")){
						return "CONT-T";
				}if(ERECTED.equals("MODERN")){
					if(LENGTH.equals("MEDIUM")){
							return "CANTILEV";}}}
		}if(LANES.equals("?")){
			if(RELL.equals("S")){
					return "ARCH";}
		}if(LANES.equals("6")){
				return "ARCH";
		}if(MATERIAL.equals("?")){
				return "?";
		}if(PURPOSE.equals("AQUEDUCT")){
			if(MATERIAL.equals("IRON")){
					return "SUSPEN";}
		}if(CLEARG.equals("?")){
			if(PURPOSE.equals("HIGHWAY")){
					return "SUSPEN";}
		}if(PURPOSE.equals("WALK")){
				return "SUSPEN";}
		if(LENGTH.equals("MEDIUM")){
			if(RIVER.equals("M")){
				if(SPAN.equals("SHORT")){
						return "SUSPEN";
				}if(SPAN.equals("LONG")){
					if(LANES.equals("2")){
							return "ARCH";}}
			}if(RIVER.equals("O")){
				if(ERECTED.equals("MODERN")){
						return "CONT-T";}}
		}if(ERECTED.equals("MODERN")){
			if(LANES.equals("2")){
				if(LENGTH.equals("LONG")){
					if(RIVER.equals("O")){
							return "CANTILEV";}}
			}if(RELL.equals("S-F")){
				if(RIVER.equals("M")){
						return "SIMPLE-T";}}
		}if(RIVER.equals("O")){
			if(SPAN.equals("LONG")){
				if(LENGTH.equals("?")){
						return "SUSPEN";}}}
		return "";
	}
	public static String sagedus(String RIVER, String ERECTED, String PURPOSE, String LENGTH, String LANES, String CLEARG, String TORD, String MATERIAL, String SPAN, String RELL){

		if(MATERIAL.equals("WOOD"))
			 return "WOOD";
		 else if(SPAN.equals("MEDIUM") && PURPOSE.equals("RR"))
			 return "SIMPLE-T";
		 else if(CLEARG.equals("G") && RIVER.equals("M") && LENGTH.equals("?"))
			 return "SIMPLE-T";
		 else if(CLEARG.equals("G") && RELL.equals("F") && PURPOSE.equals("RR") && LENGTH.equals("LONG"))
			 return "SIMPLE-T";
		 else if(ERECTED.equals("MODERN") && TORD.equals("DECK"))
			 return "CONT-T";
		 else if(LENGTH.equals("?") && ERECTED.equals("EMERGING"))
			 return "SIMPLE-T";
		 else if(CLEARG.equals("G") && MATERIAL.equals("IRON"))
			 return "SIMPLE-T";
		 else if(LANES.equals("6"))
			 return "ARCH";
		 else if(PURPOSE.equals("HIGHWAY") && TORD.equals("THROUGH") && RIVER.equals("A") && RELL.equals("S-F"))
			 return "SUSPEN";
		 else if(CLEARG.equals("G") && RELL.equals("F") && MATERIAL.equals("STEEL") && PURPOSE.equals("HIGHWAY") && LANES.equals("?"))
			 return "SIMPLE-T";
		 else if(ERECTED.equals("MATURE") && LANES.equals("2") && LENGTH.equals("MEDIUM") && RIVER.equals("O"))
			 return "CANTILEV";
		 else if(RIVER.equals("A") && SPAN.equals("MEDIUM") && LENGTH.equals("?"))
			 return "SIMPLE-T";
		 else if(TORD.equals("THROUGH") && ERECTED.equals("MATURE") && LANES.equals("2") && PURPOSE.equals("HIGHWAY") && LENGTH.equals("LONG"))
			 return "SIMPLE-T";
		 else if(ERECTED.equals("MATURE") && RIVER.equals("A") && LANES.equals("4") && LENGTH.equals("LONG"))
			 return "ARCH";
		 else if(RELL.equals("S") && LANES.equals("?"))
			 return "ARCH";
		 else if(LENGTH.equals("MEDIUM") && RIVER.equals("A") && SPAN.equals("LONG"))
			 return "SIMPLE-T";
		 else if(MATERIAL.equals("?"))
			 return "?";
		 else if(LANES.equals("4") && RIVER.equals("O"))
			 return "ARCH";
		 else if(SPAN.equals("MEDIUM") && RIVER.equals("M") && TORD.equals("DECK"))
			 return "CANTILEV";
		 else if(CLEARG.equals("N") && ERECTED.equals("MATURE") && SPAN.equals("LONG") && TORD.equals("DECK"))
			 return "CONT-T";
		 else if(LENGTH.equals("MEDIUM") && ERECTED.equals("MODERN") && RIVER.equals("O"))
			 return "CONT-T";
		 else if(LENGTH.equals("MEDIUM") && LANES.equals("2") && RIVER.equals("M") && SPAN.equals("LONG"))
			 return "ARCH";
		 else if(RELL.equals("F") && ERECTED.equals("MATURE") && LENGTH.equals("SHORT"))
			 return "ARCH";
		 else if(PURPOSE.equals("HIGHWAY") && CLEARG.equals("?"))
			 return "SUSPEN";
		 else if(PURPOSE.equals("HIGHWAY") && RIVER.equals("M") && RELL.equals("S") && ERECTED.equals("EMERGING"))
			 return "ARCH";
		 else if(RELL.equals("F") && LENGTH.equals("MEDIUM") && TORD.equals("DECK"))
			 return "CANTILEV";
		 else if(ERECTED.equals("MODERN") && RIVER.equals("M") && RELL.equals("S-F"))
			 return "SIMPLE-T";
		 else if(LANES.equals("4") && RIVER.equals("M") && LENGTH.equals("SHORT"))
			 return "CONT-T";
		 else if(RIVER.equals("M") && LANES.equals("4") && LENGTH.equals("MEDIUM") && ERECTED.equals("MODERN"))
			 return "CANTILEV";
		 else if(PURPOSE.equals("RR") && SPAN.equals("SHORT"))
			 return "SIMPLE-T";
		 else if(LENGTH.equals("MEDIUM") && RIVER.equals("M") && SPAN.equals("SHORT"))
			 return "SUSPEN";
		 else if(PURPOSE.equals("WALK"))
			 return "SUSPEN";
		 else if(LANES.equals("2") && ERECTED.equals("MODERN") && LENGTH.equals("LONG") && RIVER.equals("O"))
			 return "CANTILEV";
		 else if(RIVER.equals("A") && RELL.equals("?"))
			 return "SUSPEN";
		 else if(ERECTED.equals("MATURE") && RIVER.equals("A") && TORD.equals("?"))
			 return "NIL";
		 else if(SPAN.equals("LONG") && LENGTH.equals("?") && RIVER.equals("O"))
			 return "SUSPEN";
		 else if(MATERIAL.equals("IRON") && PURPOSE.equals("AQUEDUCT"))
			 return "SUSPEN";
		return "";
	}
	public static String pikkus(String RIVER, String ERECTED, String PURPOSE, String LENGTH, String LANES, String CLEARG, String TORD, String MATERIAL, String SPAN, String RELL){

		if(MATERIAL.equals("WOOD"))
			 return "WOOD";
		 else if(LANES.equals("6"))
			 return "ARCH";
		 else if(MATERIAL.equals("?"))
			 return "?";
		 else if(PURPOSE.equals("WALK"))
			 return "SUSPEN";
		 else if(SPAN.equals("MEDIUM") && PURPOSE.equals("RR"))
			 return "SIMPLE-T";
		 else if(ERECTED.equals("MODERN") && TORD.equals("DECK"))
			 return "CONT-T";
		 else if(LENGTH.equals("?") && ERECTED.equals("EMERGING"))
			 return "SIMPLE-T";
		 else if(CLEARG.equals("G") && MATERIAL.equals("IRON"))
			 return "SIMPLE-T";
		 else if(RELL.equals("S") && LANES.equals("?"))
			 return "ARCH";
		 else if(LANES.equals("4") && RIVER.equals("O"))
			 return "ARCH";
		 else if(PURPOSE.equals("HIGHWAY") && CLEARG.equals("?"))
			 return "SUSPEN";
		 else if(MATERIAL.equals("IRON") && PURPOSE.equals("AQUEDUCT"))
			 return "SUSPEN";
		 else if(RIVER.equals("A") && RELL.equals("?"))
			 return "SUSPEN";
		 else if(PURPOSE.equals("RR") && SPAN.equals("SHORT"))
			 return "SIMPLE-T";
		 else if(CLEARG.equals("G") && RIVER.equals("M") && LENGTH.equals("?"))
			 return "SIMPLE-T";
		 else if(RIVER.equals("A") && SPAN.equals("MEDIUM") && LENGTH.equals("?"))
			 return "SIMPLE-T";
		 else if(LENGTH.equals("MEDIUM") && RIVER.equals("A") && SPAN.equals("LONG"))
			 return "SIMPLE-T";
		 else if(SPAN.equals("MEDIUM") && RIVER.equals("M") && TORD.equals("DECK"))
			 return "CANTILEV";
		 else if(RELL.equals("F") && LENGTH.equals("MEDIUM") && TORD.equals("DECK"))
			 return "CANTILEV";
		 else if(ERECTED.equals("MODERN") && RIVER.equals("M") && RELL.equals("S-F"))
			 return "SIMPLE-T";
		 else if(LANES.equals("4") && RIVER.equals("M") && LENGTH.equals("SHORT"))
			 return "CONT-T";
		 else if(SPAN.equals("LONG") && LENGTH.equals("?") && RIVER.equals("O"))
			 return "SUSPEN";
		 else if(ERECTED.equals("MATURE") && RIVER.equals("A") && TORD.equals("?"))
			 return "NIL";
		 else if(LENGTH.equals("MEDIUM") && ERECTED.equals("MODERN") && RIVER.equals("O"))
			 return "CONT-T";
		 else if(LENGTH.equals("MEDIUM") && RIVER.equals("M") && SPAN.equals("SHORT"))
			 return "SUSPEN";
		 else if(RELL.equals("F") && ERECTED.equals("MATURE") && LENGTH.equals("SHORT"))
			 return "ARCH";
		 else if(CLEARG.equals("G") && RELL.equals("F") && PURPOSE.equals("RR") && LENGTH.equals("LONG"))
			 return "SIMPLE-T";
		 else if(PURPOSE.equals("HIGHWAY") && TORD.equals("THROUGH") && RIVER.equals("A") && RELL.equals("S-F"))
			 return "SUSPEN";
		 else if(ERECTED.equals("MATURE") && LANES.equals("2") && LENGTH.equals("MEDIUM") && RIVER.equals("O"))
			 return "CANTILEV";
		 else if(ERECTED.equals("MATURE") && RIVER.equals("A") && LANES.equals("4") && LENGTH.equals("LONG"))
			 return "ARCH";
		 else if(CLEARG.equals("N") && ERECTED.equals("MATURE") && SPAN.equals("LONG") && TORD.equals("DECK"))
			 return "CONT-T";
		 else if(RIVER.equals("M") && LANES.equals("4") && LENGTH.equals("MEDIUM") && ERECTED.equals("MODERN"))
			 return "CANTILEV";
		 else if(LENGTH.equals("MEDIUM") && LANES.equals("2") && RIVER.equals("M") && SPAN.equals("LONG"))
			 return "ARCH";
		 else if(PURPOSE.equals("HIGHWAY") && RIVER.equals("M") && RELL.equals("S") && ERECTED.equals("EMERGING"))
			 return "ARCH";
		 else if(LANES.equals("2") && ERECTED.equals("MODERN") && LENGTH.equals("LONG") && RIVER.equals("O"))
			 return "CANTILEV";
		 else if(TORD.equals("THROUGH") && ERECTED.equals("MATURE") && LANES.equals("2") && PURPOSE.equals("HIGHWAY") && LENGTH.equals("LONG"))
			 return "SIMPLE-T";
		 else if(CLEARG.equals("G") && RELL.equals("F") && MATERIAL.equals("STEEL") && PURPOSE.equals("HIGHWAY") && LANES.equals("?"))
			 return "SIMPLE-T";
		return "";
	}
}
