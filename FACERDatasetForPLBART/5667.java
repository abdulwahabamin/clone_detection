     private void hideKeyboard(IBinder windowToken, int flags){
    	 if(mSoftKeyboardAvailable){
    		 (new org.openintents.cmfilemanager.compatibility.SoftKeyboard(this))
    		 	.hideSoftInputFromWindow(windowToken, flags);
    	 }
     }

