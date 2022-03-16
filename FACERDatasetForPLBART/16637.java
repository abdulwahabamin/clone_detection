    public PlaybackManager(MusicPlayerServiceCallback serviceCallback,
                           QueueManager queueManager,
                           Playback playback) {
        this.serviceCallback = serviceCallback;
        this.queueManager = queueManager;
        this.playback = playback;
        mediaSessionCallback = new MediaSessionCallback();
        this.playback.setCallback(this);
    }

