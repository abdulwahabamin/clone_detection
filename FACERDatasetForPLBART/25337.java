    public static Artist getArtistById(String id, Context context) {
        Realm realm = Realm.getInstance(context);
        realm.beginTransaction();
        Artist artist = realm.where(Artist.class)
                .contains("id", id)
                .findFirst();
        realm.commitTransaction();
        realm.close();
        return artist;
    }

