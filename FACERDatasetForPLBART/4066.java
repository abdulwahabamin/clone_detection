	public static void addToState(int SECTION_, StateObject object) {
		if(S.state.get(Integer.valueOf(SECTION_))==null)
			S.state.put(Integer.valueOf(SECTION_), new ArrayList<StateObject>());
		List<StateObject> cstate = S.state.get(Integer.valueOf(SECTION_));
        for(StateObject sob:cstate) {
            if(sob.getName().equals(object.getName())) {
                cstate.remove(sob);
                break;
            }
            //BLog.e("HAS", sob.getObjectAsString());
        }
		cstate.add(object);
		S.state.put(Integer.valueOf(SECTION_), cstate);
	}

