    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.tracks_shuffle_playlist: {
                new ShufflePlaylistTask(getActivity().getApplicationContext()).execute(
                        playlist, MusicUtils.getSongListForCursor(adapter.getCursor()));
                return true;
            }

            case R.id.tracks_uniqueify_playlist: {
                long[] songs = MusicUtils.getSongListForCursor(adapter.getCursor());
                Set<Long> found = new HashSet<>();
                for (int i = 0; i < songs.length; i++) {
                    if (!found.add(songs[i])) {
                        removePlaylistItem(i);
                    }
                }
                return true;
            }

            case R.id.tracks_play_all_now: {
                MusicUtils.playAll(getActivity(), MusicUtils.getSongListForCursor(adapter.getCursor()));
                return true;
            }

            case R.id.tracks_play_all_next: {
                MusicUtils.queueNext(getActivity(), MusicUtils.getSongListForCursor(adapter.getCursor()));
                return true;
            }

            case R.id.tracks_queue_all: {
                MusicUtils.queue(getActivity(), MusicUtils.getSongListForCursor(adapter.getCursor()));
                return true;
            }

            case R.id.tracks_interleave_all: {
                Intent intent = item.getIntent();
                int currentCount = intent.getIntExtra(CURRENT_COUNT, 0);
                int newCount = intent.getIntExtra(NEW_COUNT, 0);
                long[] songs = MusicUtils.getSongListForCursor(adapter.getCursor());
                MusicUtils.interleave(getActivity(), songs, currentCount, newCount);
                return true;
            }

            case R.id.tracks_new_playlist: {
                CreatePlaylist.showMe(getActivity(), MusicUtils.getSongListForCursor(adapter.getCursor()));
                return true;
            }

            case R.id.tracks_selected_playlist: {
                long[] songs = MusicUtils.getSongListForCursor(adapter.getCursor());
                long playlist = item.getIntent().getLongExtra("playlist", 0);
                MusicUtils.addToPlaylist(getActivity(), songs, playlist);
                return true;
            }

            case R.id.tracks_delete_all: {
                final long[] songs = MusicUtils.getSongListForCursor(adapter.getCursor());
                String f = getString(R.string.delete_category_desc);
                String desc = String.format(f, getActivity().getTitle());
                new AlertDialog.Builder(getActivity())
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle(R.string.delete_songs_title)
                        .setMessage(desc)
                        .setNegativeButton(R.string.cancel, (dialog, which) -> { })
                        .setPositiveButton(R.string.delete_confirm_button_text, (dialog, which) ->
                                MusicUtils.deleteTracks(TrackFragment.this.getActivity(), songs))
                        .show();
                return true;
            }

            case R.id.tracks_search_for_category:
                startActivity(MusicUtils.searchForCategory(getActivity().getTitle(),
                        MediaStore.Audio.Media.CONTENT_TYPE, getResources()));
                return true;

            case R.id.tracks_edit_playlist:
                new AlertDialog.Builder(getActivity())
                        .setTitle(R.string.weekpicker_title)
                        .setItems(R.array.weeklist, (dialog, which) -> {
                            int numweeks = which + 1;
                            MusicUtils.setIntPref(TrackFragment.this.getActivity(), SettingsActivity.NUMWEEKS,
                                    numweeks);
                            getLoaderManager().restartLoader(0, null, TrackFragment.this);
                        })
                        .show();
                return true;

            case R.id.tracks_export_playlist:
                new ExportPlaylistTask(getActivity().getApplicationContext()).execute(getActivity().getTitle(), playlist, false);
                return true;

            case R.id.tracks_share_playlist:
                new ExportPlaylistTask(getActivity().getApplicationContext()).execute(getActivity().getTitle(), playlist, true);
                return true;
        }
        return false;
    }

