    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.playqueue_play_now: {
                if (service != null) service.setQueuePosition(mSelectedPosition);
                return true;
            }

            case R.id.playqueue_new_playlist: {
                CreatePlaylist.showMe(getActivity(), new long[]{mSelectedId});
                return true;
            }

            case R.id.playqueue_selected_playlist: {
                long playlist = item.getIntent().getLongExtra("playlist", 0);
                MusicUtils.addToPlaylist(getActivity(), new long[]{mSelectedId}, playlist);
                return true;
            }

            case R.id.playqueue_delete: {
                final long[] list = new long[1];
                list[0] = (int) mSelectedId;
                String f = getString(R.string.delete_song_desc);
                String desc = String.format(f,
                        playQueueCursor.getString(playQueueCursor.getColumnIndexOrThrow(MediaStore.Audio.AudioColumns.TITLE)));

                new AlertDialog.Builder(getActivity())
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle(R.string.delete_song_title)
                        .setMessage(desc)
                        .setNegativeButton(R.string.cancel, (dialog, which) -> {
                        })
                        .setPositiveButton(R.string.delete_confirm_button_text, (dialog, which) ->
                                MusicUtils.deleteTracks(PlayQueueFragment.this.getActivity(), list))
                        .show();
                return true;
            }

            case R.id.playqueue_info:
                TrackInfoFragment.showMe(getActivity(),
                        ContentUris.withAppendedId(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, mSelectedId));

                return true;

            case R.id.playqueue_share_via:
                startActivity(MusicUtils.shareVia(
                        mSelectedId,
                        playQueueCursor.getString(playQueueCursor.getColumnIndexOrThrow(MediaStore.Audio.AudioColumns.MIME_TYPE)),
                        getResources()));
                return true;

            case R.id.playqueue_search_for:
                startActivity(MusicUtils.searchForTrack(
                        playQueueCursor.getString(playQueueCursor.getColumnIndexOrThrow(MediaStore.Audio.AudioColumns.TITLE)),
                        playQueueCursor.getString(playQueueCursor.getColumnIndexOrThrow(MediaStore.Audio.AudioColumns.ARTIST)),
                        playQueueCursor.getString(playQueueCursor.getColumnIndexOrThrow(MediaStore.Audio.AudioColumns.ALBUM)),
                        getResources()));
                return true;
        }
        return super.onContextItemSelected(item);
    }

