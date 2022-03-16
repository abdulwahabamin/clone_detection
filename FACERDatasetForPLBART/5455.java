     private void goToDirectoryInEditText() {
    	 File browseto = new File(mEditDirectory.getText().toString());
    	 
    	 if (browseto.equals(currentDirectory)) {
    		 showDirectoryInput(false);
    	 } else {
    		 if (mHaveShownErrorMessageForFile != null 
    				 && mHaveShownErrorMessageForFile.equals(browseto)) {
    			 // Don't let user get stuck in wrong directory.
    			 mHaveShownErrorMessageForFile = null;
        		 showDirectoryInput(false);
    		 } else {
	    		 if (!browseto.exists()) {
	    			 // browseTo() below will show an error message,
	    			 // because file does not exist.
	    			 // It is ok to show this the first time.
	    			 mHaveShownErrorMessageForFile = browseto;
	    		 }
				 browseTo(browseto);
    		 }
    	 }
     }

