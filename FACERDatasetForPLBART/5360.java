    @Override
    protected void onNewIntent(Intent intent) {
        errorText.setVisibility(View.GONE);
        back.setVisibility(View.GONE);
        setIntent(intent);
        handleIntent(intent);
    }

