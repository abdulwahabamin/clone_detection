    @Override
    protected void onStop() {
        super.onStop();
        if(documentSubscription!=null)
            documentSubscription.cancel();
        if(mediaSubscription!=null)
            mediaSubscription.cancel();
    }

