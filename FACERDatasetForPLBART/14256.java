    /**
     * @param mContext
     * @param create_shortcut
     * @param list
     */
    public static void makePlaylistList(Context mContext, boolean create_shortcut,
            List<Map<String, String>> list) {

        Map<String, String> map;

        String[] cols = new String[] {
                Audio.Playlists._ID, Audio.Playlists.NAME
        };
        StringBuilder where = new StringBuilder();

        ContentResolver resolver = mContext.getContentResolver();
        if (resolver == null) {
            System.out.println("resolver = null");
        } else {
            where.append(Audio.Playlists.NAME + " != ''");
            where.append(" AND " + Audio.Playlists.NAME + " != '" + PLAYLIST_NAME_FAVORITES + "'");
            Cursor cur = resolver.query(Audio.Playlists.EXTERNAL_CONTENT_URI, cols,
                    where.toString(), null, Audio.Playlists.NAME);
            list.clear();

            // map = new HashMap<String, String>();
            // map.put("id", String.valueOf(PLAYLIST_FAVORITES));
            // map.put("name", mContext.getString(R.string.favorite));
            // list.add(map);

            map = new HashMap<String, String>();
            map.put("id", String.valueOf(PLAYLIST_QUEUE));
            map.put("name", mContext.getString(R.string.queue));
            list.add(map);

            map = new HashMap<String, String>();
            map.put("id", String.valueOf(PLAYLIST_NEW));
            map.put("name", mContext.getString(R.string.new_playlist));
            list.add(map);

            if (cur != null && cur.getCount() > 0) {
                cur.moveToFirst();
                while (!cur.isAfterLast()) {
                    map = new HashMap<String, String>();
                    map.put("id", String.valueOf(cur.getLong(0)));
                    map.put("name", cur.getString(1));
                    list.add(map);
                    cur.moveToNext();
                }
            }
            if (cur != null) {
                cur.close();
            }
        }
    }

