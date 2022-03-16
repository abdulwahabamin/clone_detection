	public static String stripdownToEmail(String fullEmailWithName) {
		if(fullEmailWithName!=null) {
			if(fullEmailWithName.indexOf("<")!=-1) {
				try {
				String[] sp1=fullEmailWithName.split("<");
				fullEmailWithName=sp1[1].substring(0,sp1[1].indexOf(">"));
				} catch(Exception e) {}
			}
				
			fullEmailWithName=fullEmailWithName.trim();
			//BLog.e("GCONTACT", "get with email: "+spl);
			if(Sf.isValidEmail(fullEmailWithName)) {
				return fullEmailWithName;
			} 
		}
		return "";

	}

