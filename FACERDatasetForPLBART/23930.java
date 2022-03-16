    @Override
    protected CharSequence doInBackground(Uri... params) {
        Uri playlistUri = params[0];
        String playlistName = playlistUri.getLastPathSegment();
        if (playlistName.endsWith(".m3u"))
            playlistName = playlistName.substring(0, playlistName.length()-4);
        else if (playlistName.endsWith(".m3u8"))
            playlistName = playlistName.substring(0, playlistName.length()-5);
        return importPlaylist(playlistName, playlistUri);
    }

