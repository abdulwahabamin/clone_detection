    /**
     * Initialize the activity. This method handles the passed intent, opens
     * the appropriate activity and ends.
     */
    private void init() {
        InputStream is = getApplicationContext().getResources().openRawResource(R.raw.changelog);
        if (is == null) {
            Log.e(TAG, "Changelog file not exists"); //$NON-NLS-1$
            finish();
            return;
        }

        try {
            // Read the changelog
            StringBuilder sb = new StringBuilder();
            int read = 0;
            byte[] data = new byte[512];
            while ((read = is.read(data, 0, 512)) != -1) {
                sb.append(new String(data, 0, read));
            }

            // Show a dialog
            AlertDialog dialog = DialogHelper.createAlertDialog(
                this, R.mipmap.ic_launcher_filemanager,
                R.string.changelog_title, sb.toString(), false);
            dialog.setOnCancelListener(this);
            dialog.setOnDismissListener(this);
            DialogHelper.delegateDialogShow(this, dialog);

        } catch (Exception e) {
            Log.e(TAG, "Failed to read changelog file", e); //$NON-NLS-1$
            finish();

        } finally {
            try {
                is.close();
            } catch (Exception e) {/**NON BLOCK**/}
        }
    }

