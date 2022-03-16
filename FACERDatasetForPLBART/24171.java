    private int getCursorCount(Cursor cursor) {
        if (cursor == null) return 0;
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

