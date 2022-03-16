    public void getAudioFilePathsInFolder(String folderPath) {
    	
    	//We'll use a filter to retrieve a list of all files with a matching extension.
    	File file = new File(folderPath);
    	FileExtensionFilter AUDIO_FILES_FILTER = new FileExtensionFilter(new String[] {".mp3", ".3gp", ".mp4",
    																				   ".m4a", ".aac", ".ts", 
    																				   ".flac", ".mid", ".xmf", 
    																				   ".mxmf", ".midi", ".rtttl", 
    																				   ".rtx", ".ota", ".imy", ".ogg", 
    																				   ".mkv", ".wav" });
    	
    	File[] filesInFolder = file.listFiles(AUDIO_FILES_FILTER);
    	
    	//Loop through the list of files and add their file paths to the corresponding ArrayList.
    	for (int i=0; i < filesInFolder.length; i++) {
    		
    		try {
				audioFilePathsInFolder.add(filesInFolder[i].getCanonicalPath());
			} catch (IOException e) {
				//Skip any corrupt audilo files.
				continue;
			}
    		
    	}
    	
    }

