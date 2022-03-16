    @Override
	public View getView(int position, View convertView, ViewGroup parent) {
        final Cursor c = (Cursor) getItem(position);
	    SongsListViewHolder holder = null;

		if (convertView == null) {
			
			convertView = LayoutInflater.from(mContext).inflate(R.layout.music_library_editor_songs_layout, parent, false);
			holder = new SongsListViewHolder();
			holder.image = (ImageView) convertView.findViewById(R.id.songThumbnailMusicLibraryEditor);
			holder.title = (TextView) convertView.findViewById(R.id.songNameMusicLibraryEditor);
			holder.checkBox = (CheckBox) convertView.findViewById(R.id.songCheckboxMusicLibraryEditor);
			holder.subText = (TextView) convertView.findViewById(R.id.artistNameSongListView);

			convertView.setTag(holder);
		} else {
		    holder = (SongsListViewHolder) convertView.getTag();
		}
		
		final View finalConvertView = convertView;
		final String songId = c.getString(c.getColumnIndex(DBAccessHelper._ID));
		final String songTitle = c.getString(c.getColumnIndex(DBAccessHelper.SONG_TITLE));
		final String songFilePath = c.getString(c.getColumnIndex(DBAccessHelper.SONG_FILE_PATH));
		String songAlbumArtPath = c.getString(c.getColumnIndex(DBAccessHelper.SONG_ALBUM_ART_PATH));
		String songArtist = c.getString(c.getColumnIndex(DBAccessHelper.SONG_ARTIST));
		String songBlacklistStatus = c.getString(c.getColumnIndex(DBAccessHelper.BLACKLIST_STATUS));
		
		holder.title.setTypeface(TypefaceHelper.getTypeface(mContext, "RobotoCondensed-Light"));
		holder.title.setPaintFlags(holder.title.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);
		
		holder.subText.setTypeface(TypefaceHelper.getTypeface(mContext, "RobotoCondensed-Light"));
		holder.subText.setPaintFlags(holder.subText.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);
		
		//Set the songID as the view's tag.
		convertView.setTag(R.string.song_id, songId);
		convertView.setTag(R.string.song_file_path, songFilePath);
		
		//Set the song title.
		holder.title.setText(songTitle);
		holder.subText.setText(songArtist);
        mApp.getImageLoader().displayImage(songAlbumArtPath, holder.image, BlacklistManagerActivity.displayImageOptions);

        //Check if the song's DB ID exists in the HashSet and set the appropriate checkbox status.
        if (BlacklistManagerActivity.songIdBlacklistStatusPair.get(songId).equals("TRUE")) {
        	convertView.setBackgroundColor(0xCCFF4444);
        	holder.checkBox.setChecked(true);
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
						finalConvertView.setBackgroundColor(0xCCFF4444);
						BlacklistManagerActivity.songIdBlacklistStatusPair.put(songId, true);
					}
					
				} else if (isChecked==false) {
					
					//Only receive inputs by the user and ignore any system-made changes to the checkbox state.
					if (checkbox.isPressed()) {
						finalConvertView.setBackgroundColor(0x000000);
						BlacklistManagerActivity.songIdBlacklistStatusPair.put(songId, false);
					}

				}

			}
			
        });
 
		return convertView;
	}

