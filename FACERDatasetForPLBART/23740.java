    /**
     * Test case 1: Add a playlist and delet the playlist just added.
     * Verification: The mediastore playlist should be empty
     */
    @LargeTest
    public void testDeletePlaylist() throws Exception{
        boolean isEmptyPlaylist = true;
        addNewPlaylist(MusicPlayerNames.DELETE_PLAYLIST_NAME);
        deletePlaylist(MusicPlayerNames.DELETE_PLAYLIST_NAME);  
        isEmptyPlaylist = verifyPlaylist(MusicPlayerNames.DELETE_PLAYLIST_NAME);
        assertFalse("testDeletePlaylist", isEmptyPlaylist);
    }

