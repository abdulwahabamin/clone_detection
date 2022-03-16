	public static boolean setCurrentSection(int SECTION_) {
		if(State.getCurrentSection()!=SECTION_) {
			S.sections.add(Integer.valueOf(SECTION_));
			return true;
			//BLog.e("SECTION","ADDED: "+SECTION_);
		} else {
			return false;
			//BLog.e("SECTION","NO ADD: "+SECTION_);
		}
		
		//S.psection=S.section;
		//S.section=SECTION_;
		//BLog.e("SECTION",""+SECTION_);
	}

