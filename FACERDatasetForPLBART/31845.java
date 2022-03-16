    private void setPreviousButton(AlertDialog.Builder settingsAlert, final int labelId) {
        settingsAlert.setNegativeButton(labelId,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        if (labelId == R.string.initial_guide_close) {
                            closeInitialGuideAndCheckPermission();
                        } else {
                            initialGuidePage--;
                            showInitialGuidePage(initialGuidePage);
                        }
                    }
                });
    }

