	private Long time2Long(String timeStr) {
		String strArray[]=timeStr.split(":");
		int min=Integer.parseInt(strArray[0]);
		String strArray2[]=strArray[1].split("\\.");
		int sec=Integer.parseInt(strArray2[0]);
		int mill=Integer.parseInt(strArray2[1]);
		return min*60*1000+sec*1000+mill*10L;
	}

