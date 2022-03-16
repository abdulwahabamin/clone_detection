    /**
     * Loads the playlist cover information from a file to be placed in a grid view.
     */
    public void loadPlaylists(){
        fragmentCommunicator.retrievePlaylistHashMapFromFile();
        playlistMap = fragmentCommunicator.getPlaylistHashMap();

        for(Map.Entry<String, ArrayList<File>> entry : playlistMap.entrySet()){
            playlistCovers.add(playlistCovers.size(), new ImageItem(bitmap, entry.getKey()));
        }
    }

