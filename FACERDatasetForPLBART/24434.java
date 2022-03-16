    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        if (createShortcut) {
            Intent shortcut = new Intent();
            shortcut.setAction(Intent.ACTION_VIEW);
            shortcut.setData(MusicContract.Playlist.getMembersUri(id));

            Intent intent = new Intent();
            intent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcut);
            intent.putExtra(Intent.EXTRA_SHORTCUT_NAME,
                    adapter.getCursor().getString(adapter.getCursor().getColumnIndexOrThrow(MusicContract.Playlist.NAME)));
            intent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, Intent.ShortcutIconResource.fromContext(
                    getActivity(), R.drawable.ic_launcher_shortcut_music_playlist));

            getActivity().setResult(Activity.RESULT_OK, intent);
            getActivity().finish();
        } else {
            viewCategory(MusicContract.Playlist.getMembersUri(id));
        }
    }

