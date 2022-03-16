    public static void createPlaylist(String playlistName, Context context) {
        Realm realm = Realm.getInstance(context);
        realm.beginTransaction();

        Playlist playlistRecord = realm.createObject(Playlist.class);
        playlistRecord.setId(UUID.randomUUID().toString());
        playlistRecord.setPlaylistName(playlistName);

        realm.commitTransaction();
        realm.close();
    }

