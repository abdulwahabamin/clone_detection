    public static ArrayList<Album> getAlbumIndexes(ArrayList<Song> songs) {
        Log.d(TAG, "getAlbumIndexes() entry.");
        ArrayList<Album> rslt = new ArrayList<>();

        long curAlbumId = 0;
        int albumStartTrack = -1;
        int albumEndTrack = -1;
        String albumTitle = "";
        long imageID = 0;

        for (int i = 0; i < songs.size(); i++) {
            Song s = songs.get(i);
            long nextAlbumId = s.getAlbumId();
            if (i==0) {
                curAlbumId = nextAlbumId;
                albumStartTrack = i;
                albumEndTrack = i;
                albumTitle = s.getAlbum();
                imageID = s.getId();
            } else if (nextAlbumId != curAlbumId) {
                rslt.add(new Album(curAlbumId, albumTitle, imageID, albumStartTrack, albumEndTrack));
                curAlbumId = nextAlbumId;
                albumStartTrack = i;
                albumEndTrack = i;
                albumTitle = s.getAlbum();
                imageID = s.getId();
            } else {
                albumEndTrack = i;
            }
        }
        rslt.add(new Album(curAlbumId, albumTitle, imageID, albumStartTrack, albumEndTrack));
        return rslt;
    }

