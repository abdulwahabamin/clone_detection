    /**
     * Check the preferences status
     */
    @SuppressWarnings("deprecation")
    private void updatePreferences() {
        boolean secureStorageExists = SecureConsole.getSecureStorageRoot().getFile().exists();
        if (mResetPassword != null) {
            mResetPassword.setEnabled(secureStorageExists);
        }
        if (mDeleteStorage != null) {
            mDeleteStorage.setEnabled(secureStorageExists);
        }
    }

