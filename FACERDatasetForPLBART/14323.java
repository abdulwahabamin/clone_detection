    public NowPlayingCursor(IApolloService service, String[] projection, Context c) {
        mProjection = projection;
        mService = service;
        makeNowPlayingCursor();
        context = c;
    }

