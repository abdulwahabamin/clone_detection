    @Override
    public void onDisabled(Context context) {
        super.onDisabled(context);

        Log.d(this.getClass().getSimpleName(), "Disable updates for this widget");
        cancelUpdate(context);
    }

