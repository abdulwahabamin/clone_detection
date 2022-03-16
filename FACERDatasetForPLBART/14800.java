    /**
     * Updates the data of the current playlist that the user is in.
     *
     * @param songName - song file to be added to the playlist.
     */
    public void updatePlaylist(File songName){
        fragmentCommunicator.retrievePlaylistHashMapFromFile();
        playlistMap = fragmentCommunicator.getPlaylistHashMap();

        playlistSongList.add(songName);
        playlistMap.put(fragmentCommunicator.getPlaylistTitle(), playlistSongList);
        fragmentCommunicator.savePlaylistHashMap(playlistMap);
        formattedSongList.clear();

        for(File f : playlistSongList){
            formattedSongList.add(f.getName());
        }

        ((BaseAdapter)listAdapter).notifyDataSetChanged();
        listView.invalidateViews();
    }

