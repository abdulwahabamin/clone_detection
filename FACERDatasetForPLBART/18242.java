    @Override
    protected Boolean doInBackground(String... params) {
    	
    	if (mSongID.equals(mApp.getService().getCurrentSong().getId())) {
    		try {
    			mApp.getService().getCurrentSong().setFilePath(GMusicClientCalls.getSongStream(mSongID).toURL().toString());
    		} catch (MalformedURLException e) {
    			e.printStackTrace();
    			return false;
    		} catch (JSONException e) {
    			e.printStackTrace();
    			return false;
    		} catch (URISyntaxException e) {
    			e.printStackTrace();
    			return false;
    		} catch (Exception e) {
    			e.printStackTrace();
    			return false;
    		}
        	
        	if (mApp.getService().getCurrentSong().getId()==null) {
        		return false;
        	} else {
        		return true;
        	}
        	
    	} else {
    		this.cancel(true);
    		return false;
    	}
    	
    }

