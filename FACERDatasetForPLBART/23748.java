    /**
     * Test case 1: tests the new playlist added with sorted order.
     * Verification: The new playlist title should be sorted in alphabetical order
     */
    @LargeTest
    public void testAddPlaylist() throws Exception{
      Cursor mCursor;
      addNewPlaylist();
      
      //Verify the new playlist is created, check the playlist table
      String[] cols = new String[] {
          MediaStore.Audio.Playlists.NAME
      };
      ContentResolver resolver = getActivity().getContentResolver();
      if (resolver == null) {
        System.out.println("resolver = null");
      } else {
        String whereclause = MediaStore.Audio.Playlists.NAME + " != ''";
        mCursor = resolver.query(MediaStore.Audio.Playlists.EXTERNAL_CONTENT_URI,
          cols, whereclause, null,
          MediaStore.Audio.Playlists.NAME);
        //Check the new playlist
        mCursor.moveToFirst();
        
        for (int j=0;j<10;j++){
          assertEquals("New sorted Playlist title:", MusicPlayerNames.expectedPlaylistTitle[j], mCursor.getString(0)); 
          mCursor.moveToNext();
        }
      }
    }   

