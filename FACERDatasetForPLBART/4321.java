	public static String encodeForEncription(String stringToEncode) {
		String encoded=null;
		try {
			encoded=Base64.encodeToString(stringToEncode.getBytes(), true);
		} catch(Exception e) {
            //BLog.e("ENC64","Error Dencodeing: "+e.getMessage());
		}
		return encoded;
	}

