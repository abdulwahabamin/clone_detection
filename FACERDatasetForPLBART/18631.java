        @Override
        public void drop(int from, int to) {
            if (from!=to) {
                int fromItem = mListViewAdapter.getItem(from);
                int toItem = mListViewAdapter.getItem(to);
                mListViewAdapter.remove(fromItem);
                mListViewAdapter.insert(fromItem, to);

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

                } else if (from < mApp.getService().getCurrentSongIndex() && to==mApp.getService().getCurrentSongIndex()) {
                	/* One of the previous songs was moved to the current song's position (visually speaking,
                	 * the new song will look like it was placed right after the current song.
                	 */
                    mApp.getService().decrementCurrentSongIndex();
                    mApp.getService().decrementEnqueueReorderScalar();

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

            //Fire a broadcast that notifies all listeners that the current queue order has changed.
            String[] updateFlags = { Common.NEW_QUEUE_ORDER };
            String[] flagValues = { "" };
            mApp.broadcastUpdateUICommand(updateFlags, flagValues);

        }

