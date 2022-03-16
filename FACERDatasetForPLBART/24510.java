    @Override
    public void onItemClicked(Presenter.ViewHolder itemViewHolder, Object o,
                              RowPresenter.ViewHolder rowViewHolder, Row row) {
        if (o instanceof CategoryItem) {
            CategoryItem item = (CategoryItem) o;
            Intent intent = new Intent(Intent.ACTION_VIEW);
            switch ((int)row.getId()) {
                case R.id.artists_section:
                    Log.d(TAG, "artist: " + item.toString());
                    intent.setData(MusicContract.Artist.getMembersUri(item.id));
                    break;

                case R.id.albums_section:
                    Log.d(TAG, "album: " + item.toString());
                    intent.setData(MusicContract.Album.getMembersUri(item.id));
                    break;

                case R.id.genres_sections:
                    Log.d(TAG, "genre: " + item.toString());
                    intent.setData(MusicContract.Genre.getMembersUri(item.id));
                    break;

                case R.id.folders_section:
                    Log.d(TAG, "folder: " + item.toString());
                    intent.setData(MusicContract.Folder.getMembersUri(((FolderItem)item).path));
                    break;

                case R.id.playlists_section:
                    Log.d(TAG, "playlist: " + item.toString());
                    intent.setData(MusicContract.Playlist.getMembersUri(item.id));
                    break;
            }
            intent.putExtra(CategoryDetailsActivity.TITLE, item.name);
            intent.setClass(getActivity(), CategoryDetailsActivity.class);
            startActivity(intent);
        } else if (o instanceof SettingsItem) {
            SettingsItem item = (SettingsItem) o;
            switch ((int)item.id) {
                case R.id.settings_action:
                    startActivity(new Intent(getActivity(), SettingsActivity.class));
                    break;

                case R.id.effectspanel_action:
                    Intent intent = new Intent(AudioEffect.ACTION_DISPLAY_AUDIO_EFFECT_CONTROL_PANEL);
                    intent.putExtra(AudioEffect.EXTRA_AUDIO_SESSION, service.getAudioSessionId());
                    startActivityForResult(intent, 0);
                    break;

                case R.id.select_music_folder_action:
                    startActivity(new Intent(getActivity(), PickMusicFolderActivity.class));
                    break;

                case R.id.about_action:
                    startActivity(new Intent(getActivity(), AboutActivity.class));
                    break;
            }
        }
    }

