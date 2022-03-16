	private static StateObject getStateObject(int SECTION_, String OBJ_) {
		//ArrayList<StateObject> states = State.getState();
		if(S.state.get(Integer.valueOf(SECTION_))!=null) {
			for(StateObject state: S.state.get(Integer.valueOf(SECTION_))) {
				if(state.getName().equals(OBJ_)) {
					return state;
				}
			}
		}
		return null;
	}

