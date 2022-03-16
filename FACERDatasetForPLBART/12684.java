    /**
     * Method that manage a check changed event
     *
     * @param buttonView The checkbox
     * @param isChecked If the checkbox is checked
     */
    private void onNoMediaCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (this.mIgnoreCheckEvents) {
            this.mIgnoreCheckEvents = false;
            return;
        }
        // Checked means "skip media scan"
        final File nomedia = FileHelper.getNoMediaFile(this.mFso);
        if (isChecked) {
            preventMediaScan(nomedia);
        } else {
            allowMediaScan(nomedia);
        }
    }

