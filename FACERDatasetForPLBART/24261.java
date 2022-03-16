    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.folder_play_all_now:
                MusicUtils.playAll(getActivity(), fetchSongList(mCurrentFolder));
                return true;

            case R.id.folder_play_all_next:
                MusicUtils.queueNext(getActivity(), fetchSongList(mCurrentFolder));
                return true;

            case R.id.folder_queue_all:
                MusicUtils.queue(getActivity(), fetchSongList(mCurrentFolder));
                return true;

            case R.id.folder_interleave_all:
                Intent intent = item.getIntent();
                int currentCount = intent.getIntExtra(CURRENT_COUNT, 0);
                int newCount = intent.getIntExtra(NEW_COUNT, 0);
                MusicUtils.interleave(getActivity(), fetchSongList(mCurrentFolder), currentCount, newCount);
                return true;

            case R.id.folder_new_playlist:
                CreatePlaylist.showMe(getActivity(), fetchSongList(mCurrentFolder));
                return true;

            case R.id.folder_selected_playlist:
                long playlist = item.getIntent().getLongExtra("playlist", 0);
                MusicUtils.addToPlaylist(getActivity(), fetchSongList(mCurrentFolder), playlist);
                return true;

            case R.id.folder_delete_all:
                final long [] list = fetchSongList(mCurrentFolder);
                String f = getString(R.string.delete_folder_desc);
                String desc = String.format(f, mCurrentFolder);

                new AlertDialog.Builder(getActivity())
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle(R.string.delete_songs_title)
                        .setMessage(desc)
                        .setNegativeButton(R.string.cancel, (dialog, which) -> { })
                        .setPositiveButton(R.string.delete_confirm_button_text, (dialog, which) ->
                                MusicUtils.deleteTracks(FolderFragment.this.getActivity(), list))
                        .show();
                return true;
        }
        return super.onContextItemSelected(item);
    }

