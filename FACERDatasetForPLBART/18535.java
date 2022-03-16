	    @Override
		public View getView(final int position, View convertView, ViewGroup parent) {
		    BlacklistManagerHolder holder = null;

			if (convertView == null) {
				convertView = LayoutInflater.from(mContext).inflate(R.layout.blacklist_manager_list_layout, parent, false);

				holder = new BlacklistManagerHolder();
				holder.blacklistedElementName = (TextView) convertView.findViewById(R.id.blacklist_manager_element_name);
				holder.blacklistedArtistName = (TextView) convertView.findViewById(R.id.blacklist_manager_artist);

				convertView.setTag(holder);
			} else {
			    holder = (BlacklistManagerHolder) convertView.getTag();
			}
			
			//Retrieve the UI element values based on the manager type.
			mCursor.moveToPosition(position);
			if (MANAGER_TYPE.equals("ARTISTS")) {
				elementName = mCursor.getString(mCursor.getColumnIndex(DBAccessHelper.SONG_ARTIST));
			} else if (MANAGER_TYPE.equals("ALBUMS")) {
				elementName = mCursor.getString(mCursor.getColumnIndex(DBAccessHelper.SONG_ALBUM));
				artistName = mCursor.getString(mCursor.getColumnIndex(DBAccessHelper.SONG_ARTIST));
			} else if (MANAGER_TYPE.equals("SONGS")) {
				elementName = mCursor.getString(mCursor.getColumnIndex(DBAccessHelper.SONG_TITLE));
				artistName = mCursor.getString(mCursor.getColumnIndex(DBAccessHelper.SONG_ARTIST));
			} else if (MANAGER_TYPE.equals("PLAYLISTS")) {
				/*elementName = mCursor.getString(mCursor.getColumnIndex(DBAccessHelper.PLAYLIST_NAME));
				artistName = mCursor.getString(mCursor.getColumnIndex(DBAccessHelper.NUMBER_OF_SONGS));*/
			}

			//Set element name.
			holder.blacklistedElementName.setText(elementName);

			holder.blacklistedElementName.setTypeface(TypefaceHelper.getTypeface(mContext, "RobotoCondensed-Light"));
			holder.blacklistedElementName.setPaintFlags(holder.blacklistedElementName.getPaintFlags() | 
													    Paint.SUBPIXEL_TEXT_FLAG | 
													    Paint.ANTI_ALIAS_FLAG);
			
			//Hide the artist textview if we're not dealing with blacklisted albums, songs, or playlists.
	        if (MANAGER_TYPE.equals("ARTIST")) {
	        	holder.blacklistedArtistName.setVisibility(View.GONE);
	        } else {
	        	
				holder.blacklistedArtistName.setTypeface(TypefaceHelper.getTypeface(mContext, "RobotoCondensed-Light"));
				holder.blacklistedArtistName.setPaintFlags(holder.blacklistedArtistName.getPaintFlags() | 
														    Paint.SUBPIXEL_TEXT_FLAG | 
														    Paint.ANTI_ALIAS_FLAG);
				
				holder.blacklistedArtistName.setText(artistName);
				
	        }
			
			return convertView;
		}

