		@Override
		public void onItemClick(AdapterView<?> arg0, View view, int index, long id) {
            switch (mFragmentId) {
                case Common.SONGS_FRAGMENT:
                    mApp.getPlaybackKickstarter()
                        .initPlayback(mContext,
                                      mQuerySelection,
                                      Common.PLAY_ALL_SONGS,
                                      index,
                                      true,
                                      false);
                    break;
                case Common.PLAYLISTS_FRAGMENT:
                    mApp.getPlaybackKickstarter()
                            .initPlayback(mContext,
                                    mQuerySelection,
                                    Common.PLAY_ALL_IN_PLAYLIST,
                                    index,
                                    true,
                                    false);
                    break;
            }
			
		}

