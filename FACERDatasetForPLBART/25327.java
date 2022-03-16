    private static Artist getOrCreateArtist(Realm realm, RhythmSong rhythmSong) {
        if (rhythmSong.getArtistTitle().equals("Untitled Artist")) {
            Artist query = realm.where(Artist.class)
                    .contains("artistName", "Untitled Artist")
                    .findFirst();
            if (query != null) {
                return query;
            } else {
                Artist newArtist = realm.createObject(Artist.class);
                newArtist.setArtistName("Untitled Artist");
                if (rhythmSong.getImageData() != null) {
                    newArtist.setCoverPath(rhythmSong.getSongLocation());
                }
                newArtist.setId(UUID.randomUUID().toString());
                return newArtist;
            }
        } else {
            Artist query = realm.where(Artist.class)
                    .contains("artistName", rhythmSong.getArtistTitle())
                    .findFirst();
            if (query != null) {
                return query;
            } else {
                Artist newArtist = realm.createObject(Artist.class);
                newArtist.setArtistName(rhythmSong.getArtistTitle());
                if (rhythmSong.getImageData() != null) {
                    newArtist.setCoverPath(rhythmSong.getSongLocation());
                }
                newArtist.setId(UUID.randomUUID().toString());
                return newArtist;
            }
        }
    }

