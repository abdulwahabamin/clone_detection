    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.track_play_now:
                MusicUtils.queueAndPlayImmediately(getActivity(), new long[]{selectedId});
                return true;

            case R.id.track_play_next:
                MusicUtils.queueNext(getActivity(), new long[]{selectedId});
                return true;

            case R.id.track_queue:
                MusicUtils.queue(getActivity(), new long[]{selectedId});
                return true;

            case R.id.track_new_playlist:
                CreatePlaylist.showMe(getActivity(), new long[]{selectedId});
                return true;

            case R.id.track_selected_playlist:
                long playlist = item.getIntent().getLongExtra("playlist", 0);
                MusicUtils.addToPlaylist(getActivity(), new long[]{selectedId}, playlist);
                return true;

            case R.id.track_delete: {
                final long[] list = new long[1];
                list[0] = (int) selectedId;
                String f = getString(R.string.delete_song_desc);
                String desc = String.format(f, adapter.getCursor().getString(adapter.getCursor().getColumnIndexOrThrow(
                        MediaStore.Audio.AudioColumns.TITLE)));

                new AlertDialog.Builder(getActivity())
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle(R.string.delete_song_title)
                        .setMessage(desc)
                        .setNegativeButton(R.string.cancel, (dialog, which) -> { })
                        .setPositiveButton(R.string.delete_confirm_button_text, (dialog, which) ->
                                MusicUtils.deleteTracks(TrackFragment.this.getActivity(), list))
                        .show();
                return true;
            }

            case R.id.track_remove_from_playlist:
                removePlaylistItem(selectedPosition);
                return true;

            case R.id.track_info:
                TrackInfoFragment.showMe(getActivity(),
                        ContentUris.withAppendedId(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, selectedId));
                return true;

            case R.id.track_share_via:
                startActivity(MusicUtils.shareVia(
                        selectedId,
                        adapter.getCursor().getString(adapter.getCursor().getColumnIndexOrThrow(
                                MediaStore.Audio.AudioColumns.MIME_TYPE)),
                        getResources()
                ));
                return true;

            case R.id.track_search_for_track:
                String currentTrackName = adapter.getCursor().getString(adapter.getCursor().getColumnIndexOrThrow(
                        MediaStore.Audio.AudioColumns.TITLE));

                startActivity(MusicUtils.searchForTrack(
                        currentTrackName,
                        adapter.getCursor().getString(adapter.getCursor().getColumnIndexOrThrow(
                                MediaStore.Audio.AudioColumns.ARTIST)),
                        adapter.getCursor().getString(adapter.getCursor().getColumnIndexOrThrow(
                                MediaStore.Audio.AudioColumns.ALBUM)),
                        getResources()
                ));
                return true;
        }
        return super.onContextItemSelected(item);
    }

