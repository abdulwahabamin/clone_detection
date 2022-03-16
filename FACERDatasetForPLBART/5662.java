     public void onDestroy() {
    	 super.onDestroy();
    	 
    	 // Stop the scanner.
    	 DirectoryScanner scanner = mDirectoryScanner;
    	 
    	 if (scanner != null) {
    		 scanner.cancel = true;
    	 }
    	 
    	 mDirectoryScanner = null;
    	 
    	 ThumbnailLoader loader = mThumbnailLoader;
    	 
    	 if (loader != null) {
    		 loader.cancel();
    		 mThumbnailLoader = null;
    	 }
    	 
    	 ListView lv;
    	 if((lv = getListView()) != null){
    		 lv.setAdapter(null);
    	 }
     }

