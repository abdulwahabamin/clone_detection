    public static boolean sendOverStream(OutputStream out)throws JSONException, IOException {
        SQLiteDatabase libraryDb = library.openHelper.getReadableDatabase();

        PrintWriter printWriter = new PrintWriter(out, true);

        JSONObject jsonObject;

        for(int i = 0; i < library.tables.length; i++) {
            Cursor cursor = library.tables[i].getFullTable(libraryDb);
            cursor.moveToFirst(); //TODO: if false do something

            //send number of rows
            printWriter.println(String.valueOf(cursor.getCount()));

            //send each row
            for(boolean res = cursor.moveToFirst(); res; res = cursor.moveToNext()) {
                jsonObject = new JSONObject();

                for(int j = 0; j < cursor.getColumnCount(); j++) {
                    String column = cursor.getColumnName(j);

                    if(cursor.getType(j) == Cursor.FIELD_TYPE_INTEGER) {
                        jsonObject.put(column, cursor.getLong(cursor.getColumnIndex(column)));
                    } else if(cursor.getType(j) == Cursor.FIELD_TYPE_STRING) {
                        jsonObject.put(column, cursor.getString(cursor.getColumnIndex(column)));
                    }
                }

                printWriter.println(jsonObject.toString());
            }

            cursor.close();
        }

        return true;
    }

