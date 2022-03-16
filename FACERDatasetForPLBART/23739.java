    public boolean verifyPlaylist(String playlistname) throws Exception{
        Cursor mCursor;
        boolean isEmptyPlaylist = true;
        String[] cols = new String[] {
                MediaStore.Audio.Playlists.NAME
        };
        ContentResolver resolver = getActivity().getContentResolver();
        if (resolver == null) {
            System.out.println("resolver = null");
            assertNull(TAG, resolver);
        } else {
            String whereclause = MediaStore.Audio.Playlists.NAME + " = '" + playlistname +"'";
            mCursor = resolver.query(MediaStore.Audio.Playlists.EXTERNAL_CONTENT_URI,
                    cols, whereclause, null,
                    MediaStore.Audio.Playlists.NAME);
            isEmptyPlaylist = mCursor.moveToFirst();
        }
        return isEmptyPlaylist;
    }

