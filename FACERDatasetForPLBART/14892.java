    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    	if(mPanel.isExpanded()){
            mPanel.collapsePane();
    	}
    	else{
    		super.onBackPressed();
    	}
    }

