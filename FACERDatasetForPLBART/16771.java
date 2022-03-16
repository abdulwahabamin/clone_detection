    public void onConnected() {
        if (isDetached()) {
            return;
        }
        if (mediaId == null) {
            mediaId = mediaBrowserProvider.getMediaBrowser().getRoot();
        }

        // Unsubscribing before subscribing is required if this mediaId already has a subscriber
        // on this MediaBrowser instance. Subscribing to an already subscribed mediaId will replace
        // the callback, but won't trigger the initial callback.onChildrenLoaded.
        //
        // This is temporary: A bug is being fixed that will make subscribe
        // consistently call onChildrenLoaded initially, no matter if it is replacing an existing
        // subscriber or not. Currently this only happens if the mediaID has no previous
        // subscriber or if the media content changes on the service side, so we need to
        // unsubscribe first.
        mediaBrowserProvider.getMediaBrowser().unsubscribe(mediaId);

        mediaBrowserProvider.getMediaBrowser().subscribe(mediaId, subscriptionCallback);
    }

