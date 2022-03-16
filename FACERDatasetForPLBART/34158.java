    @Override
    public void onDisabled(Context context) {
        super.onDisabled(context);

        Log.d(TAG, "Disable time widget updates");
        cancelUpdate(context);
    }

