	public static String getStateObjectString(int SECTION_, String OBJ_) {
		StateObject s=getStateObject(SECTION_,OBJ_);
		if(s!=null) {
			return s.getObjectAsString();
		}
		return null;
	}

