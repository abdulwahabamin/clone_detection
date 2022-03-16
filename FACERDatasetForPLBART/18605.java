    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
    	
    	SongsListViewHolder holder = null;
		if (convertView == null) {	
			convertView = LayoutInflater.from(mContext).inflate(R.layout.sliding_menu_browsers_layout, parent, false);
			holder = new SongsListViewHolder();
			holder.title = (TextView) convertView.findViewById(R.id.nav_drawer_item_title);
			convertView.setTag(holder);
		} else {
		    holder = (SongsListViewHolder) convertView.getTag();
		}

		holder.title.setTypeface(TypefaceHelper.getTypeface(mContext, "Roboto-Regular"));
		holder.title.setText(mTitlesList.get(position));
		holder.title.setTextColor(UIElementsHelper.getThemeBasedTextColor(mContext));
		
		//Highlight the current browser.
		int[] colors = UIElementsHelper.getQuickScrollColors(mContext);
		if (MainActivity.mCurrentFragmentId==Common.ARTISTS_FRAGMENT && 
			mTitlesList.get(position).equals(mContext.getResources().getString(R.string.artists))) {
			holder.title.setTextColor(colors[0]);
		} else if (MainActivity.mCurrentFragmentId==Common.ALBUM_ARTISTS_FRAGMENT &&
				   mTitlesList.get(position).equals(mContext.getResources().getString(R.string.album_artists))) {
			holder.title.setTextColor(colors[0]);
		} else if (MainActivity.mCurrentFragmentId==Common.ALBUMS_FRAGMENT &&
				   mTitlesList.get(position).equals(mContext.getResources().getString(R.string.albums))) {
			holder.title.setTextColor(colors[0]);
		} else if (MainActivity.mCurrentFragmentId==Common.SONGS_FRAGMENT &&
				   mTitlesList.get(position).equals(mContext.getResources().getString(R.string.songs))) {
			holder.title.setTextColor(colors[0]);
		} else if (MainActivity.mCurrentFragmentId==Common.PLAYLISTS_FRAGMENT &&
				   mTitlesList.get(position).equals(mContext.getResources().getString(R.string.playlists))) {
			holder.title.setTextColor(colors[0]);
		} else if (MainActivity.mCurrentFragmentId==Common.GENRES_FRAGMENT &&
				   mTitlesList.get(position).equals(mContext.getResources().getString(R.string.genres))) {
			holder.title.setTextColor(colors[0]);
		} else if (MainActivity.mCurrentFragmentId==Common.FOLDERS_FRAGMENT &&
				   mTitlesList.get(position).equals(mContext.getResources().getString(R.string.folders))) {
			holder.title.setTextColor(colors[0]);
		}
		
		return convertView;

	}

