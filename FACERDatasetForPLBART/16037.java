    @Override
    public void onPause() {
        super.onPause();

        if(shareGroupWeakReference != null
                &&shareGroupWeakReference.get() != null) {
            ShareGroup group = shareGroupWeakReference.get();
            group.unregisterGroupMemberListener(this);
            group.unregisterGroupConnectionListener(this);
        }
    }

