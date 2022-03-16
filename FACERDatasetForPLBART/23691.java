    private Cursor getTrackCursor(AsyncQueryHandler async, String filter) {
        Cursor ret = null;
        mSortOrder = MediaStore.Audio.Media.TITLE_KEY;
        StringBuilder where = new StringBuilder();
        where.append(MediaStore.Audio.Media.TITLE + " != ''");

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
                where.append(MediaStore.Audio.Media.TITLE_KEY + " LIKE ?");
            }
        }

        if (mGenre != null) {
            mSortOrder = MediaStore.Audio.Genres.Members.DEFAULT_SORT_ORDER;
            if (async != null) {
                async.startQuery(0, null,
                        MediaStore.Audio.Genres.Members.getContentUri("external",
                        Integer.valueOf(mGenre)),
                        mCursorCols, where.toString(), keywords, mSortOrder);
                ret = null;
            } else {
                ret = MusicUtils.query(this,
                        MediaStore.Audio.Genres.Members.getContentUri("external", Integer.valueOf(mGenre)),
                        mCursorCols, where.toString(), keywords, mSortOrder);
            }
        } else if (mPlaylist != null) {
            if (mPlaylist.equals("nowplaying")) {
                if (MusicUtils.sService != null) {
                    ret = new NowPlayingCursor(MusicUtils.sService, mCursorCols);
                    if (ret.getCount() == 0) {
                        finish();
                    }
                } else {
                    // Nothing is playing.
                }
            } else if (mPlaylist.equals("podcasts")) {
                where.append(" AND " + MediaStore.Audio.Media.IS_PODCAST + "=1");
                if (async != null) {
                    async.startQuery(0, null,
                            MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, mCursorCols,
                            where.toString(), keywords, MediaStore.Audio.Media.DEFAULT_SORT_ORDER);
                    ret = null;
                 } else {
                    ret = MusicUtils.query(this,
                            MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, mCursorCols,
                            where.toString(), keywords, MediaStore.Audio.Media.DEFAULT_SORT_ORDER);
                }
            } else if (mPlaylist.equals("recentlyadded")) {
                // do a query for all songs added in the last X weeks
                int X = MusicUtils.getIntPref(this, "numweeks", 2) * (3600 * 24 * 7);
                where.append(" AND " + MediaStore.MediaColumns.DATE_ADDED + ">");
                where.append(System.currentTimeMillis() / 1000 - X);
                if (async != null) {
                    async.startQuery(0, null,
                            MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, mCursorCols,
                            where.toString(), keywords, MediaStore.Audio.Media.DEFAULT_SORT_ORDER);
                    ret = null;
                 } else {
                    ret = MusicUtils.query(this,
                            MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, mCursorCols,
                            where.toString(), keywords, MediaStore.Audio.Media.DEFAULT_SORT_ORDER);
                }
            } else {
                mSortOrder = MediaStore.Audio.Playlists.Members.DEFAULT_SORT_ORDER;
                if (async != null) {
                    async.startQuery(0, null,
                            MediaStore.Audio.Playlists.Members.getContentUri("external", Long.valueOf(mPlaylist)),
                            mPlaylistMemberCols, where.toString(), keywords, mSortOrder);
                    ret = null;
                } else {
                    ret = MusicUtils.query(this,
                            MediaStore.Audio.Playlists.Members.getContentUri("external", Long.valueOf(mPlaylist)),
                            mPlaylistMemberCols, where.toString(), keywords, mSortOrder);
                }
            }
        } else {
            if (mAlbumId != null) {
                where.append(" AND " + MediaStore.Audio.Media.ALBUM_ID + "=" + mAlbumId);
                mSortOrder = MediaStore.Audio.Media.TRACK + ", " + mSortOrder;
            }
            if (mArtistId != null) {
                where.append(" AND " + MediaStore.Audio.Media.ARTIST_ID + "=" + mArtistId);
            }
            where.append(" AND " + MediaStore.Audio.Media.IS_MUSIC + "=1");
            if (async != null) {
                async.startQuery(0, null,
                        MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                        mCursorCols, where.toString() , keywords, mSortOrder);
                ret = null;
            } else {
                ret = MusicUtils.query(this, MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                        mCursorCols, where.toString() , keywords, mSortOrder);
            }
        }

        // This special case is for the "nowplaying" cursor, which cannot be handled
        // asynchronously using AsyncQueryHandler, so we do some extra initialization here.
        if (ret != null && async != null) {
            init(ret);
            setTitle();
        }
        return ret;
    }

