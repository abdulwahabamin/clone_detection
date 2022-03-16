    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
        if (googleApiClient != null) {
            googleApiClient.disconnect();
        }
    }

