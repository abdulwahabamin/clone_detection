    /**
     * Remove playlist
     */
    public void deletePlaylist(String playlistname) throws Exception{
        Instrumentation inst = getInstrumentation();
        inst.sendStringSync(playlistname);
        Thread.sleep(MusicPlayerNames.WAIT_SHORT_TIME);
        inst.sendKeyDownUpSync(KeyEvent.KEYCODE_DPAD_DOWN);       
        inst.invokeContextMenuAction(getActivity(), MusicUtils.Defs.CHILD_MENU_BASE + 1, 0);
        Thread.sleep(MusicPlayerNames.WAIT_SHORT_TIME);
        clearSearchString(playlistname.length());
        
    }

