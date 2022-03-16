    /**
     * Test case 3: Delete a song
     * Test case precondition: Copy a song and rescan the sdcard
     * Verification: The song is deleted from the sdcard and mediastore
     */
    @LargeTest
    public void testDeleteSong() throws Exception{
      Instrumentation inst = getInstrumentation();      
      Cursor mCursor;
      
      //Copy a song from the golden directory
      Log.v(TAG, "Copy a temp file to the sdcard");
      File goldenfile = new File(MusicPlayerNames.GOLDENSONG);
      File toBeDeleteSong = new File(MusicPlayerNames.DELETESONG);
      copy(goldenfile, toBeDeleteSong);
      rescanSdcard();
       
      //Delete the file from music player
      Thread.sleep(MusicPlayerNames.WAIT_LONG_TIME);
      inst.sendStringSync(MusicPlayerNames.TOBEDELETESONGNAME);
      Thread.sleep(MusicPlayerNames.WAIT_LONG_TIME);
      inst.invokeContextMenuAction(getActivity(), MusicUtils.Defs.DELETE_ITEM, 0);
      inst.sendKeyDownUpSync(KeyEvent.KEYCODE_DPAD_DOWN);
      inst.sendKeyDownUpSync(KeyEvent.KEYCODE_DPAD_CENTER);
      Thread.sleep(MusicPlayerNames.WAIT_LONG_TIME);
      
      //Clear the search string
      for (int j=0; j< MusicPlayerNames.TOBEDELETESONGNAME.length(); j++)
          inst.sendKeyDownUpSync(KeyEvent.KEYCODE_DEL);
      
      //Verfiy the item is removed from sdcard
      File checkDeletedFile = new File(MusicPlayerNames.DELETESONG);
      assertFalse(TAG, checkDeletedFile.exists());
      
      ContentResolver resolver = getActivity().getContentResolver();
      if (resolver == null) {
        System.out.println("resolver = null");
      } else {
        String whereclause = MediaStore.Audio.Media.DISPLAY_NAME + " = '" + 
        MusicPlayerNames.TOBEDELETESONGNAME + "'";
        mCursor = resolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
           null, whereclause, null, null);
        boolean isEmptyCursor = mCursor.moveToFirst();
        assertFalse(TAG,isEmptyCursor);
      }     
    } 

