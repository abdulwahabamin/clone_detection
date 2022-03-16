    private void setupProgressBar(Context cxt) {
        if(mProgressBar == null) {
            mProgressBar = new ProgressDialog(cxt);
            mProgressBar.setCancelable(true);
            mProgressBar.setMessage("Transferring data ...");
            mProgressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            mProgressBar.setMax(1024 * 1024);
        }
    }

