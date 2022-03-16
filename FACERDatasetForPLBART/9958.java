        private static synchronized Map<String, Long> getAlbums(Context context) {
            if (sAlbumsDirty) {
                sAlbums = MediaHelper.getAllAlbums(context.getContentResolver());
                sAlbumsDirty = false;
            }
            return sAlbums;
        }

