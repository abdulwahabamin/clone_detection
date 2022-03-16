    @Override
    protected Integer doInBackground(String... params) {
    	/************************************************************************************************
    	 * RETRIEVE THE HTTP SEARCH RESPONSE FROM ITUNES SERVERS.
    	 ************************************************************************************************/
    	
    	//First, we'll make a HTTP request to iTunes' servers with the album and artist name.
    	if (params.length==2) {
        	artist = params[0];
        	album = params[1];

        	//Create duplicate strings that will be filtered out for the URL.
        	urlArtist = artist;
        	urlAlbum = album;
        	
        	//Remove any unacceptable characters.
			if (urlArtist.contains("#")) {
				urlArtist = urlArtist.replace("#", "");
			}
			
			if (urlArtist.contains("$")) {
				urlArtist = urlArtist.replace("$", "");
			}
			
			if (urlArtist.contains("@")) {
				urlArtist = urlArtist.replace("@", "");
			}
			
			if (urlAlbum.contains("#")) {
				urlAlbum = urlAlbum.replace("#", "");
			}
			
			if (urlAlbum.contains("$")) {
				urlAlbum = urlAlbum.replace("$", "");
			}
			
			if (urlAlbum.contains("@")) {
				urlAlbum = urlAlbum.replace("@", "");
			}
			
			//Replace any spaces in the artist and album fields with "%20".
			if (urlArtist.contains(" ")) {
				urlArtist = urlArtist.replace(" ", "%20");
			}
			
			if (urlAlbum.contains(" ")) {
				urlAlbum = urlAlbum.replace(" ", "%20");
			}
        	
    	}
    	
    	//Construct the url for the HTTP request.
    	URL uri = null;
		try {
			uri = new URL("http://itunes.apple.com/search?term=" + urlArtist + "+" + urlAlbum + "&entity=album");
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return 1;
		}
    	
    	try {
	    	//Create a new HTTP connection.
	        HttpURLConnection urlConnection = (HttpURLConnection) uri.openConnection();
	        urlConnection.connect();
	
	        //Set the destination directory for the xml file.
	        File SDCardRoot = Environment.getExternalStorageDirectory();
	        file = new File(SDCardRoot, "albumArt.xml");
	
	        //Create the OuputStream that will be used to store the downloaded data into the file.
	        FileOutputStream fileOutput = new FileOutputStream(file);
	
	        //Create the InputStream that will read the data from the HTTP connection.
	        InputStream inputStream = urlConnection.getInputStream();
	        
	        //Total size of target file.
	        int totalSize = urlConnection.getContentLength();
	
	        //Temp variable that stores the number of downloaded bytes.
	        int downloadedSize = 0;
	
	        //Create a buffer to store the downloaded bytes.
	        byte[] buffer = new byte[1024];
	        int bufferLength = 0;

	        //Now read through the buffer and write the contents to the file.
	        while((bufferLength = inputStream.read(buffer)) > 0 ) {
	            fileOutput.write(buffer, 0, bufferLength);
	            downloadedSize += bufferLength;
	
	        }
	        
	        //Close the File Output Stream.
	        fileOutput.close();

    	} catch (MalformedURLException e) {
    		//TODO Auto-generated method stub
    		e.printStackTrace();
    		return 1;
    	} catch (IOException e) {
    		// TODO Auto-generated method stub
    		e.printStackTrace();
    		return 1;
    	}
    	
    	
    	//Create a File object that points to the downloaded file.
    	File phpSource = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/albumArt.xml");
    	String phpAsString = null;
		try {
			phpAsString = FileUtils.readFileToString(phpSource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 1;
		}
		
		//Extract the albumArt parameter from the PHP response.
		artworkURL = StringUtils.substringBetween(phpAsString, "\"artworkUrl100\":\"", "\",");
		if (artworkURL==null) {
			
			//Check and see if a lower resolution image available.
			artworkURL = StringUtils.substringBetween(phpAsString, "\"artworkUrl60\":\"", "\",");
			
			if (artworkURL==null) {
				URL_RETRIEVED = false;
				return 1;
			} else {
				//Replace "100x100" with "600x600" to retrieve larger album art images.
				artworkURL = artworkURL.replace("100x100", "600x600");
				URL_RETRIEVED = true;
			}
	    	
		} else {
			//Replace "100x100" with "600x600" to retrieve larger album art images.
			artworkURL = artworkURL.replace("100x100", "600x600");
			URL_RETRIEVED = true;
		}
		
		//Loop through the songs table and retrieve the data paths of all the songs (used to embed the artwork).

		//Replace any rogue apostrophes.
		if (album.contains("'")) {
			album = album.replace("'", "''");
		}
		
		if (artist.contains("'")) {
			artist = artist.replace("'", "''");
		}
		
		String selection = DBAccessHelper.SONG_ALBUM + "=" + "'" + album + "'" + " AND "
						 + DBAccessHelper.SONG_ARTIST + "=" + "'" + artist + "'";
		
		String[] projection = { DBAccessHelper._ID, 
								DBAccessHelper.SONG_FILE_PATH };
		
		Cursor cursor = mApp.getDBAccessHelper().getWritableDatabase().query(DBAccessHelper.MUSIC_LIBRARY_TABLE, 
											 								 projection, 
					 														 selection, 
					 														 null, 
					 														 null, 
					 														 null, 
					 														 null);
		
		if (cursor.getCount()!=0) {
			cursor.moveToFirst();
			dataURIsList.add(cursor.getString(1));
			
			while(cursor.moveToNext()) {
				dataURIsList.add(cursor.getString(1));
			}
			
		}
		
		cursor.close();
		
		if (URL_RETRIEVED==true) {
    		artworkBitmap = mApp.getImageLoader().loadImageSync(artworkURL);

	    	File artworkFile = new File(Environment.getExternalStorageDirectory() + "/artwork.jpg");
    		
	    	//Display the album art on the grid/listview so that the user knows that the download is complete.
	    	publishProgress();
	    	
	    	//Save the artwork.
	    	try {
	    		FileOutputStream out = new FileOutputStream(artworkFile);
	    	    artworkBitmap.compress(Bitmap.CompressFormat.JPEG, 90, out);
	    	    out.flush();
	    	    out.close();
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    		return 1;
	    	} finally {
		    	
	    		for (int i=0; i < dataURIsList.size(); i++) {
	    	       	
	    			if (dataURIsList.get(i)!=null) {
	    				
	    				File audioFile = new File(dataURIsList.get(i));
			    		AudioFile f = null;
			    		
						try {
							f = AudioFileIO.read(audioFile);
						} catch (CannotReadException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (TagException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ReadOnlyFileException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (InvalidAudioFrameException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						Tag tag = null;
						try {
							if (f!=null) {
								tag = f.getTag();
							} else {
								continue;
							}
							
						} catch (Exception e) {
							e.printStackTrace();
							continue;
						} 
			    		
			    		Artwork artwork = null;
						try {
							artwork = ArtworkFactory.createArtworkFromFile(artworkFile);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							setArtworkAsFile(artworkFile, dataURIsList.get(i));
							continue;
						} catch (Error e) {
							e.printStackTrace();
							setArtworkAsFile(artworkFile, dataURIsList.get(i));
							continue;
						}
						
						if (artwork!=null) {
							
				    		try {
								tag.setField(artwork);
							} catch (FieldDataInvalidException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								setArtworkAsFile(artworkFile, dataURIsList.get(i));
								continue;
							} catch (Exception e) {
								e.printStackTrace();
								setArtworkAsFile(artworkFile, dataURIsList.get(i));
								continue;
							} catch (Error e) {
								e.printStackTrace();
								setArtworkAsFile(artworkFile, dataURIsList.get(i));
								continue;
							}
							
						}

			    		try {
							f.commit();
						} catch (CannotWriteException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							setArtworkAsFile(artworkFile, dataURIsList.get(i));
							continue;
						} catch (Error e) {
							e.printStackTrace();
							setArtworkAsFile(artworkFile, dataURIsList.get(i));
							continue;
						}
			    		
			    		//Update the album art tag in Jams' database.
		    			ContentValues values = new ContentValues();
		    			String filePath = dataURIsList.get(i);
		    			filePath = filePath.replace("'", "''");
		    			String where = DBAccessHelper.SONG_FILE_PATH + "=" + "'" + filePath + "'";
		    			values.put(DBAccessHelper.SONG_ALBUM_ART_PATH, "byte://" + dataURIsList.get(i));
		    			
		    			mApp.getDBAccessHelper()
		    				.getWritableDatabase()
		    				.update(DBAccessHelper.MUSIC_LIBRARY_TABLE, values, where, null);
			    		
	    			} else {
	    				continue;
	    			}
	    			
	    		}
	    		
	    		//Refresh the memory/disk cache for the ImageLoader instance.
	    		try {
		    		mApp.getImageLoader().clearMemoryCache();
		    		mApp.getImageLoader().clearDiscCache();
	    		} catch (Exception e) {
	    			e.printStackTrace();
	    		}
	    		
	    		//Delete the temporary files once the artwork has been embedded.
	    		artworkFile.delete();
	    		file.delete();
	    		
	    	}
	    	
    	}
		
    	return 0;
    }

