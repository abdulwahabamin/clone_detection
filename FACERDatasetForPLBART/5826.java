        @Override
        protected void onPreExecute() {
            progressDialog = new ProgressDialog(activity);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressDialog.setMessage(activity.getResources().getString(R.string.extracting));
            progressDialog.show();
            progressDialog.setProgress(0);
            isExtracted = 0;
        }

