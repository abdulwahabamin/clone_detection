    /**
     * Test case 2: Add playlist and rename the playlist just added.
     * Verification: The mediastore playlist should contain the updated name.
     */
    @LargeTest
    public void testRenamePlaylist() throws Exception{
        boolean isEmptyPlaylist = true;
        addNewPlaylist(MusicPlayerNames.ORIGINAL_PLAYLIST_NAME);
        renamePlaylist(MusicPlayerNames.ORIGINAL_PLAYLIST_NAME, MusicPlayerNames.RENAMED_PLAYLIST_NAME);  
        isEmptyPlaylist = verifyPlaylist(MusicPlayerNames.RENAMED_PLAYLIST_NAME);
        deletePlaylist(MusicPlayerNames.RENAMED_PLAYLIST_NAME);
        assertTrue("testDeletePlaylist", isEmptyPlaylist);
    }

