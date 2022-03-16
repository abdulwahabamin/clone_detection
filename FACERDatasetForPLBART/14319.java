    @Override
    protected void onResume() {

        super.onResume();
        if (mPlayListPickerDialog != null && !mPlayListPickerDialog.isShowing()) {
            mPlayListPickerDialog.show();
        }
    }

