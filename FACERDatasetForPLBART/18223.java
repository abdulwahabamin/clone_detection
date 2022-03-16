    @Override
    protected Boolean doInBackground(String... params) {
    	
    	if (mSourceType==FilesFoldersFragment.FOLDER) {
    		
    		try {
				FileUtils.deleteDirectory(mSourceFile);
			} catch (Exception e) {
				return false;
			}
    		
    	} else {
    		try {
    			boolean status = mSourceFile.delete();
    			if (status==true) {
    				return true;
    			} else {
    				return false;
    			}
    			
    		} catch (Exception e) {
    			return false;
    		}
    		
    	}

    	return true;
    }

