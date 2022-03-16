    /**
     *  Start the trackBrowserActivity and add the new playlist
     */
    public void addNewPlaylist(String playListName) throws Exception{
        Instrumentation inst = getInstrumentation();
        Activity trackBrowserActivity;
        ActivityMonitor trackBrowserMon = inst.addMonitor("com.android.music.TrackBrowserActivity", 
                null, false);
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_PICK);
        intent.setClassName("com.android.music", "com.android.music.TrackBrowserActivity");
        getActivity().startActivity(intent);     
        Thread.sleep(MusicPlayerNames.WAIT_LONG_TIME);
        trackBrowserActivity = trackBrowserMon.waitForActivityWithTimeout(2000);
        inst.invokeContextMenuAction(trackBrowserActivity, MusicUtils.Defs.NEW_PLAYLIST, 0);
        Thread.sleep(MusicPlayerNames.WAIT_SHORT_TIME);
        //Remove the default playlist name
        clearSearchString(MusicPlayerNames.DEFAULT_PLAYLIST_LENGTH);
        inst.sendStringSync(playListName);
        inst.sendKeyDownUpSync(KeyEvent.KEYCODE_DPAD_DOWN);
        inst.sendKeyDownUpSync(KeyEvent.KEYCODE_DPAD_CENTER);
        Thread.sleep(MusicPlayerNames.WAIT_LONG_TIME);
        trackBrowserActivity.finish();
        clearSearchString(playListName.length());

    }

