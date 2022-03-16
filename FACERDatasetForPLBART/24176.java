    public static String calcTitle(Context context, Uri uri) {
        switch (MusicProvider.sURIMatcher.match(uri)) {
            case MusicProvider.FOLDER_MEMBERS:
                File root = fetchRoot(context);
                return uri.getLastPathSegment().substring(root.getAbsolutePath().length() + 1);

            case MusicProvider.PLAYLIST_MEMBERS: {
                if (ContentUris.parseId(uri) == MusicContract.Playlist.RECENTLY_ADDED_PLAYLIST) {
                    return context.getString(R.string.recentlyadded_title);
                } else if (ContentUris.parseId(uri) == MusicContract.Playlist.ALL_SONGS) {
                    return context.getString(R.string.all_songs_title);
                } else {
                    String[] cols = new String[] {
                            MediaStore.Audio.Playlists.NAME
                    };
                    Cursor cursor = context.getContentResolver().query(
                            ContentUris.withAppendedId(MediaStore.Audio.Playlists.EXTERNAL_CONTENT_URI, ContentUris.parseId(uri)),
                            cols, null, null, null);
                    if (cursor != null) {
                        try {
                            if (cursor.getCount() != 0) {
                                cursor.moveToFirst();
                                return cursor.getString(0);
                            }
                        } finally {
                            cursor.close();
                        }
                    }
                    return context.getString(R.string.unknown_playlist_name);
                }
            }
            case MusicProvider.GENRE_MEMBERS: {
                String fancyName = null;
                String[] cols = new String[] {
                        MediaStore.Audio.Genres.NAME
                };
                Cursor cursor = context.getContentResolver().query(
                        ContentUris.withAppendedId(MediaStore.Audio.Genres.EXTERNAL_CONTENT_URI, ContentUris.parseId(uri)),
                        cols, null, null, null);
                if (cursor != null) {
                    try {
                        if (cursor.getCount() != 0) {
                            cursor.moveToFirst();
                            fancyName = cursor.getString(0);
                        }
                    } finally {
                        cursor.close();
                    }
                }
                if (fancyName == null || fancyName.equals(MediaStore.UNKNOWN_STRING)) {
                    return context.getString(R.string.unknown_genre_name);
                } else {
                    return ID3Utils.decodeGenre(fancyName);
                }
            }
            case MusicProvider.ARTIST_MEMBERS: {
                String fancyName = null;
                String[] cols = new String[] {
                        MediaStore.Audio.Artists.ARTIST
                };
                Cursor cursor = context.getContentResolver().query(
                        ContentUris.withAppendedId(MediaStore.Audio.Artists.EXTERNAL_CONTENT_URI, ContentUris.parseId(uri)),
                        cols, null, null, null);
                if (cursor != null) {
                    try {
                        if (cursor.getCount() != 0) {
                            cursor.moveToFirst();
                            fancyName = cursor.getString(0);
                        }
                    } finally {
                        cursor.close();
                    }
                }
                if (fancyName == null || fancyName.equals(MediaStore.UNKNOWN_STRING)) {
                    return context.getString(R.string.unknown_artist_name);
                } else {
                    return fancyName;
                }
            }
            case MusicProvider.ALBUM_MEMBERS: {
                String fancyName = null;
                String[] cols = new String[] {
                        MediaStore.Audio.Albums.ALBUM
                };
                Cursor cursor = context.getContentResolver().query(
                        ContentUris.withAppendedId(MediaStore.Audio.Albums.EXTERNAL_CONTENT_URI, ContentUris.parseId(uri)),
                        cols, null, null, null);
                if (cursor != null) {
                    try {
                        if (cursor.getCount() != 0) {
                            cursor.moveToFirst();
                            fancyName = cursor.getString(0);
                        }
                    } finally {
                        cursor.close();
                    }
                }
                if (fancyName == null || fancyName.equals(MediaStore.UNKNOWN_STRING)) {
                    return context.getString(R.string.unknown_album_name);
                } else {
                    return fancyName;
                }
            }

            case MusicProvider.MUSIC_MEMBERS:
                return context.getString(R.string.tracks_title);

            default:
                return context.getString(R.string.tracks_title);
        }
    }

