        @Override
        public void onClick(View v) {
            if(albumClickListener != null) {
                albumClickListener.onAlbumClicked(albumCursor, position);
            }
        }

