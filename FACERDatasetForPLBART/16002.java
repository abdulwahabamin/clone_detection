        void bindView(Cursor songCursor, int position) {
            this.position = position;
            songCursor.moveToPosition(position);

            bindView(Song.toSong(songCursor), position);
        }

