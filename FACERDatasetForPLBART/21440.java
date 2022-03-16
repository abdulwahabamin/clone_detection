    @Override
    public void onMetaChanged() {
        super.onMetaChanged();
        if (mAdapter != null)
            mAdapter.notifyDataSetChanged();
    }

