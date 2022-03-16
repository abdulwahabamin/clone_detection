        @Override
        public void onClick(View v) {
            if (source == Source.CURSOR) {
                songClickListener.onSongClicked(songCursor, position);
            } else {
                songQueueClickListener.onSongClicked(songList, position);
            }
        }

