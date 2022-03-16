    public static long [] getSongListForCursorAndClose(Cursor cursor) {
        try {
            return getSongListForCursor(cursor);
        } finally {
            if (cursor != null) cursor.close();
        }
    }

