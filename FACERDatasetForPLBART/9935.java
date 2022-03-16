    /**
     * Method invoked when the user press ok, or Enter key
     */
    private void done() {
        //Check that the directory is a valid directory
        String newInitialDir = this.mAutocomplete.getText().toString();
        try {
            if (!newInitialDir.endsWith(File.separator)) {
                newInitialDir += File.separator;
            }
            Preferences.savePreference(
                    FileManagerSettings.SETTINGS_INITIAL_DIR, newInitialDir, true);
            if (this.mOnValueChangedListener != null) {
                this.mOnValueChangedListener.onValueChanged(newInitialDir);
            }
        } catch (Throwable ex) {
            Log.e(TAG, "The save initial directory setting operation fails", ex); //$NON-NLS-1$
            DialogHelper.showToast(
                    this.mContext,
                    R.string.initial_directory_error_msg,
                    Toast.LENGTH_LONG);
        }
    }

