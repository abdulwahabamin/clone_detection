    private void showNoRationale() {
        View rootView = ((Activity) mContext).getWindow().getDecorView().findViewById(R.id.fragment);
        Snackbar.make(rootView , mContext.getString(R.string.rationale_string) , Snackbar.LENGTH_INDEFINITE)
                .setAction(mContext.getString(R.string.settings), new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        final Intent i = new Intent();
                        i.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                        i.addCategory(Intent.CATEGORY_DEFAULT);
                        i.setData(Uri.parse("package:" + mContext.getApplicationContext().getPackageName()));
                        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        i.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                        i.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
                        mContext.startActivity(i);
                    }
                })
                .show();
        Log.i("Permissions" , "showNoRationale");
    }

