    /**
     * On Song Playing completed
     * if repeat is ON play same song again
     * if shuffle is ON play random song
     * */
    @Override
    public void onCompletion(MediaPlayer arg0) {
        btnPlay.setImageResource(R.drawable.ic_play);

        // check for repeat is ON or OFF
//        if(isRepeat){
//            // repeat is on play same song again
//            playSong();
//        } else if(isShuffle){
//            // shuffle is on - play a random song
//            playSong();
//        } else{
//            // no repeat or shuffle ON - play next song
//                playSong();
//
//                // play first song
//
//        }
    }

