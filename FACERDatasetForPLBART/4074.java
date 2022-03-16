	public static long getStateObjectLong(int SECTION_, String OBJ_) {
		StateObject s=getStateObject(SECTION_,OBJ_);
		if(s!=null) {
			return s.getObjectAsLong();
		}
		return 0;
	}

