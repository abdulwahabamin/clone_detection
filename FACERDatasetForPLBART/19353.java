        @Override
        public void drop(int from, int to) {
            if (from!=to) {
                int fromItem = nowPlayingQueueListViewAdapter.getItem(from);
                int toItem = nowPlayingQueueListViewAdapter.getItem(to);
                nowPlayingQueueListViewAdapter.remove(fromItem);
                nowPlayingQueueListViewAdapter.insert(fromItem, to);
                
                //If the current song was reordered, change currentSongIndex and update the next song.
                if (from==mApp.getService().getCurrentSongIndex()) {
                	mApp.getService().setCurrentSongIndex(to);
                	
                	//Check which mediaPlayer is currently playing, and prepare the other mediaPlayer.
                	mApp.getService().prepareAlternateMediaPlayer();
                	return;
                	
                } else if (from > mApp.getService().getCurrentSongIndex() && to <= mApp.getService().getCurrentSongIndex()) {
                	//One of the next songs was moved to a position before the current song. Move currentSongIndex forward by 1.
                	mApp.getService().incrementCurrentSongIndex();
                	mApp.getService().incrementEnqueueReorderScalar();
                	
                	//Check which mediaPlayer is currently playing, and prepare the other mediaPlayer.
                	mApp.getService().prepareAlternateMediaPlayer();
                	return;
                	
                } else if (from < mApp.getService().getCurrentSongIndex() && to > mApp.getService().getCurrentSongIndex()) {
                	//One of the previous songs was moved to a position after the current song. Move currentSongIndex back by 1.
                	mApp.getService().decrementCurrentSongIndex();
                	mApp.getService().decrementEnqueueReorderScalar();
                	
                	//Check which mediaPlayer is currently playing, and prepare the other mediaPlayer.
                	mApp.getService().prepareAlternateMediaPlayer();
                	return;
                	
                }
                
                //If the next song was reordered, reload it with the new index.
                if (mApp.getService().getPlaybackIndecesList().size() > (mApp.getService().getCurrentSongIndex()+1)) {
                    if (fromItem==mApp.getService().getPlaybackIndecesList().get(mApp.getService().getCurrentSongIndex()+1) || 
                    	toItem==mApp.getService().getPlaybackIndecesList().get(mApp.getService().getCurrentSongIndex()+1)) {
                    	
                    	//Check which mediaPlayer is currently playing, and prepare the other mediaPlayer.
                    	mApp.getService().prepareAlternateMediaPlayer();
                    	
                    }
                    
                } else {
                	//Check which mediaPlayer is currently playing, and prepare the other mediaPlayer.
                	mApp.getService().prepareAlternateMediaPlayer();
                	
                }

            }
            
        }

