        @Override
        protected void onPreExecute() {
            FileOutputStream out = null;
            progressDialog = new ProgressDialog(activity);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressDialog.setMessage(activity.getResources().getString(R.string.compressing));
            progressDialog.show();
            progressDialog.setProgress(0);
            try {
                out = new FileOutputStream(new File(fileOut));
                zos = new ZipOutputStream(new BufferedOutputStream(out));
            } catch (FileNotFoundException e) {
                Log.e(TAG, "error while creating ZipOutputStream");
            }
        }

