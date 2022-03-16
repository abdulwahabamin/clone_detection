	public static String decodeFromEncription(String stringToDecode) {
		String dencoded=null;
		try {
			dencoded=new String(Base64.decode(stringToDecode.toCharArray()));
		} catch(Exception e) {
            //BLog.e("ENC64","Error Dencodeing: "+e.getMessage());
		}
		return dencoded;
	}

