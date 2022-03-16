    /**
     * Add 10 new playlists with unsorted title order
     */
    public void addNewPlaylist() throws Exception{
      Instrumentation inst = getInstrumentation();      
      for (int i=0; i< MusicPlayerNames.NO_OF_PLAYLIST; i++){
        inst.invokeContextMenuAction(getActivity(), MusicUtils.Defs.NEW_PLAYLIST, 0);
        Thread.sleep(MusicPlayerNames.WAIT_SHORT_TIME);
        //Remove the default playlist name
        for (int j=0; j< MusicPlayerNames.DEFAULT_PLAYLIST_LENGTH; j++)
          inst.sendKeyDownUpSync(KeyEvent.KEYCODE_DEL);
        inst.sendStringSync(MusicPlayerNames.unsortedPlaylistTitle[i]);
        inst.sendKeyDownUpSync(KeyEvent.KEYCODE_DPAD_DOWN);
        inst.sendKeyDownUpSync(KeyEvent.KEYCODE_DPAD_CENTER);
        Thread.sleep(MusicPlayerNames.WAIT_LONG_TIME);
        inst.sendKeyDownUpSync(KeyEvent.KEYCODE_DPAD_DOWN);
        Thread.sleep(MusicPlayerNames.WAIT_LONG_TIME);
      }
    }

