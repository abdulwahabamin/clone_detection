    public static boolean getFromStream(InputStream in, String userName)throws JSONException, IOException {
        SQLiteDatabase libraryDb = library.openHelper.getWritableDatabase();

        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        JSONObject jsonObject;

        libraryDb.beginTransaction();

        for(int i = 0; i < library.remoteTables.length; i++) {
            //get number of rows
            int rows = Integer.parseInt(reader.readLine());

            //get rows
            for(int j = 0; j<rows; j++) {
                jsonObject = new JSONObject(reader.readLine());
                ContentValues values =  new ContentValues();

                Iterator<String> names = jsonObject.keys();
                while(names.hasNext()) {
                    String column = names.next();
                    Object value = jsonObject.get(column);

                    if(column.equals(BaseColumns._ID) || column.equals(BaseColumns._COUNT)) {
                        continue;
                    } else if(column.equals(Table.RemoteColumns.IS_REMOTE)) {
                        values.put(Table.RemoteColumns.IS_REMOTE, 1);
                    } else if(value instanceof Long || value instanceof Integer) {
                        values.put(column, Long.parseLong(jsonObject.getString(column)));
                    } else if(value instanceof String) {
                        values.put(column, jsonObject.getString(column));
                    }
                }
                values.put(Table.RemoteColumns.REMOTE_USERNAME, userName);
                //insert row
                library.remoteTables[i].insertValues(values, libraryDb);
            }
        }

        libraryDb.setTransactionSuccessful();
        libraryDb.endTransaction();

        libraryDb.beginTransaction();

        ContentValues v;

        //set userName
        v = new ContentValues();
        v.put(SongTable.Columns.FILE_PATH, REMOTE_SONG_MISSING_PATH);

        libraryDb.update(SongTable.remoteTableName,v,
                SongTable.Columns.REMOTE_USERNAME + "=?", new String[]{userName});

        Cursor cursor = libraryDb.query(true, AlbumTable.remoteTableName,
                new String[]{AlbumTable.Columns.ALBUM_ID, AlbumTable.Columns.ALBUM_ART},
                AlbumTable.Columns.REMOTE_USERNAME + "=?", new String[]{userName},
                null, null, null, null);

        for(boolean res = cursor.moveToFirst(); (res); res = cursor.moveToNext()) {
            long albumId = getLong(cursor,AlbumTable.Columns.ALBUM_ID);
            String albumArt = getString(cursor, AlbumTable.Columns.ALBUM_ART);
            if(albumArt != null) {
                String[] split = albumArt.split("/");

                albumArt = Library.REMOTE_COVERS_LOCATION + "/" + userName
                        + "/" + split[split.length - 1];

                v = new ContentValues();
                v.put(AlbumTable.Columns.ALBUM_ART, albumArt);

                libraryDb.update(AlbumTable.remoteTableName, v,
                        AlbumTable.Columns.REMOTE_USERNAME + "=?"
                                + " AND " + AlbumTable.Columns.ALBUM_ID + "=?",
                        new String[]{userName, String.valueOf(albumId)});
            }
        }

        cursor.close();

        libraryDb.setTransactionSuccessful();
        libraryDb.endTransaction();

        File remoteCoversLocation = new File(REMOTE_COVERS_LOCATION, userName);
        if(!remoteCoversLocation.exists()) {
            remoteCoversLocation.mkdir();
        }

        return true;
    }

