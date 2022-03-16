    private void Setup() {

        SetupGetValue();
        SetupRoot();
        SetupBothmusicplayer();
        SetupClickListener();
        Setuptextview();
        SetupAlbumArtheight();
        SetupRecyclerView();
        SetupToolbar();
        SetupSeekBar();
        mHandler.post(isOnline);
        LoadAds();
        SetupAnalytics();

    }

