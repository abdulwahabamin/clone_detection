    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        selectedPosition = position;
        adapter.getCursor().moveToPosition(selectedPosition);
        String mimeType = adapter.getCursor().getString(adapter.getCursor().getColumnIndexOrThrow(MediaStore.Audio.AudioColumns.MIME_TYPE));
        if ("artist".equals(mimeType)) {
            viewCategory(MusicContract.Artist.getMembersUri(id));
        } else if ("album".equals(mimeType)) {
            viewCategory(MusicContract.Album.getMembersUri(id));
        } else if (isSong(mimeType)) {
            super.onListItemClick(l, v, position, id);
        }
    }

