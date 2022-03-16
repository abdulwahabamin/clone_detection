        @Override
        public void remove(int which) {

            //Stop the service if we just removed the last (and only) song.
            if (mApp.getService().getPlaybackIndecesList().size()==1) {
                mContext.stopService(new Intent(mContext, AudioPlaybackService.class));
                return;
            }

            //If the song that was removed is the next song, reload it.
            if (mApp.getService().getPlaybackIndecesList().size() > (mApp.getService().getCurrentSongIndex()+1)) {
                if (mListViewAdapter.getItem(which)==mApp.getService().getPlaybackIndecesList().get(mApp.getService().getCurrentSongIndex()+1)) {

                    //Check which mediaPlayer is currently playing, and prepare the other mediaPlayer.
                    mApp.getService().prepareAlternateMediaPlayer();

                } else if (mListViewAdapter.getItem(which)==mApp.getService().getPlaybackIndecesList().get(mApp.getService().getCurrentSongIndex())) {
                    mApp.getService().incrementCurrentSongIndex();
                    mApp.getService().prepareMediaPlayer(mApp.getService().getCurrentSongIndex());
                    mApp.getService().decrementCurrentSongIndex();
                } else if (mListViewAdapter.getItem(which) < mApp.getService().getPlaybackIndecesList().get(mApp.getService().getCurrentSongIndex())) {
                    mApp.getService().decrementCurrentSongIndex();
                }

            } else if (which==(mApp.getService().getPlaybackIndecesList().size()-1) &&
                    mApp.getService().getCurrentSongIndex()==(mApp.getService().getPlaybackIndecesList().size()-1)) {
                //The current song was the last one and it was removed. Time to back up to the previous song.
                mApp.getService().decrementCurrentSongIndex();
                mApp.getService().prepareMediaPlayer(mApp.getService().getCurrentSongIndex());
            } else {
                //Check which mediaPlayer is currently playing, and prepare the other mediaPlayer.
                mApp.getService().prepareAlternateMediaPlayer();

            }

            //Remove the item from the adapter.
            mListViewAdapter.remove(mListViewAdapter.getItem(which));

        }

