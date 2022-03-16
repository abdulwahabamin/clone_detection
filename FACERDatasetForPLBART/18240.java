    @Override
    protected void onPostExecute(String arg0) {
    	
    	//Release the wakelock.
    	wakeLock.release();
        	
    }

