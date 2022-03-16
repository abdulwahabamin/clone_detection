    @Override
	public View getView(int position, View convertView, ViewGroup parent) {
        final Cursor c = (Cursor) getItem(position);
	    SongsListViewHolder holder = null;

		if (convertView == null) {
			
			convertView = LayoutInflater.from(mContext).inflate(R.layout.music_library_editor_artists_layout, parent, false);
			holder = new SongsListViewHolder();
			holder.image = (ImageView) convertView.findViewById(R.id.artistThumbnailMusicLibraryEditor);
			holder.title = (TextView) convertView.findViewById(R.id.artistNameMusicLibraryEditor);
			holder.checkBox = (CheckBox) convertView.findViewById(R.id.artistCheckboxMusicLibraryEditor);

			convertView.setTag(holder);
		} else {
		    holder = (SongsListViewHolder) convertView.getTag();
		}
		
		final View finalConvertView = convertView;
		final String songId = c.getString(c.getColumnIndex(DBAccessHelper._ID));
		final String songArtist = c.getString(c.getColumnIndex(DBAccessHelper.SONG_ARTIST));
		final String songBlacklistStatus = c.getString(c.getColumnIndex(DBAccessHelper.BLACKLIST_STATUS));
		String songAlbumArtPath = c.getString(c.getColumnIndex(DBAccessHelper.SONG_ALBUM_ART_PATH));
		
		holder.title.setTypeface(TypefaceHelper.getTypeface(mContext, "RobotoCondensed-Light"));
		holder.title.setPaintFlags(holder.title.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);
		
		//Set the song title.
		holder.title.setText(songArtist);
        mApp.getImageLoader().displayImage(songAlbumArtPath, holder.image, BlacklistManagerActivity.displayImageOptions);

        //Check if the song's DB ID exists in the HashSet and set the appropriate checkbox status.
        try {
            if (BlacklistManagerActivity.songIdBlacklistStatusPair.get(songId).equals("TRUE")) {
            	holder.checkBox.setChecked(true);
            	convertView.setBackgroundColor(0xCCFF4444);
            } else {
            	holder.checkBox.setChecked(false);
            	convertView.setBackgroundColor(0x00000000);
            }
            
        } catch (Exception e) {
        	e.printStackTrace();
        }
        
        //Set a tag to the row that will attach the artist's name to it.
        convertView.setTag(R.string.artist, songArtist);
        
        holder.checkBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton checkbox, boolean isChecked) {
				
				if (isChecked==true) {
					
					//Only receive inputs by the user and ignore any system-made changes to the checkbox state.
					if (checkbox.isPressed()) {
						finalConvertView.setBackgroundColor(0xCCFF4444);
						AsyncBlacklistArtistTask task = new AsyncBlacklistArtistTask(songArtist);
						task.execute(new String[] {"ADD"});
					}
					
				} else if (isChecked==false) {
					
					//Only receive inputs by the user and ignore any system-made changes to the checkbox state.
					if (checkbox.isPressed()) {
						finalConvertView.setBackgroundColor(0x00000000);
						AsyncBlacklistArtistTask task = new AsyncBlacklistArtistTask(songArtist);
						task.execute(new String[] {"REMOVE"});
						
					}

				}
				
			}
			
        });
 
		return convertView;
	}

