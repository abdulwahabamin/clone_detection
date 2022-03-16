    public void onCreate() {
        //create the service
        super.onCreate();
        //intialize position
        songPosn = 0;
        //create player
        player = new MediaPlayer();
        initMusicPlayer();
    }

