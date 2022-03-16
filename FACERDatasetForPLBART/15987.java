        void bindView(Cursor albumCursor, int position) {
            this.position = position;
            albumCursor.moveToPosition(position);

            String string = Library.getString(albumCursor, AlbumTable.Columns.ALBUM_NAME);
            if(string.equals("<unknown>")) {
                albumName.setText("Unknown Album");
            } else {
                albumName.setText(string);
            }

            string = Library.getString(albumCursor, AlbumTable.Columns.ARTIST);
            if(string.equals("<unknown>")) {
                artistName.setText("Unknown Artist");
            } else {
                artistName.setText(string);
            }

            String path = Library.getString(albumCursor, AlbumTable.Columns.ALBUM_ART);

            albumArt.setImageResource(R.drawable.ic_album_white_24dp);

            fetchCover(path, albumCursor);
        }

