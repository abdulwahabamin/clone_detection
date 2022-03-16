    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mediaBrowser != null)
            mediaBrowser.disconnect();
    }

