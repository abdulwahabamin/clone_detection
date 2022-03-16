    private Cursor getAlbumCursor(AsyncQueryHandler async, String filter) {
        StringBuilder where = new StringBuilder();
        where.append(MediaStore.Audio.Albums.ALBUM + " != ''");
        
        // Add in the filtering constraints
        String [] keywords = null;
        if (filter != null) {
            String [] searchWords = filter.split(" ");
            keywords = new String[searchWords.length];
            Collator col = Collator.getInstance();
            col.setStrength(Collator.PRIMARY);
            for (int i = 0; i < searchWords.length; i++) {
                keywords[i] = '%' + MediaStore.Audio.keyFor(searchWords[i]) + '%';
            }
            for (int i = 0; i < searchWords.length; i++) {
                where.append(" AND ");
                where.append(MediaStore.Audio.Media.ARTIST_KEY + "||");
                where.append(MediaStore.Audio.Media.ALBUM_KEY + " LIKE ?");
            }
        }

        String whereclause = where.toString();  
            
        String[] cols = new String[] {
                MediaStore.Audio.Albums._ID,
                MediaStore.Audio.Albums.ARTIST,
                MediaStore.Audio.Albums.ALBUM,
                MediaStore.Audio.Albums.ALBUM_ART
        };
        Cursor ret = null;
        if (mArtistId != null) {
            if (async != null) {
                async.startQuery(0, null,
                        MediaStore.Audio.Artists.Albums.getContentUri("external",
                                Long.valueOf(mArtistId)),
                        cols, whereclause, keywords, MediaStore.Audio.Albums.DEFAULT_SORT_ORDER);
            } else {
                ret = MusicUtils.query(this,
                        MediaStore.Audio.Artists.Albums.getContentUri("external",
                                Long.valueOf(mArtistId)),
                        cols, whereclause, keywords, MediaStore.Audio.Albums.DEFAULT_SORT_ORDER);
            }
        } else {
            if (async != null) {
                async.startQuery(0, null,
                        MediaStore.Audio.Albums.EXTERNAL_CONTENT_URI,
                        cols, whereclause, keywords, MediaStore.Audio.Albums.DEFAULT_SORT_ORDER);
            } else {
                ret = MusicUtils.query(this, MediaStore.Audio.Albums.EXTERNAL_CONTENT_URI,
                        cols, whereclause, keywords, MediaStore.Audio.Albums.DEFAULT_SORT_ORDER);
            }
        }
        return ret;
    }

