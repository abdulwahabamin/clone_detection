        @Override
        public void onChildrenLoaded(@NonNull String parentId,
                                     @NonNull List<MediaBrowserCompat.MediaItem> children) {
            try {
                FireLog.d(TAG, "(++) onChildrenLoaded, parentId=" + parentId + "  count=" + children.size());
                loadView(children);
            } catch (Throwable t) {
                FireLog.e(TAG, "Error onChildrenLoaded", t);
            }
        }

