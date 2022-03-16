	public static double getStateObjectDouble(int SECTION_, String OBJ_) {
		StateObject s=getStateObject(SECTION_,OBJ_);
		if(s!=null) {
			return s.getObjectAsDouble();
		}
		return 0;
	}

