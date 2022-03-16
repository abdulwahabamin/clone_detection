    @Override
    public void previousButtonAction(){
        if(repeatSong){
            playSong(currentSongIndex);
        }else{
            if(currentSongIndex > 0){
                playSong(currentSongIndex - 1);
            }else{
                playSong(songList.size() - 1);
            }
        }
    }

