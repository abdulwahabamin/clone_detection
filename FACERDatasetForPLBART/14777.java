    @Override
    public void playButtonAction(){
        if(mediaPlayer.isPlaying()){
            playButton.setImageResource(R.drawable.ic_play);
            mediaPlayer.pause();
        }else{
            playButton.setImageResource(R.drawable.ic_pause);
            mediaPlayer.start();
        }
    }

