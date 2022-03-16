    /**
     * @param media player from apollo service.
     */
    public static void initEqualizer(MediaPlayer player, Context context){
    	releaseEqualizer();
    	int id = player.getAudioSessionId();
    	mEqualizer = new Equalizer(1,id);
    	mBoost = new BassBoost(1, id);
    	updateEqualizerSettings(context);
    }

