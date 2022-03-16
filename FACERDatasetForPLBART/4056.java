	public static boolean replaceCurrentSection(int SECTION_) {
		if(S.sections.size()>0) {
			S.sections.set(S.sections.size()-1, Integer.valueOf(SECTION_));
			return true;
		} else {
			return false;
		}
	}

