    private static List<Song> getLastPlayedSongs(Context context) {
        Realm realm = Realm.getInstance(context);
        RealmResults<Song> result = realm.where(Song.class).greaterThan("lastPlayed", 0).findAll();
        result.sort("lastPlayed", Sort.DESCENDING);
        return result;
    }

