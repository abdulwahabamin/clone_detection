    @Override
    public void onProgressUpdate(Integer... values) {
    	super.onProgressUpdate(values);
    	switch(values[0]) {
    	case 0:
    		try {
    			mAppWidgetManager.updateAppWidget(currentAppWidgetId, views);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}

    		break;
    	}
    	
    }

