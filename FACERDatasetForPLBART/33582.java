    @Override
    protected void onCancelled() {
        super.onCancelled();
        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

