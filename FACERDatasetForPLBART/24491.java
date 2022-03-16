    private void bindView(Cursor cursor) {
        long id = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Audio.AudioColumns._ID));
        File file = new File(cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.AudioColumns.DATA)));
        String mimeType = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.AudioColumns.MIME_TYPE));
        String title = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.AudioColumns.TITLE));
        String album = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.AudioColumns.ALBUM));
        String artist = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.AudioColumns.ARTIST));
        String composer = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.AudioColumns.COMPOSER));
        int duration = cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.Audio.AudioColumns.DURATION));
        String year = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.AudioColumns.YEAR));
        Date dateAdded = new Date(cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Audio.AudioColumns.DATE_ADDED))*1000);

        ((TextView)getView().findViewById(R.id.title)).setText(title);
        ((TextView)getView().findViewById(R.id.artist)).setText(artist);
        ((TextView)getView().findViewById(R.id.composer)).setText(composer);
        ((TextView)getView().findViewById(R.id.album)).setText(album);
        IdAndName genre = MusicUtils.fetchGenre(getActivity(), id);
        if (genre != null) {
            ((TextView)getView().findViewById(R.id.genre)).setText(genre.name);
        }
        ((TextView)getView().findViewById(R.id.year)).setText(year);
        ((TextView)getView().findViewById(R.id.duration)).setText(MusicUtils.formatDuration(getActivity(), duration));
        ((TextView)getView().findViewById(R.id.folder)).setText(file.getParent());
        ((TextView)getView().findViewById(R.id.filename)).setText(file.getName());
        ((TextView)getView().findViewById(R.id.filesize)).setText(formatFileSize(file.length()));
        ((TextView)getView().findViewById(R.id.mimetype)).setText(mimeType);
        ((TextView)getView().findViewById(R.id.date_added)).setText(formatDate(dateAdded));
        ((TextView)getView().findViewById(R.id.id)).setText(String.valueOf(id));
    }

