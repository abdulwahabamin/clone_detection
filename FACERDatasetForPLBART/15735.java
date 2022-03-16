    private void changeTrackInfo(Song song) {
        ((TextView)findViewById(R.id.peek_player_track_title)).setText(song.getTitle());
        ((TextView)findViewById(R.id.peek_player_track_artist)).setText(song.getArtist());

        if(song.getAlbumArt() != null && !song.getAlbumArt().equals("")) {
            ((ImageView) findViewById(R.id.peek_player_album_art)).setImageDrawable(
                    Drawable.createFromPath(song.getAlbumArt()));
        } else {
            ((ImageView) findViewById(R.id.peek_player_album_art)).
                    setImageResource(R.drawable.ic_album_white_24dp);
        }
    }

