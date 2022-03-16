    @Override
    protected void onResume() {

        super.onResume();
        if (mPlaylistDialog != null) {
            mPlaylistDialog.show();
        }
    }

