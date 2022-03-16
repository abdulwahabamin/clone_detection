	@Override
	public void setupFragmentData() {
		 mAdapter = new PlaylistListAdapter(getActivity(), R.layout.dragsort_listview_items, null,
	                new String[] {}, new int[] {}, 0, mPlaylistId);

	     StringBuilder where = new StringBuilder();
	     where.append(AudioColumns.IS_MUSIC + "=1").append(" AND " + MediaColumns.TITLE + " != ''");
	     mWhere = where.toString(); 
	     mSortOrder = Playlists.Members.PLAY_ORDER;
         if(mPlaylistId == PLAYLIST_FAVORITES){
             long favorites_id = MusicUtils.getFavoritesId(getActivity());
        	 mProjection = new String[] {
                     Playlists.Members._ID, Playlists.Members.AUDIO_ID,
                     MediaColumns.TITLE, AudioColumns.ALBUM, AudioColumns.ARTIST
             };
        	 mUri = Playlists.Members.getContentUri(EXTERNAL, favorites_id);
         }
         else{
        	 mProjection = new String[] {
                     Playlists.Members._ID, Playlists.Members.AUDIO_ID,
                     MediaColumns.TITLE, AudioColumns.ALBUM, AudioColumns.ARTIST
             };
        	 mUri = Playlists.Members.getContentUri(EXTERNAL, mPlaylistId);        	 
         }
         mMediaIdColumn = Playlists.Members.AUDIO_ID;
         mType = TYPE_PLAYLIST;
         mFragmentGroupId = 90;
	}

