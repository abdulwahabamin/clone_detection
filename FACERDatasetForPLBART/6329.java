        public CopyOrCutFilesTask(DocumentInfo... docs) {
            mDocs = docs;
            mIsCopy = mClipboardIsCopy;
            mProgressDialog = new ProgressDialog(DocumentsActivity.this);
            mProgressDialog.setMessage(getString(R.string.copy_in_progress));
            mProgressDialog.setIndeterminate(false);
            mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            mProgressDialog.setMax(docs.length);
            mProgressDialog.setProgress(0);
            mProgressDialog.setCanceledOnTouchOutside(false);

            mProgressDialog.show();
        }

