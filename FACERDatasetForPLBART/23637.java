        @Override
        public void handleMessage(Message msg)
        {
            if (msg.what == CHECK) {
                String status = Environment.getExternalStorageState();
                if (!status.equals(Environment.MEDIA_MOUNTED)) {
                    // If the card suddenly got unmounted again, there's
                    // really no need to keep waiting for the media scanner.
                    finish();
                    return;
                }
                Cursor c = MusicUtils.query(ScanningProgress.this,
                        MediaStore.Audio.Playlists.EXTERNAL_CONTENT_URI,
                        null, null, null, null);
                if (c != null) {
                    // The external media database is now ready for querying
                    // (though it may still be in the process of being filled).
                    c.close();
                    setResult(RESULT_OK);
                    finish();
                    return;
                }
                Message next = obtainMessage(CHECK);
                sendMessageDelayed(next, 3000);
            }
        }

