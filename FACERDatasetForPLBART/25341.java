    public static void deletePlaylist(String playlistID, Context context) {
        Realm realm = Realm.getInstance(context);
        realm.beginTransaction();

        Playlist playlistToDelete = realm.where(Playlist.class)
                .equalTo("id", playlistID)
                .findFirst();
        playlistToDelete.removeFromRealm();
        realm.commitTransaction();
        realm.close();
    }

