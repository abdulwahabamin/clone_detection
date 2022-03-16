    /**
     * Method invoked when an action item is clicked.
     *
     * @param view The button pushed
     */
    public void onActionBarItemClick(View view) {
        switch (view.getId()) {
            case R.id.ab_button0:
                // Save the file
                checkAndWrite();
                break;

            case R.id.ab_button1:
                // Print the file
                StringBuilder sb = mBinary
                        ? ((HexDumpAdapter)mBinaryEditor.getAdapter()).toStringDocument()
                        : new StringBuilder(mEditor.getText().toString());
                PrintActionPolicy.printStringDocument(this, mFso, sb);
                break;

            case R.id.ab_button2:
                // Show overflow menu
                showOverflowPopUp(this.mOptionsAnchorView);
                break;

            default:
                break;
        }
    }

