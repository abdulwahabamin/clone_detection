    private void detectLocation() {
        if (WidgetRefreshIconService.isRotationActive) {
            return;
        }
        mProgressDialog = new ProgressDialog(MainActivity.this);
        mProgressDialog.setMessage(getString(R.string.progressDialog_gps_locate));
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setCancelable(false);
        mProgressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, getString(android.R.string.cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try {
                    dialog.dismiss();
                } catch (SecurityException e) {
                    appendLog(MainActivity.this, TAG, "Cancellation error", e);
                }
            }
        });

        updateNetworkLocation();
        mProgressDialog.show();
        refreshDialogHandler = new Handler(Looper.getMainLooper());
    }

