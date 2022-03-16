    public static MediaPlayer setMediaPlayer(Context context, String songLocation) {
        try {
            if (mediaPlayer != null) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                }
                mediaPlayer.reset();
            }
            mediaPlayer = MediaPlayer.create(context, Uri.parse(songLocation));
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            return mediaPlayer;
        } catch (Exception e) {
            Timber.e(e, "setMediaPlayer");
            mediaPlayer = MediaPlayer.create(context, Uri.parse(songLocation));
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            return mediaPlayer;
        }
    }

