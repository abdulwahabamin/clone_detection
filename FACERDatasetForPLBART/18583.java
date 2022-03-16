		@Override
		protected String doInBackground(String... arg0) {

			//Create DB instances.
			DBAccessHelper dbHelper = new DBAccessHelper(mContext.getApplicationContext());
			
			for (i=0; i < songURIsList.size(); i++) {
				publishProgress(new String[] {});
				File file = null;
				try {
					file = new File(songURIsList.get(i));
				} catch (Exception e) {
					e.printStackTrace();
					continue;
				}
				AudioFile audioFile = null;
				
				try {
					audioFile = AudioFileIO.read(file);
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
				
				//Escape any rogue apostrophes.
				String uri = songURIsList.get(i);
				
				if (uri!=null) {
					if (uri.contains("'")) {
						uri = uri.replace("'", "''");
					}
					
				} else {
					continue;
				}

				Tag tag = audioFile.getTag();
				
				if (tag!=null) {
					String whereClause = DBAccessHelper.SONG_FILE_PATH + "=" + "'" + uri + "'";
					ContentValues values = new ContentValues();
					
					if (titleEdited==false) {
						//Don't do anything here. The user didn't change the title.
					} else {
						try {
							tag.setField(FieldKey.TITLE, songTitle);
						} catch (KeyNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (FieldDataInvalidException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (NoSuchElementException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						values.put(DBAccessHelper.SONG_TITLE, songTitle);
						
					}
					
					if (albumEdited==false) {
						//Don't do anything here. The user didn't change the album.
					} else {
						try {
							tag.setField(FieldKey.ALBUM, songAlbum);
						} catch (KeyNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (FieldDataInvalidException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (NoSuchElementException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						values.put(DBAccessHelper.SONG_ALBUM, songAlbum);
						
					}
					
					if (artistEdited==false) {
						//Don't do anything here. The user didn't change the artist.
					} else {
						try {
							tag.setField(FieldKey.ARTIST, songArtist);
						} catch (KeyNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (FieldDataInvalidException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (NoSuchElementException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						values.put(DBAccessHelper.SONG_ARTIST, songArtist);
						
					}
					
					if (albumArtistEdited==false) {
						//Don't do anything here. The user didn't change the album artist.
					} else {
						try {
							tag.setField(FieldKey.ALBUM_ARTIST, songAlbumArtist);
						} catch (KeyNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (FieldDataInvalidException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (NoSuchElementException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						values.put(DBAccessHelper.SONG_ALBUM_ARTIST, songAlbumArtist);
						
					}
					
					if (genreEdited==false) {
						//Don't do anything here. The user didn't change the genre.
					} else {
						try {
							tag.setField(FieldKey.GENRE, songComposer);
						} catch (KeyNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (FieldDataInvalidException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (NoSuchElementException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					
					if (producerEdited==false) {
						//Don't do anything here. The user didn't change the producer.
					} else {
						try {
							tag.setField(FieldKey.PRODUCER, songProducer);
						} catch (KeyNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (FieldDataInvalidException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (NoSuchElementException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					
					if (yearEdited==false) {
						//Don't do anything here. The user didn't change the year.
					} else {
						try {
							tag.setField(FieldKey.YEAR, songYear);
						} catch (KeyNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (FieldDataInvalidException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (NoSuchElementException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (NumberFormatException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						values.put(DBAccessHelper.SONG_YEAR, songYear);
						
					}
					
					if (trackEdited==false) {
						//Don't do anything here. The user didn't change the track number.
					} else {
						try {
							tag.setField(FieldKey.TRACK, songTrackNumber);
						} catch (KeyNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (FieldDataInvalidException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (NoSuchElementException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (NumberFormatException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						values.put(DBAccessHelper.SONG_TRACK_NUMBER, songTrackNumber);
						
					}
					
					try {
						tag.setField(FieldKey.TRACK_TOTAL, songTrackTotals);
					} catch (KeyNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (FieldDataInvalidException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NoSuchElementException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					if (commentEdited==false) {
						//Don't do anything here. The user didn't change the comments.
					} else {
						try {
							tag.setField(FieldKey.COMMENT, songComments);
						} catch (KeyNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (FieldDataInvalidException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (NoSuchElementException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					
					try {
						audioFile.commit();
					} catch (CannotWriteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					//Write the values to the DB.
					try {
						dbHelper.getWritableDatabase().update(DBAccessHelper.MUSIC_LIBRARY_TABLE, 
															  values, 
															  whereClause, 
															  null);

						dbHelper.close();
						dbHelper = null;
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				} else {
					Toast.makeText(mContext, R.string.unable_to_edit_artist_tags, Toast.LENGTH_SHORT).show();
				}
				
			}
			
			return null;
		}

