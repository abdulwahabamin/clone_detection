     private void goToDirectoryInEditText() {
    	 File browseto = new File(mEditDirectory.getText().toString());
    	 
		 /*
		  *  After calling showDirectoryInput(false); the keyboard stays displayed.
		  *  Hide it by calling hideKeyboard(windowToken, 0);
		  *  Might be a bit problematic - it hides the keyboard even if id didn't
		  *  appear after focusing the editText (user had it displayed before).
		  *  But I think letting it displayed when user doesn't want to
		  *  is much worse (and much more common) than hiding it although
		  *  the user wants it displayed
		  */

    	 IBinder windowToken = mEditDirectory.getWindowToken();
    	 
    	 if (browseto.equals(currentDirectory)) {
    		 showDirectoryInput(false);
    		 hideKeyboard(windowToken, 0);
    	 } else {
    		 if (mHaveShownErrorMessageForFile != null 
    				 && mHaveShownErrorMessageForFile.equals(browseto)) {
    			 // Don't let user get stuck in wrong directory.
    			 mHaveShownErrorMessageForFile = null;
        		 showDirectoryInput(false);
        		 hideKeyboard(windowToken, 0);
    		 } else {
	    		 if (!browseto.exists()) {
	    			 // browseTo() below will show an error message,
	    			 // because file does not exist.
	    			 // It is ok to show this the first time.
	    			 mHaveShownErrorMessageForFile = browseto;
	    		 }else{
	        		 showDirectoryInput(false);
	        		 hideKeyboard(windowToken, 0);
	    		 }
				 browseTo(browseto);
    		 }
    	 }
     }

