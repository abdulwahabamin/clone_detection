        @Override
        public void onReceive(Context context, Intent intent) {
            if (mListView != null) {
                mTrackAdapter.notifyDataSetChanged();
                // Scroll to the currently playing track in the queue
                if (mPlaylistId == PLAYLIST_QUEUE)
                    mListView.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mListView.setSelection(MusicUtils.getQueuePosition());
                        }
                    }, 100);
            }
        }

