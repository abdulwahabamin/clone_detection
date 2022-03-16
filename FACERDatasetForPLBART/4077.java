	public static boolean hasStateObject(int SECTION_, String OBJ_) {
		if(S.state.get(Integer.valueOf(SECTION_))!=null) {
			for(StateObject state: S.state.get(Integer.valueOf(SECTION_))) {
				if(state.getName().equals(OBJ_)) {
					return true;
				}
			}
		}
		return false;
	}

