	public static int getCurrentSection() {
		if(!S.sections.isEmpty())
			return S.sections.get(S.sections.size() - 1);
		else
			return State.SECTION_BRIEF;
	}

