    @Override
    public void onOldJsonStringRetrieved(final String jsonString,
                                         final WeatherInfoType weatherInfoType, long queryTime) {
        new AlertDialog.Builder(this)
                .setTitle(R.string.dialog_title_no_network_connection)
                .setIcon(R.drawable.ic_alert_error)
                .setMessage(getAlertDialogMessage(queryTime))
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        onRecentJsonStringRetrieved(jsonString, weatherInfoType, false);
                    }
                })
                .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create()
                .show();
    }

