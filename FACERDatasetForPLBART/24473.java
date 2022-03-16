    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        selectedPosition = position;
        adapter.getCursor().moveToPosition(selectedPosition);
        try {
            int id_idx = adapter.getCursor().getColumnIndexOrThrow(MediaStore.Audio.Playlists.Members.AUDIO_ID);
            selectedId = adapter.getCursor().getLong(id_idx);
        } catch (IllegalArgumentException ex) {
            selectedId = id;
        }

        if (isPicking()) {
            getActivity().setResult(Activity.RESULT_OK, new Intent().setData(
                    ContentUris.withAppendedId(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, selectedId)));
            getActivity().finish();
        } else {
            MusicUtils.playSong(getActivity(), selectedId);
        }
    }

