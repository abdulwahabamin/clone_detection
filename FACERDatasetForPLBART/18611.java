    @Override
    public void onDestroyView() {
    	super.onDestroyView();
    	
    	if (cursor!=null) {
    		cursor.close();
    		cursor = null;
    	}
		
    }

