    @Override
    public void onAllowNotification(boolean allow) {
        if (!allow) {
            RemoteViewsHelper.stopNotification(this);
        } else {
            RemoteViewsHelper.showNotification(this);
        }
    }

