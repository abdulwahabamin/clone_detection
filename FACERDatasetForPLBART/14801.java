    /**
     * Loads the playlist information from a file to be displayed for the user.
     *
     */
    public void loadPlaylists(){
        fragmentCommunicator.retrievePlaylistHashMapFromFile();
        playlistMap = fragmentCommunicator.getPlaylistHashMap();
        ArrayList<File> files = playlistMap.get(fragmentCommunicator.getPlaylistTitle());

        if(files != null){
            for(File f : files){
                updatePlaylist(f);
            }
        }
    }

