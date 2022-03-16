    protected void deleteAll() {
        final long[] songs = fetchSongList(mCurrentId);
        String f = getString(getDeleteDescStringId());
        String desc = String.format(f, mCurrentName);
        new AlertDialog.Builder(getActivity())
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle(R.string.delete_songs_title)
                .setMessage(desc)
                .setNegativeButton(R.string.cancel, (dialog, which) -> { })
                .setPositiveButton(R.string.delete_confirm_button_text, (dialog, which) ->
                        MusicUtils.deleteTracks(MetadataCategoryFragment.this.getActivity(), songs))
                .show();
    }

