    private void changeSongInfo(Song song, View rootView) {
        TextView textView = (TextView) (rootView.findViewById(R.id.player_track_title));
        textView.setText(song.getTitle());
        textView = (TextView) (rootView.findViewById(R.id.player_track_album));
        textView.setText(song.getAlbum());
        textView = (TextView) (rootView.findViewById(R.id.player_track_artist));
        textView.setText(song.getArtist());

        String albumArt = song.getAlbumArt();
        if(albumArt!=null)
            albumArtView.setImageDrawable(Drawable.createFromPath(albumArt));
        else albumArtView.setImageResource(R.drawable.ic_album_white_24dp);
    }

