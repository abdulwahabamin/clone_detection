    public static String btyesToFileSizeString(long fileSizeInBtyes) {
    	if(fileSizeInBtyes>shouldbeMegs)
    		return df.format((fileSizeInBtyes/1024D)/1024D)+" mb";
    	else
    		return df.format(fileSizeInBtyes/1024D)+" kb";
    }

