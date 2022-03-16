    @Override
    public void onDisabled(Context context) {
        super.onDisabled(context);

        Log.d(TAG, "Disable simple widget updates");
        cancelUpdate(context);
    }

