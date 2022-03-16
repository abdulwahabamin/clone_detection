    public View getView(final int position, View convertView, ViewGroup parent){
    	
    	NowPlayingQueueListViewHolder holder = null;
		if (convertView == null) {
			convertView = LayoutInflater.from(mContext).inflate(R.layout.playlist_flipped_listview_layout, parent, false);
			holder = new NowPlayingQueueListViewHolder();
			holder.songTitleText = (TextView) convertView.findViewById(R.id.playlists_flipped_song);
			holder.artistText = (TextView) convertView.findViewById(R.id.playlists_flipped_artist);
			holder.removeSong = (ImageView) convertView.findViewById(R.id.remove_song_from_queue);
			
			holder.songTitleText.setTextColor(UIElementsHelper.getThemeBasedTextColor(mContext));
			holder.songTitleText.setTypeface(TypefaceHelper.getTypeface(mContext, "Roboto-Light"));
			holder.songTitleText.setPaintFlags(holder.songTitleText.getPaintFlags()
											   | Paint.ANTI_ALIAS_FLAG
											   | Paint.SUBPIXEL_TEXT_FLAG);		
			
			holder.artistText.setTextColor(UIElementsHelper.getSmallTextColor(mContext));
			holder.artistText.setTypeface(TypefaceHelper.getTypeface(mContext, "RobotoCondensed-Regular"));
			holder.artistText.setPaintFlags(holder.artistText.getPaintFlags()
											| Paint.ANTI_ALIAS_FLAG
											| Paint.SUBPIXEL_TEXT_FLAG);
			
			convertView.setTag(holder);
		} else {
		    holder = (NowPlayingQueueListViewHolder) convertView.getTag();
		}
		
		//Move the local cursor to the correct position.
		mApp.getService().getCursor().moveToPosition(mPlaybackIndecesList.get(position));
		
		//Get the song's parameters.
		String songTitle;
		String songFilePath;
		String songArtist;
		try {
			songTitle = mApp.getService().getCursor().getString(mApp.getService().getCursor().getColumnIndex(DBAccessHelper.SONG_TITLE));
			songFilePath = mApp.getService().getCursor().getString(mApp.getService().getCursor().getColumnIndex(DBAccessHelper.SONG_FILE_PATH));
			songArtist = mApp.getService().getCursor().getString(mApp.getService().getCursor().getColumnIndex(DBAccessHelper.SONG_ARTIST));
		} catch (Exception e) {
			/* If an exception is raised, the user is probably playing from the folders and the cursor hasn't been completely built yet.
			 * Just use temporary placeholders for now and the ListView will automatically refresh itself once the cursor is fully built. */
			songTitle = "Loading...";
			songFilePath = "";
			songArtist = "";
		}
		
		//Set the view tags.
		convertView.setTag(R.string.title, songTitle);
		convertView.setTag(R.string.song_file_path, songFilePath);
		convertView.setTag(R.string.artist, songArtist);
		
		holder.songTitleText.setText(songTitle);
		holder.artistText.setText(songArtist);
		
		//Apply the card layout's background based on the color theme.
		if (position==mApp.getService().getCurrentSongIndex()) {
			int[] colors = UIElementsHelper.getQuickScrollColors(mContext);
			convertView.setBackgroundColor(colors[0]);
			holder.songTitleText.setTextColor(colors[2]);
			holder.artistText.setTextColor(colors[2]);
			holder.removeSong.setImageResource(R.drawable.cross_light);
			
		} else if (mCurrentTheme.equals("LIGHT_CARDS_THEME") ||
				   mCurrentTheme.equals("LIGHT_THEME")) {
			convertView.setBackgroundColor(0xFFFFFFFF);
			holder.songTitleText.setTextColor(UIElementsHelper.getThemeBasedTextColor(mContext));
			holder.artistText.setTextColor(UIElementsHelper.getSmallTextColor(mContext));
			holder.removeSong.setImageResource(R.drawable.cross);
			
		} else if (mCurrentTheme.equals("DARK_CARDS_THEME") ||
				   mCurrentTheme.equals("DARK_THEME")) {
			convertView.setBackgroundColor(0xFF191919);
			holder.songTitleText.setTextColor(UIElementsHelper.getThemeBasedTextColor(mContext));
			holder.artistText.setTextColor(UIElementsHelper.getSmallTextColor(mContext));
			holder.removeSong.setImageResource(R.drawable.cross_light);
			
		}
		
		return convertView;

	}

