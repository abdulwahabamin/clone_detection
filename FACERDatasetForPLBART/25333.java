    private static List<Song> getMostPlayedSongs(Context context) {
        Realm realm = Realm.getInstance(context);
        RealmResults<Song> result = realm.where(Song.class).greaterThan("noOfPlayed", 0).findAll();
        result.sort("noOfPlayed", Sort.DESCENDING);
        return result;
    }

