    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.playlist_play_all_now:
                MusicUtils.playAll(getActivity(), fetchSongList(currentId));
                return true;

            case R.id.playlist_play_all_next:
                MusicUtils.queueNext(getActivity(), fetchSongList(currentId));
                return true;

            case R.id.playlist_queue_all:
                MusicUtils.queue(getActivity(), fetchSongList(currentId));
                return true;

            case R.id.playlist_interleave_all:
                Intent intent = item.getIntent();
                int currentCount = intent.getIntExtra(CURRENT_COUNT, 0);
                int newCount = intent.getIntExtra(NEW_COUNT, 0);
                MusicUtils.interleave(getActivity(), fetchSongList(currentId), currentCount, newCount);
                return true;

            case R.id.playlist_new_playlist:
                CreatePlaylist.showMe(getActivity(), fetchSongList(currentId));
                return true;

            case R.id.playlist_selected_playlist: {
                long playlist = item.getIntent().getLongExtra("playlist", 0);
                MusicUtils.addToPlaylist(getActivity(), fetchSongList(currentId), playlist);
                return true;
            }

            case R.id.playlist_delete_playlist:
                String desc = String.format(getString(R.string.delete_playlist_desc),
                        adapter.getCursor().getString(adapter.getCursor().getColumnIndexOrThrow(MusicContract.Playlist.NAME)));
                new AlertDialog.Builder(getActivity())
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle(R.string.delete_playlist_title)
                        .setMessage(desc)
                        .setNegativeButton(R.string.cancel, (dialog, which) -> { })
                        .setPositiveButton(R.string.delete_confirm_button_text, (dialog, which) -> {
                            Uri uri = ContentUris.withAppendedId(
                                    MediaStore.Audio.Playlists.EXTERNAL_CONTENT_URI, currentId);
                            getActivity().getContentResolver().delete(uri, null, null);
                            Toast.makeText(getActivity(), R.string.playlist_deleted_message, Toast.LENGTH_SHORT).show();
                        })
                        .show();
                return true;

            case R.id.playlist_edit_playlist:
                if (currentId == MusicContract.Playlist.RECENTLY_ADDED_PLAYLIST) {
                    new AlertDialog.Builder(getActivity())
                            .setTitle(R.string.weekpicker_title)
                            .setItems(R.array.weeklist, (dialog, which) -> {
                                int numweeks = which + 1;
                                MusicUtils.setIntPref(PlaylistFragment.this.getActivity(), SettingsActivity.NUMWEEKS,
                                        numweeks);
                                getLoaderManager().restartLoader(0, null, PlaylistFragment.this);
                            }).show();
                } else {
                    Log.e(LOGTAG, "should not be here");
                }
                return true;

            case R.id.playlist_rename_playlist: {
                @SuppressLint("InflateParams") View view = getActivity().getLayoutInflater().inflate(R.layout.rename_playlist, null);
                final EditText mPlaylist = (EditText) view.findViewById(R.id.playlist);
                final long playlistId = currentId;

                if (playlistId >= 0 && playlistName != null) {
                    mPlaylist.setText(playlistName);
                    mPlaylist.setSelection(playlistName.length());

                    new AlertDialog.Builder(getActivity())
                            .setTitle(String.format(PlaylistFragment.this.getString(R.string.rename_playlist_prompt),
                                    playlistName))
                            .setView(view)
                            .setNegativeButton(R.string.cancel, (dialog, which) -> { })
                            .setPositiveButton(R.string.create_playlist_create_text, (dialog, which) ->
                                    MusicUtils.renamePlaylist(getActivity(), playlistId, mPlaylist.getText().toString()))
                            .show();
                }
                return true;
            }

            case R.id.playlist_export_playlist:
                new ExportPlaylistTask(getActivity().getApplicationContext()).execute(playlistName, currentId, false);
                return true;

            case R.id.playlist_share_playlist:
                new ExportPlaylistTask(getActivity().getApplicationContext()).execute(playlistName, currentId, true);
                return true;
        }
        return super.onContextItemSelected(item);
    }

