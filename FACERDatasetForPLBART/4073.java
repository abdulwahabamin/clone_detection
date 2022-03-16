	public static int getStateObjectInt(int SECTION_, String OBJ_) {
		StateObject s=getStateObject(SECTION_,OBJ_);
		if(s!=null) {
			return s.getObjectAsInt();
		}
		return 0;
	}

