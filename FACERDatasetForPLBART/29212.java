    @Override
    protected void onStart() {
        super.onStart();
        if(activity_flag) {
            initAdapterData();
            mAdapter.notifyDataSetChanged();

        }
        activity_flag=true;
    }

