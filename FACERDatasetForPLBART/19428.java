	public boolean writeToM3UFile() {
		
		BufferedWriter writer = null;
        try {
        	
        	//Check if the playlist target folder exists.
        	File folderPath = new File(mPlaylistFolderPath);
        	if (folderPath.isDirectory()==false) {
        		folderPath.mkdirs();
        	}
        	
            //Create/open the M3U file for writing.
        	mFullFilePath = mPlaylistFolderPath + "/" + mPlaylistName + ".m3u";
        	File file = new File(mFullFilePath);
            
        	//Create the opening M3U header only if the playlist doesn't already exist.
            writer = null;
        	if (file.exists()==false) {
        		writer = new BufferedWriter(new FileWriter(file, false));
        		writer.write("#EXTM3U");
        	} else {
        		writer = new BufferedWriter(new FileWriter(file, true));
        	}
        	
        	//Convert the duration units from millisecs to seconds.
        	long duration = Long.parseLong(mDurationInMs);
        	duration = duration/1000;
        	String durationInSecs = duration + "";
        	
        	//If the playlist element path and the duration are both null, just create an empty playlist.
        	if (durationInSecs!=null && mPlaylistElementPath!=null) {
                writer.newLine();
                writer.write("#EXTINF:" + durationInSecs + ", " + getSongTitle(mPlaylistElementPath));
                writer.newLine();
                writer.write("\"" + getRelativePath(mPlaylistFolderPath, mPlaylistElementPath) + "\"");
        	}
        	
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
        	
            try {
                writer.close();
            } catch (Exception e) {
            	//Get rid of the writer object on the next garbage collection run.
            	writer = null;
            }
         
        }
        
        return true;
	}

