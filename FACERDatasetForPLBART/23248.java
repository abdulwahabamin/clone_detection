    private Cursor getArtistCursor(AsyncQueryHandler async, String filter) {

        StringBuilder where = new StringBuilder();
        where.append(MediaStore.Audio.Artists.ARTIST + " != ''");
        
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
                where.append(MediaStore.Audio.Media.ARTIST_KEY + " LIKE ?");
            }
        }

        String whereclause = where.toString();  
        String[] cols = new String[] {
                MediaStore.Audio.Artists._ID,
                MediaStore.Audio.Artists.ARTIST,
                MediaStore.Audio.Artists.NUMBER_OF_ALBUMS,
                MediaStore.Audio.Artists.NUMBER_OF_TRACKS
        };
        Cursor ret = null;
        if (async != null) {
            async.startQuery(0, null, MediaStore.Audio.Artists.EXTERNAL_CONTENT_URI,
                    cols, whereclause , keywords, MediaStore.Audio.Artists.ARTIST_KEY);
        } else {
            ret = MusicUtils.query(this, MediaStore.Audio.Artists.EXTERNAL_CONTENT_URI,
                    cols, whereclause , keywords, MediaStore.Audio.Artists.ARTIST_KEY);
        }
        return ret;
    }

