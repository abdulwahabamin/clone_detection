    @Override
    protected Void doInBackground(String... params) {

    	//First, we'll go through all the songs in the music library DB and get their attributes.
    	dbHelper = new DBAccessHelper(mContext);
    	String selection = DBAccessHelper.SONG_SOURCE + "<>" + "'GOOGLE_PLAY_MUSIC'";
    	String[] projection = { DBAccessHelper._ID, 
    							DBAccessHelper.SONG_FILE_PATH,
    							DBAccessHelper.SONG_ALBUM,
    							DBAccessHelper.SONG_ARTIST, 
    							DBAccessHelper.SONG_TITLE };
    	
    	Cursor cursor = dbHelper.getWritableDatabase().query(DBAccessHelper.MUSIC_LIBRARY_TABLE, 
				    										 projection, 
				    										 selection, 
				    										 null, 
				    										 null, 
				    										 null, 
				    										 null);
    	
    	if (cursor.getCount()!=0) {
    		
    		cursor.moveToFirst();
    		dataURIsList.add(cursor.getString(1));
    		albumsList.add(cursor.getString(2));
    		artistsList.add(cursor.getString(3));
    		
    		while(cursor.moveToNext()) {
    			
    			dataURIsList.add(cursor.getString(1));
        		albumsList.add(cursor.getString(2));
        		artistsList.add(cursor.getString(3));
    		}
    		
    	} else {
    		//The user doesn't have any music so let's get outta here.
    		return null;
    	}
    	
    	pd.setMax(dataURIsList.size());
    	    	
    	//Now that we have the attributes of the songs, we'll go through them each and check for missing covers.
    	for (int i=0; i < dataURIsList.size(); i++) {
    		
    		try {
    			file = new File(dataURIsList.get(i));
    		} catch (Exception e) {
    			continue;
    		}

    		audioFile = null;
			try {
				audioFile = AudioFileIO.read(file);
			} catch (CannotReadException e2) {
				// TODO Auto-generated catch block
				continue;
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				continue;
			} catch (TagException e2) {
				// TODO Auto-generated catch block
				continue;
			} catch (ReadOnlyFileException e2) {
				// TODO Auto-generated catch block
				continue;
			} catch (InvalidAudioFrameException e2) {
				// TODO Auto-generated catch block
				continue;
			}
			
    		Tag tag = audioFile.getTag();
    		
	        //Set the destination directory for the xml file.
	        File SDCardRoot = Environment.getExternalStorageDirectory();
	        File xmlFile = new File(SDCardRoot,"albumArt.xml");
    		
	        if (tag!=null) {
	        	
    			String title = tag.getFirst(FieldKey.TITLE);
        		String checkingMessage = mContext.getResources().getString(R.string.checking_if)
        							   + " " 
        							   + title 
        							   + " " 
        							   + mContext.getResources().getString(R.string.has_album_art)
        							   + ".";
        		
        		currentProgress = currentProgress + 1;
	    		String[] checkingProgressParams = { checkingMessage, "" + currentProgress };
	    		publishProgress(checkingProgressParams);
	        	
	        	List<Artwork> artworkList = tag.getArtworkList();
	        	
	    		if (artworkList.size()==0) {

	    			//Since the file doesn't have any album artwork, we'll have to download it.
	    			//Get the artist and album name of the file we're working with.
	    			String artist = tag.getFirst(FieldKey.ARTIST);
	    			String album = tag.getFirst(FieldKey.ALBUM);
	    			
	    			//Update the progress dialog.
	    			String message = mContext.getResources().getString(R.string.downloading_artwork_for) + " " + title;
	    			String[] progressParams = { message, "" + currentProgress };
	    			publishProgress(progressParams);
	    			
	    			//Remove any unacceptable characters.
	    			if (artist.contains("#")) {
	    				artist = artist.replace("#", "");
	    			}
	    			
	    			if (artist.contains("$")) {
	    				artist = artist.replace("$", "");
	    			}
	    			
	    			if (artist.contains("@")) {
	    				artist = artist.replace("@", "");
	    			}
	    			
	    			if (album.contains("#")) {
	    				album = album.replace("#", "");
	    			}
	    			
	    			if (album.contains("$")) {
	    				album = album.replace("$", "");
	    			}
	    			
	    			if (album.contains("@")) {
	    				album = album.replace("@", "");
	    			}
	    			
	    			//Replace any spaces in the artist and album fields with "%20".
	    			if (artist.contains(" ")) {
	    				artist = artist.replace(" ", "%20");
	    			}
	    			
	    			if (album.contains(" ")) {
	    				album = album.replace(" ", "%20");
	    			}
	    			
	    	    	//Construct the url for the HTTP request.
	    	    	URL url = null;
	    			try {
	    				url = new URL("http://itunes.apple.com/search?term=" + artist + "+" + album + "&entity=album");
	    			} catch (MalformedURLException e1) {
	    				// TODO Auto-generated catch block
	    				continue;
	    			}
	    
	    			String xml = null;
	    	    	try {
	    	    		
	    		    	//Create a new HTTP connection.
	    		        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
	    		
	    		        urlConnection.connect();
	    		        
	    		        //Check if albumArt.xml already exists and delete it.
	    		        if (xmlFile.exists()) {
	    		        	xmlFile.delete();
	    		        }
	    		        
	    		        //Create the OuputStream that will be used to store the downloaded data into the file.
	    		        FileOutputStream fileOutput = new FileOutputStream(xmlFile);
	    		
	    		        //Create the InputStream that will read the data from the HTTP connection.
	    		        InputStream inputStream = urlConnection.getInputStream();
	    		        
	    		        //Total size of target file.
	    		        int totalSize = urlConnection.getContentLength();
	    		
	    		        //Temp variable that stores the number of downloaded bytes.
	    		        int downloadedSize = 0;
	    		
	    		        //Create a buffer to store the downloaded bytes.
	    		        buffer = new byte[1024];
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
	    	    		continue;
	    	    	} catch (IOException e) {
	    	    		// TODO Auto-generated method stub
	    	    		continue;
	    	    	}
	    	    	
	    	    	//Load the XML file into a String variable for local use.
	    	    	String xmlAsString = null;
	    			try {
	    				xmlAsString = FileUtils.readFileToString(xmlFile);
	    			} catch (IOException e) {
	    				// TODO Auto-generated catch block
	    				e.printStackTrace();
	    			}
	    			
	    			//Extract the albumArt parameter from the XML file.
	    			artworkURL = StringUtils.substringBetween(xmlAsString, "\"artworkUrl100\":\"", "\",");
	    	    	
	    			if (artworkURL==null) {
	    				
	    				//Check and see if a lower resolution image available.
	    				artworkURL = StringUtils.substringBetween(xmlAsString, "\"artworkUrl60\":\"", "\",");
	    				
	    				if (artworkURL==null) {
	    					//Can't do anything about that here.
	    				} else {
	    					//Replace "100x100" with "600x600" to retrieve larger album art images.
	    					artworkURL = artworkURL.replace("100x100", "600x600");
	    				}
	    		    	
	    			} else {
	    				//Replace "100x100" with "600x600" to retrieve larger album art images.
	    				artworkURL = artworkURL.replace("100x100", "600x600");
	    			}
	    			
	    			//If no URL has been found, there's no point in continuing.
	    			if (artworkURL!=null) {
	    				
	        			artworkBitmap = null;
	        			artworkBitmap = mApp.getImageLoader().loadImageSync(artworkURL);
	        			
	    	    		File artworkFile = new File(Environment.getExternalStorageDirectory() + "/artwork.jpg");
	        			
	        	    	//Save the artwork.
	        	    	try {
	        	    		
	        	    		FileOutputStream out = new FileOutputStream(artworkFile);
	     	    	       	artworkBitmap.compress(Bitmap.CompressFormat.JPEG, 90, out);
	    					
	        	    	} catch (Exception e) {
	        	    		e.printStackTrace();
	        	    	} finally {
	        	    		
	        	    		Artwork artwork = null;
	    					try {
	    						artwork = ArtworkFactory.createArtworkFromFile(artworkFile);
	    					} catch (IOException e) {
	    						// TODO Auto-generated catch block
	    						setArtworkAsFile(artworkFile, dataURIsList.get(i));
								continue;
	    					} catch (ArrayIndexOutOfBoundsException e) {
	    						// TODO Auto-generated catch block
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
	    					
	    					if (artwork!=null) {
	    						
	        		    		try {
	        						//Remove the current artwork field and recreate it.
	        		    			tag.deleteArtworkField();
	        		    			tag.addField(artwork);
	        					} catch (Exception e) {
	        						// TODO Auto-generated catch block
	        						setArtworkAsFile(artworkFile, dataURIsList.get(i));
									continue;
	        					} catch (Error e) {
	    							e.printStackTrace();
	    							setArtworkAsFile(artworkFile, dataURIsList.get(i));
	    							continue;
	    						}
	        		    		
	        		    		try {
	        						audioFile.commit();
	        					} catch (CannotWriteException e) {
	        						// TODO Auto-generated catch block
	        						setArtworkAsFile(artworkFile, dataURIsList.get(i));
									continue;
	        					} catch (Error e) {
	    							e.printStackTrace();
	    							setArtworkAsFile(artworkFile, dataURIsList.get(i));
	    							continue;
	    						}
	    						
	    					}
	    					
	            	    	//Delete the temporary files that we stored during the fetching process.
	    		    		if (artworkFile.exists()) {
	    		    			artworkFile.delete();
	    		    		}
	    		    		
	    		    		if (xmlFile.exists()) {
	    		    			xmlFile.delete();
	    		    		}
	    	    	    	
	    		    		//Set the files to null to help clean up memory.
	    		    		artworkBitmap = null;
	    		    		audioFile = null;
	    		    		tag = null;
	    		    		xmlFile = null;
	    		    		artworkFile = null;
	    		    		
	    	    		}

	    			}

	    		}
	        	
	        }
    		
    	}
    	
    	audioFile = null;
    	file = null;
    	//System.gc();
    	
    	return null;
	    
    }

