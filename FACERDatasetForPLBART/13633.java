    @Override
    public void onAdapterItemClick(View view, int position) {
        AppModel appModel = adapter.getItem(position);
        Intent intent = appModel.getLaunchIntent();
        if (intent == null) {
            Snackbar.make(view, "Could not launch App", Snackbar.LENGTH_LONG)
                    .show();
        } else {
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        }
    }

