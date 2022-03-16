        void bindView(Song song, int position) {
            this.position = position;
            this.song = song;

            trackAlbum.setText(song.getAlbum());
            String string = song.getArtist();
            if(!string.equals("<unknown>"))
                trackArtist.setText(string);
            else trackArtist.setText(R.string.track_artist);
            trackTitle.setText(song.getTitle());

            trackAlbumArt.setImageResource(R.drawable.ic_album_white_24dp);

            fetchCover();
        }

