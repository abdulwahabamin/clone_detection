    @Override
    public void onLoadFinished(Loader<List<ListRow>> loader, List<ListRow> data) {
        adapter = new ArrayObjectAdapter(new ListRowPresenter());

        if (null != data && !data.isEmpty()) {
            CategoryCardPresenter presenter = new CategoryCardPresenter();
            for (ListRow row : data) {
                row.getAdapter().setPresenterSelector(new SinglePresenterSelector(presenter));
                adapter.add(row);
            }
        } else {
            Log.e(TAG, "An error occurred fetching music");
            Toast.makeText(getActivity(), R.string.error_fetching_music, Toast.LENGTH_LONG).show();
        }

        ArrayObjectAdapter rowAdapter = new ArrayObjectAdapter(new ActionCardPresenter());

        rowAdapter.add(new SettingsItem(R.id.settings_action, getString(R.string.settings)));
        if (getActivity().getPackageManager().resolveActivity(new Intent(AudioEffect.ACTION_DISPLAY_AUDIO_EFFECT_CONTROL_PANEL), 0) != null) {
            rowAdapter.add(new SettingsItem(R.id.effectspanel_action, getString(R.string.effectspanel)));
        }
        rowAdapter.add(new SettingsItem(R.id.select_music_folder_action, getString(R.string.music_folder)));
        rowAdapter.add(new SettingsItem(R.id.about_action, getString(R.string.about)));

        adapter.add(new ListRow(new HeaderItem(R.id.settings_section, getString(R.string.settings)), rowAdapter));

        setAdapter(adapter);
    }

