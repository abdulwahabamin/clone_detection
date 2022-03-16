    public void onConnected() {
        if (isDetached()) {
            return;
        }
        if (mediaId == null) {
            mediaId = mediaBrowserProvider.getMediaBrowser().getRoot();
        }
        mediaBrowserProvider.getMediaBrowser().unsubscribe(mediaId);
        mediaBrowserProvider.getMediaBrowser().subscribe(mediaId, mSubscriptionCallback);
    }

