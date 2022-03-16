    @Override
    protected Void doInBackground(String... params) {
    	String folderPath = params[0];
    	getAudioFilePathsInFolder(folderPath);
		
		//Get the list of subdirectories and iterate through them for audio files.
		iterateThruFolder(folderPath);
		
		for (int i=0; i < subdirectoriesList.size(); i++) {
			getAudioFilePathsInFolder(subdirectoriesList.get(i));
		}
		
		//Extract the metadata from the first audio file (if any).
		if (audioFilePathsInFolder!=null && audioFilePathsInFolder.size() > 0) {
			metadata = extractFileMetadata(audioFilePathsInFolder.get(0));
		}
    	
    	return null;
	    
    }

