    public boolean playSong(Song song) {
        try {
            if (!prepared) {
                prepareSong(song);
                if(prepared) play();
                else return false;
            }
            else if(!mediaPlayer.isPlaying()) {
                play();
            }
        }
        catch (IOException e) {
            return false;
        }

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stopSeekMonitor();
                callSeekListeners();

                for(MediaPlayer.OnCompletionListener listener : onCompletionListenerList) {
                    listener.onCompletion(mediaPlayer);
                }
            }
        });

        return true;
    }

