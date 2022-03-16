    /**
     * Handle a change notification coming over from {@link MobileMediaPlaybackService}
     */
    void notifyChange(nu.staldal.djdplayer.MediaPlaybackService service, String what) {
        if (hasInstances(service)) {
            if (nu.staldal.djdplayer.MediaPlaybackService.META_CHANGED.equals(what) ||
                    nu.staldal.djdplayer.MediaPlaybackService.PLAYSTATE_CHANGED.equals(what)) {
                performUpdate(service, null);
            }
        }
    }

