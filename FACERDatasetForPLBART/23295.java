    @Override
    protected void onListItemClick(ListView l, View v, int position, long id)
    {
        mCursor.moveToPosition(position);
        String type = mCursor.getString(mCursor.getColumnIndexOrThrow(
                MediaStore.Audio.Media.MIME_TYPE));

        String action = getIntent().getAction();
        if (Intent.ACTION_GET_CONTENT.equals(action)) {
            Uri uri;

            long mediaId;
            if (type.startsWith("video")) {
                uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                mediaId = mCursor.getLong(mCursor.getColumnIndexOrThrow(
                        MediaStore.Video.Media._ID));
            } else {
                uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                mediaId = mCursor.getLong(mCursor.getColumnIndexOrThrow(
                        MediaStore.Audio.Media._ID));
            }

            setResult(RESULT_OK, new Intent().setData(ContentUris.withAppendedId(uri, mediaId)));
            finish();
            return;
        }

        // Need to stop the playbackservice, in case it is busy playing audio
        // and the user selected a video.
        if (MusicUtils.sService != null) {
            try {
                MusicUtils.sService.stop();
            } catch (RemoteException ex) {
            }
        }
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(ContentUris.withAppendedId(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, id), type);

        startActivity(intent);
    }

