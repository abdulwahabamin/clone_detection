     /**
      * Show the directory line as input box instead of button row.
      * If Directory input does not exist yet, it is created.
      * Since the default is show == false, nothing is created if
      * it is not necessary (like after icicle).
      * @param show
      */
     private void showDirectoryInput(boolean show) {
    	 if (show) {
    		 if (mDirectoryInput == null) {
        		 onCreateDirectoryInput();
        	 }
    	 }
    	 if (mDirectoryInput != null) {
	    	 mDirectoryInput.setVisibility(show ? View.VISIBLE : View.GONE);
	    	 mDirectoryButtons.setVisibility(show ? View.GONE : View.VISIBLE);
    	 }
    	 
    	 refreshDirectoryPanel();
     }

