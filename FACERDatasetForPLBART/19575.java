    @Override
    public void onFinishBuildingLibrary(AsyncBuildLibraryTask task) {
        mNotifyManager.cancel(mNotificationId);
        stopSelf();

        Toast.makeText(mContext, R.string.finished_scanning_album_art, Toast.LENGTH_LONG).show();

    }

