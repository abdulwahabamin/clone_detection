	public synchronized static boolean sectionsGoBackstack() {
		if(!S.sections.isEmpty())
			S.sections.remove(S.sections.size()-1);
		return true;
		//S.psection=S.section;
		//S.section=SECTION_;
		//BLog.e("SECTION",""+SECTION_);
	}

