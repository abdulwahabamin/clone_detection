    @Override
    public void onPause() {
        getActivity().unregisterReceiver(mStatusListener);

        super.onPause();
    }

