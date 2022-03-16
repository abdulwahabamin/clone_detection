	/**
	 * Searchs for folder art within the specified file's 
	 * parent folder. Returns a path string to the artwork 
	 * image file if it exists. Returns an empty string 
	 * otherwise.
	 */
	public String getArtworkFromFolder(String filePath) {
		
		File file = new File(filePath);
		if (!file.exists()) {
			return "";
			
		} else {
			//Create a File that points to the parent directory of the album.
			File directoryFile = file.getParentFile();
			String directoryPath = "";
			String albumArtPath = "";
			try {
				directoryPath = directoryFile.getCanonicalPath();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			//Check if album art was already found in this directory.
			if (mFolderArtHashMap.containsKey(directoryPath))
				return mFolderArtHashMap.get(directoryPath);
			
			//Get a list of images in the album's folder.
			FileExtensionFilter IMAGES_FILTER = new FileExtensionFilter(new String[] {".jpg", ".jpeg", 
																					  ".png", ".gif"});
			File[] folderList = directoryFile.listFiles(IMAGES_FILTER);
			
			//Check if any image files were found in the folder.
			if (folderList.length==0) {
				//No images found.
				return "";
				
			} else {
				
				//Loop through the list of image files. Use the first jpeg file if it's found.
				for (int i=0; i < folderList.length; i++) {
					
					try {
						albumArtPath = folderList[i].getCanonicalPath();
						if (albumArtPath.endsWith("jpg") ||
							albumArtPath.endsWith("jpeg")) {
							
							//Add the folder's album art file to the hash.
							mFolderArtHashMap.put(directoryPath, albumArtPath);
							return albumArtPath;
						}
						
					} catch (Exception e) {
						//Skip the file if it's corrupted or unreadable.
						continue;
					}
					
				}
				
				//If an image was not found, check for gif or png files (lower priority).
				for (int i=0; i < folderList.length; i++) {
    				
    				try {
    					albumArtPath = folderList[i].getCanonicalPath();
						if (albumArtPath.endsWith("png") ||
							albumArtPath.endsWith("gif")) {

							//Add the folder's album art file to the hash.
							mFolderArtHashMap.put(directoryPath, albumArtPath);
							return albumArtPath;
						}
						
					} catch (Exception e) {
						//Skip the file if it's corrupted or unreadable.
						continue;
					}
    				
    			}
				
			}
    		
			//Add the folder's album art file to the hash.
			mFolderArtHashMap.put(directoryPath, albumArtPath);
			return "";
    	}
		
	}

