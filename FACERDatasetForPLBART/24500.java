    @Override
    public void onServiceDisconnected(ComponentName name) {
        service = null;

        notifyFragmentDisconnected(R.id.browser_fragment);

        finish();
    }

