    /**
     * Test case 2: Set a song as ringtone
     * Test case precondition: The testing device should wipe data before 
     * run the test case.
     * Verification: The count of audio.media.is_ringtone equal to 1. 
     */
    @LargeTest
    public void testSetRingtone() throws Exception{
      Cursor mCursor;
      Instrumentation inst = getInstrumentation();      
      inst.invokeContextMenuAction(getActivity(), MusicUtils.Defs.USE_AS_RINGTONE, 0);
      //This only check if there only 1 ringtone set in music player
      ContentResolver resolver = getActivity().getContentResolver();
      if (resolver == null) {
        System.out.println("resolver = null");
      } else {
        String whereclause = MediaStore.Audio.Media.IS_RINGTONE + " = 1";
        mCursor = resolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
           null, whereclause, null, null);
        //Check the new playlist
        mCursor.moveToFirst();
        int isRingtoneSet = mCursor.getCount();
        assertEquals(TAG, MusicPlayerNames.EXPECTED_NO_RINGTONE, isRingtoneSet);
      }
    }

