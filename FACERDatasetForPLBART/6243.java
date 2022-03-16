        public DeleteFilesTask(DocumentInfo... docs) {
            mDocs = docs;
            mProgressDialog = new ProgressDialog(getActivity());
            mProgressDialog.setMessage(getString(R.string.delete_in_progress));
            mProgressDialog.setIndeterminate(true);
            mProgressDialog.setCanceledOnTouchOutside(false);

            mProgressDialog.show();
        }

