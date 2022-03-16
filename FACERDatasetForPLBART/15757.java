        @Override
        public void showQueue() {
            SongsFragment songsFragment = SongsFragment.newInstance(playQueue.getQueue(),
                    new SongAdapter.SongQueueClickListener() {
                        @Override
                        public void onSongClicked(ArrayList<Song> songList, int position) {
                            returnToPlayer(position);
                        }
                    });

            playerFragmentSwitcher.switchTo(songsFragment, SONGS_FRAGMENT_TAG);
        }

