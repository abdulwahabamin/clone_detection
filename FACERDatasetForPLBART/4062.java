	public static int getPreviousSection() {
		if(S.sections.size()-2>0 && S.sections.size()>1)
			return S.sections.get(S.sections.size()-2);
		else
			return State.SECTION_BRIEF;
	}

