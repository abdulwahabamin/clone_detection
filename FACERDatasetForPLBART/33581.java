    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if (context != null) {
            progressDialog = new ProgressDialog(context);
            progressDialog.setMessage(context.getResources().getString(
                    R.string.loading_message));
            progressDialog.setIndeterminate(false);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setCancelable(true);
            progressDialog.setOnCancelListener(new OnCancelListener() {

                @Override
                public void onCancel(DialogInterface arg0) {
                    progressDialog.dismiss();
                }
            });

            progressDialog.show();
        }
    }

