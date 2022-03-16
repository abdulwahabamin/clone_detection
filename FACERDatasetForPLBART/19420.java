    public String convertStreamToString(java.io.InputStream is) {
    	
	    try {
	    	return new java.util.Scanner(is).useDelimiter("\\A").next();
	    } catch (NoSuchElementException e) {
	    	return "";
	    }
	    
    }

