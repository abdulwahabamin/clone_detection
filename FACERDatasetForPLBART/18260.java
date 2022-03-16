    public void downloadSong(String songID) {
    	
    	//Update the notification.
    	publishProgress(new Integer[] {1});

    	//Check if the file already exists. If so, skip it.
    	File tempFile = new File(mSaveLocation + "/" + songID + ".mp3");
    	
    	if (tempFile.exists()) {
    		tempFile = null;
    		return;
    	}
    	
    	tempFile = null;
    	mFileName = songID + ".mp3";
    	
		//Get the url for the song file using the songID.
		URL url = null;
		try {
			url = GMusicClientCalls.getSongStream(songID).toURL();
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return;
		} catch (JSONException e) {
			e.printStackTrace();
			return;
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return;
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		
		try {
			//Download the file to the specified location.
			//Create a new connection to the server.
		    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		
		    //Set the request method of the connection.
		    urlConnection.setRequestMethod("GET");
		    urlConnection.setDoOutput(true);
		
		    //Aaaand connect!
		    urlConnection.connect();
		
		    //Set the destination path of the file.
		    File SDCardRoot = new File(mSaveLocation);

		    //Create the destination file.
		    File file = new File(SDCardRoot, mFileName);
		
		    //We'll use this to write the downloaded data into the file we created
		    FileOutputStream fileOutput = new FileOutputStream(file);
		
		    //Aaand we'll use this to read the data from the server.
		    InputStream inputStream = urlConnection.getInputStream();
		
		    //Total size of the file.
		    fileSize = urlConnection.getContentLength();
		    
		    //Specifies how much of the total size has been downloaded.
		    currentDownloadedSize = 0;
		
		    //Buffers galore!
		    byte[] buffer = new byte[1024];
		    int bufferLength = 0; //Used to store a temporary size of the buffer.
		    int updateValue = 0;
		    
		    //Read through the input buffer and write the destination file, piece by piece.
		    while ((bufferLength = inputStream.read(buffer)) > 0) {
	            fileOutput.write(buffer, 0, bufferLength);
	            currentDownloadedSize += bufferLength;
	            updateValue = updateValue + 1;
	            
	            //Update the notification for every 100 iterations.
	            if (updateValue==100) {
	            	publishProgress(new Integer[] {0});
	            	updateValue = 0;
	            }
	        
		    }
		    
		    try {
		    	//Close the output stream.
		    	fileOutput.close();
		    } catch (Exception e) {
		    	e.printStackTrace();
		    }
		    
		//And we're done!
		} catch (MalformedURLException e) {
			return;
		} catch (IOException e) {
			return;
		} catch (Exception e) {
			return;
		}
		
		//Insert the file path of the local copy into the DB.
		ContentValues values = new ContentValues();
		String selection = DBAccessHelper.SONG_ID + "=" + "'" + songID + "'";

		String localCopyPath = null;
		try {
			localCopyPath = mContext.getCacheDir().getCanonicalPath() + "/music/" + mFileName;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		values.put(DBAccessHelper.LOCAL_COPY_PATH, localCopyPath);
		mApp.getDBAccessHelper()
			.getWritableDatabase()
			.update(DBAccessHelper.MUSIC_LIBRARY_TABLE, 
					values, 
					selection, 
					null);

    }

