        @Override
        public void remove(int which) {
        	CALLED_FROM_REMOVE = true;
        	//Stop the service if we just removed the last (and only) song.
        	if (mApp.getService().getPlaybackIndecesList().size()==1) {
        		getActivity().stopService(new Intent(getActivity(), AudioPlaybackService.class));
        		return;
        	}
        	
            //If the song that was removed is the next song, reload it.
            if (mApp.getService().getPlaybackIndecesList().size() > (mApp.getService().getCurrentSongIndex()+1)) {
                if (nowPlayingQueueListViewAdapter.getItem(which)==mApp.getService().getPlaybackIndecesList().get(mApp.getService().getCurrentSongIndex()+1)) {

                	//Check which mediaPlayer is currently playing, and prepare the other mediaPlayer.
                	mApp.getService().prepareAlternateMediaPlayer();
                	
                } else if (nowPlayingQueueListViewAdapter.getItem(which)==mApp.getService().getPlaybackIndecesList().get(mApp.getService().getCurrentSongIndex())) {
                	mApp.getService().incrementCurrentSongIndex();
                	mApp.getService().prepareMediaPlayer(mApp.getService().getCurrentSongIndex());
                	mApp.getService().decrementCurrentSongIndex();
                } else if (nowPlayingQueueListViewAdapter.getItem(which) < mApp.getService().getPlaybackIndecesList().get(mApp.getService().getCurrentSongIndex())) {
                	mApp.getService().decrementCurrentSongIndex();
                }
                
            } else {
            	//Check which mediaPlayer is currently playing, and prepare the other mediaPlayer.
            	mApp.getService().prepareAlternateMediaPlayer();
            	
            }
            
            //Remove the item from the adapter.
            nowPlayingQueueListViewAdapter.remove(nowPlayingQueueListViewAdapter.getItem(which));
            
        }

