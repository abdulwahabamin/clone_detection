    @Override
    public void nextButtonAction(){
        if(repeatSong){
            playSong(currentSongIndex);
        }else if(shuffleSongs){
            Random rand = new Random();
            currentSongIndex = rand.nextInt((songList.size() - 1) + 1);
            playSong(currentSongIndex);
        }else if(repeatSong && shuffleSongs){
            Random rand = new Random();
            currentSongIndex = rand.nextInt((songList.size() - 1) + 1);
            playSong(currentSongIndex);
        }else{
            if(currentSongIndex < (songList.size() - 1)){
                playSong(currentSongIndex + 1);
            }else{
                playSong(0);
            }
        }
    }

