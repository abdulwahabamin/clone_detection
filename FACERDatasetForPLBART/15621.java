	@Override
	public void setupFragmentData() {
		mAdapter = new NowPlayingAdapter(getActivity(), R.layout.dragsort_listview_items, null,
		        							new String[] {}, new int[] {}, 0);
		mProjection = new String[] {
		            BaseColumns._ID, MediaColumns.TITLE, AudioColumns.ALBUM, AudioColumns.ARTIST
		    };
		mSortOrder = Audio.Media.DEFAULT_SORT_ORDER;
		mUri = Audio.Media.EXTERNAL_CONTENT_URI;
		StringBuilder where = new StringBuilder();
		long[] mNowPlaying = MusicUtils.getQueue();
		if (mNowPlaying.length <= 0){
			where.append(AudioColumns.IS_MUSIC + "=1").append(" AND " + MediaColumns.TITLE + " != ''");
		}
		else{
			where.append(BaseColumns._ID + " IN (");
			for (long queue_id : mNowPlaying) {
			    where.append(queue_id + ",");
			}
			where.deleteCharAt(where.length() - 1);
			where.append(")");			
		}
		mWhere = where.toString();
        mMediaIdColumn = BaseColumns._ID;
        mType = TYPE_SONG;
        mFragmentGroupId = 91;
	}

