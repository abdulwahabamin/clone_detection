    public static int [] getAllSongs(Context context) {
        Cursor c = query(context, MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                new String[] {MediaStore.Audio.Media._ID}, MediaStore.Audio.Media.IS_MUSIC + "=1",
                null, null);
        try {
            if (c == null || c.getCount() == 0) {
                return null;
            }
            int len = c.getCount();
            int[] list = new int[len];
            for (int i = 0; i < len; i++) {
                c.moveToNext();
                list[i] = c.getInt(0);
            }

            return list;
        } finally {
            if (c != null) {
                c.close();
            }
        }
    }

