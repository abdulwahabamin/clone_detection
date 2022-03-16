    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (service == null) return false;

        switch (item.getItemId()) {
            case R.id.playerheader_new_playlist:
                CreatePlaylist.showMe(getActivity(), new long[] { service.getAudioId() });
                return true;

            case R.id.playerheader_selected_playlist: {
                long [] list = new long[1];
                list[0] = service.getAudioId();
                long playlist = item.getIntent().getLongExtra("playlist", 0);
                MusicUtils.addToPlaylist(getActivity(), list, playlist);
                return true;
            }

            case R.id.playerheader_delete: {
                final long [] list = new long[1];
                list[0] = service.getAudioId();
                String f = getString(R.string.delete_song_desc, service.getTrackName());
                new AlertDialog.Builder(getActivity())
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle(R.string.delete_song_title)
                        .setMessage(f)
                        .setNegativeButton(R.string.cancel, (dialog, which) -> { })
                        .setPositiveButton(R.string.delete_confirm_button_text, (dialog, which) ->
                                MusicUtils.deleteTracks(PlayerHeaderFragment.this.getActivity(), list))
                        .show();
                return true;
            }

            case R.id.playerheader_info:
                TrackInfoFragment.showMe(getActivity(),
                        ContentUris.withAppendedId(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, service.getAudioId()));
                return true;

            case R.id.playerheader_share_via: {
                startActivity(MusicUtils.shareVia(
                        service.getAudioId(),
                        service.getMimeType(),
                        getResources()));
                return true;
            }

            case R.id.playerheader_search_for:
                startActivity(MusicUtils.searchForTrack(
                        service.getTrackName(),
                        service.getArtistName(),
                        service.getAlbumName(),
                        getResources()));
                return true;
        }
        return super.onContextItemSelected(item);
    }

