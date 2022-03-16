     private void hideKeyboard(IBinder windowToken, int flags){
    	 if(mSoftKeyboardAvailable){
    		 (new org.openintents.filemanager.compatibility.SoftKeyboard(this))
    		 	.hideSoftInputFromWindow(windowToken, flags);
    	 }
     }

