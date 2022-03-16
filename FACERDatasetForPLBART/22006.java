    private void addXTrackSelector(Notification n) {
        if (NotificationHelper.isSupported(n)) {
            StringBuilder selection = new StringBuilder();
            StringBuilder order = new StringBuilder().append("CASE _id \n");
            for (int i = 0; i < mPlaylist.size(); i++) {
                selection.append("_id=").append(mPlaylist.get(i).mId).append(" OR ");
                order.append("WHEN ").append(mPlaylist.get(i).mId).append(" THEN ").append(i).append("\n");
            }
            order.append("END");
            Cursor c = getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, NOTIFICATION_PROJECTION, selection.substring(0, selection.length() - 3), null, order.toString());
            if (c != null && c.getCount() != 0) {
                c.moveToFirst();
                ArrayList<Bundle> list = new ArrayList<>();
                do {
                    TrackItem t = new TrackItem()
                            .setArt(TimberUtils.getAlbumArtUri(c.getLong(c.getColumnIndexOrThrow(AudioColumns.ALBUM_ID))))
                            .setTitle(c.getString(c.getColumnIndexOrThrow(AudioColumns.TITLE)))
                            .setArtist(c.getString(c.getColumnIndexOrThrow(AudioColumns.ARTIST)))
                            .setDuration(TimberUtils.makeShortTimeString(this, c.getInt(c.getColumnIndexOrThrow(AudioColumns.DURATION)) / 1000));
                    list.add(t.get());
                } while (c.moveToNext());
                try {
                    NotificationHelper.insertToNotification(n, list, this, getQueuePosition());
                } catch (ModNotInstalledException e) {
                    e.printStackTrace();
                }
                c.close();
            }
        }
    }

