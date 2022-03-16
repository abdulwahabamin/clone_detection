	/**
	 * Searchs for embedded art within the specified file.
	 * Returns a path string to the artwork if it exists.
	 * Returns an empty string otherwise.
	 */
	public String getEmbeddedArtwork(String filePath) {
		File file = new File(filePath);
		if (!file.exists()) {
			if (mApp.getSharedPreferences().getInt("ALBUM_ART_SOURCE", 0)==0) {
				return getArtworkFromFolder(filePath);
			} else {
				return "";
			}
			
		} else {
        	mMMDR.setDataSource(filePath);
        	byte[] embeddedArt = mMMDR.getEmbeddedPicture();
        	
        	if (embeddedArt!=null) {
        		return "byte://" + filePath;
        	} else {
    			if (mApp.getSharedPreferences().getInt("ALBUM_ART_SOURCE", 0)==0) {
    				return getArtworkFromFolder(filePath);
    			} else {
    				return "";
    			}
    			
        	}
        	
		}
		
	}

