    /**
     * {@inheritDoc}
     */
    @Override
    public void onClick(View v) {
        String digest = ""; //$NON-NLS-1$
        String label = ""; //$NON-NLS-1$
        switch (v.getId()) {
            case R.id.bt_md5_clipboard:
                digest = this.mChecksums[0].getText().toString();
                label = String.format("MD5 Checksum - %s", this.mFso.getFullPath()); //$NON-NLS-1$
                break;
            case R.id.bt_sha1_clipboard:
                digest = this.mChecksums[1].getText().toString();
                label = String.format("SHA-1 Checksum - %s", this.mFso.getFullPath()); //$NON-NLS-1$
                break;

            default:
                break;
        }

        // Copy text to clipboard
        if (this.mClipboardMgr != null) {
            ClipData clip =ClipData.newPlainText(label, digest);
            this.mClipboardMgr.setPrimaryClip(clip);
            DialogHelper.showToast(this.mContext, R.string.copy_text_msg, Toast.LENGTH_SHORT);
        }
    }

