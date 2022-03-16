    @Override
    public void onBackPressed() {
        if (!mBackPressed) {
            mBackPressed = true;
            mHandler.postDelayed(quitProc, 2000);
            showError(getString(R.string.press_to_quit));
        } else {
            super.onBackPressed();
        }
    }

