    /**
     * Rename playlist
     */
    public void renamePlaylist(String oldPlaylistName, String newPlaylistName) throws Exception{
        Instrumentation inst = getInstrumentation();
        inst.sendStringSync(oldPlaylistName);
        Thread.sleep(MusicPlayerNames.WAIT_SHORT_TIME);
        inst.sendKeyDownUpSync(KeyEvent.KEYCODE_DPAD_DOWN);       
        inst.invokeContextMenuAction(getActivity(), MusicUtils.Defs.CHILD_MENU_BASE + 3, 0);
        Thread.sleep(MusicPlayerNames.WAIT_SHORT_TIME);
        //Remove the old playlist name
        clearSearchString(oldPlaylistName.length());
        inst.sendStringSync(newPlaylistName);
        inst.sendKeyDownUpSync(KeyEvent.KEYCODE_DPAD_DOWN);
        inst.sendKeyDownUpSync(KeyEvent.KEYCODE_DPAD_CENTER);
        Thread.sleep(MusicPlayerNames.WAIT_LONG_TIME);
        clearSearchString(oldPlaylistName.length());
    }

