    @Override
    public void onPause() {

        if (mPlayListPickerDialog != null && mPlayListPickerDialog.isShowing()) {
            mPlayListPickerDialog.dismiss();
        }
        super.onPause();
    }

