    @Override
	public View getView(int position, View convertView, ViewGroup parent) {
        final Cursor c = (Cursor) getItem(position);
	    SongsListViewHolder holder = null;

		if (convertView == null) {
			
			convertView = LayoutInflater.from(mContext).inflate(R.layout.music_library_editor_albums_layout, parent, false);
			holder = new SongsListViewHolder();
			holder.image = (ImageView) convertView.findViewById(R.id.albumThumbnailMusicLibraryEditor);
			holder.title = (TextView) convertView.findViewById(R.id.albumNameMusicLibraryEditor);
			holder.checkBox = (CheckBox) convertView.findViewById(R.id.albumCheckboxMusicLibraryEditor);
			holder.subText = (TextView) convertView.findViewById(R.id.albumArtistNameMusicLibraryEditor);

			convertView.setTag(holder);
		} else {
		    holder = (SongsListViewHolder) convertView.getTag();
		}
		
		final View finalConvertView = convertView;
		final String songId = c.getString(c.getColumnIndex(DBAccessHelper._ID));
		final String songArtist = c.getString(c.getColumnIndex(DBAccessHelper.SONG_ARTIST));
		final String songAlbum = c.getString(c.getColumnIndex(DBAccessHelper.SONG_ALBUM));
		final String songAlbumArtPath = c.getString(c.getColumnIndex(DBAccessHelper.SONG_ALBUM_ART_PATH));
		
		//Set the album's name and artist as the row's tag.
		convertView.setTag(R.string.album, songAlbum);
		convertView.setTag(R.string.artist, songArtist);
		
		holder.title.setTypeface(TypefaceHelper.getTypeface(mContext, "RobotoCondensed-Light"));
		holder.title.setPaintFlags(holder.title.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);
		holder.subText.setTypeface(TypefaceHelper.getTypeface(mContext, "RobotoCondensed-Light"));
		holder.subText.setPaintFlags(holder.subText.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);
		
		//Set the song title.
		holder.title.setText(songAlbum);
		holder.subText.setText(songArtist);
        mApp.getImageLoader().displayImage(songAlbumArtPath, holder.image, MusicLibraryEditorActivity.displayImageOptions);

        //Check if the song's DB ID exists in the HashSet and set the appropriate checkbox status.
        if (MusicLibraryEditorActivity.songDBIdsList.contains(songId)) {
        	holder.checkBox.setChecked(true);
        	convertView.setBackgroundColor(0xCC0099CC);
        } else {
        	convertView.setBackgroundColor(0x00000000);
        	holder.checkBox.setChecked(false);
        }
        
        holder.checkBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton checkbox, boolean isChecked) {
				
				if (isChecked==true) {
					
					//Only receive inputs by the user and ignore any system-made changes to the checkbox state.
					if (checkbox.isPressed()) {
						finalConvertView.setBackgroundColor(0xCC0099CC);
						AsyncGetAlbumSongIds task = new AsyncGetAlbumSongIds(songAlbum, songArtist);
						task.execute(new String[] {"ADD"});
					}
					
				} else if (isChecked==false) {
					
					//Only receive inputs by the user and ignore any system-made changes to the checkbox state.
					if (checkbox.isPressed()) {
						finalConvertView.setBackgroundColor(0x00000000);
						AsyncGetAlbumSongIds task = new AsyncGetAlbumSongIds(songAlbum, songArtist);
						task.execute(new String[] {"REMOVE"});
						
					}

				}
				
			}
			
        });
 
		return convertView;
	}

