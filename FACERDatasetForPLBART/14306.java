    @Override
    public void onPause() {

        if (mPlaylistDialog != null && mPlaylistDialog.isShowing()) {
            mPlaylistDialog.dismiss();
        }
        super.onPause();
    }

