		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			
			pd = new ProgressDialog(mActivity);
			pd.setTitle(R.string.saving_artist_info);
			pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			pd.setIndeterminate(false);
			pd.setMax(songURIsList.size());
			pd.show();
			
			//Retrieve the strings from the EditText fields.
			if (titleEdited) {
				songTitle = titleEditText.getText().toString();	
				songTitle = songTitle.replace("'", "''");
			} else {
				songTitle = null;
			}
			
			if (artistEdited) {
				songArtist = artistEditText.getText().toString();
				songArtist = songArtist.replace("'", "''");
			} else {
				songArtist = null;
			}
			
			if (albumEdited) {
				songAlbum = albumEditText.getText().toString();
				songAlbum = songAlbum.replace("'", "''");
			} else {
				songAlbum = null;
			}
			
			if (albumArtistEdited) {
				songAlbumArtist = albumArtistEditText.getText().toString();
				songAlbumArtist = songAlbumArtist.replace("'", "''");
			} else {
				songAlbumArtist = null;
			}
			
			if (genreEdited) {
				songComposer = genreEditText.getText().toString();
				songComposer = songComposer.replace("'", "''");
			} else {
				songComposer = null;
			}
			
			if (producerEdited) {
				songProducer = producerEditText.getText().toString();
				songProducer = songProducer.replace("'", "''");
			} else {
				songProducer = null;
			}
			
			if (trackEdited) {
				songTrackNumber = trackEditText.getText().toString();
				songTrackNumber = songTrackNumber.replace("'", "''");
				songTrackTotals = trackTotalEditText.getText().toString();
				songTrackTotals = songTrackTotals.replace("'", "''");
			} else {
				songTrackNumber = null;
				songTrackTotals = null;
			}
			
			if (commentEdited) {
				songComments = commentsEditText.getText().toString();
				songComments = songComments.replace("'", "''");
			} else {
				songComments = null;
			}
			
			if (yearEdited) {
				songYear = yearEditText.getText().toString();
				songYear = songYear.replace("'", "''");
			} else {
				songYear = null;
			}
			
		}

