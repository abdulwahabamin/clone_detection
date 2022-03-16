    @Override
    public void onProgressUpdate(Integer... values) {
    	super.onProgressUpdate(values);
    	switch(values[0]) {
    	case 0:
    		mAppWidgetManager.updateAppWidget(currentAppWidgetId, views);
    		break;
    	}
    	
    }

