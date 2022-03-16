    @Override
    public void onResume() {
        super.onResume();

        if(shareGroupWeakReference != null
                &&shareGroupWeakReference.get() != null) {
            ShareGroup group = shareGroupWeakReference.get();
            group.registerGroupMemberListener(this);
            group.registerGroupConnectionListener(this);

            memberListAdapter.notifyDataSetChanged();
        }
    }

