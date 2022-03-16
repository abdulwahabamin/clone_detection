    @Override
    protected void onDestroy() {
        if (mediaBrowser != null)
            mediaBrowser.disconnect();
        super.onDestroy();
    }

