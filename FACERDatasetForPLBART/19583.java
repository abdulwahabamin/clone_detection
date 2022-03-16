    @Override
    public int getCount() {
    	if (cursor!=null) {
            return cursor.getCount();
    	} else {
    		return 0;
    	}
    	
    }

