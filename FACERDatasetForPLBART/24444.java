    @Override
    public void onStop() {
        super.onStop();
        getActivity().unregisterReceiver(mNowPlayingListener);
        listScrolled = false;
    }

