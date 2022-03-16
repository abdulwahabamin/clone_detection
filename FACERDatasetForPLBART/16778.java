    @Override
    public void onStart() {
        super.onStart();
        FireLog.d(TAG, "(++) onStart");
        MediaControllerCompat controller = MediaControllerCompat.getMediaController(getActivity());
        if (controller != null) {
//            onConnected(); // fixing memory leak(call of onMetadataChanged)
        }
    }

