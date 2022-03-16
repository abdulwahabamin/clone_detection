    private void shuffleSongs() {
        SongDTO currentSong = songsList.get(songPosition);
        Collections.shuffle(songsList);
        songsList.remove(currentSong);
        songsList.add(0, currentSong);
        songPosition = 0;
        PlayBackUtil.setCurrentSongPosition(songPosition);
        PlayBackUtil.setCurrentPlayList(songsList);
        populateSongs(songsList, songPosition);
    }

