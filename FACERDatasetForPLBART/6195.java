        @Override
        protected void onPostExecute(DocumentInfo result) {
            if (result != null) {
                // Navigate into newly created child
                mActivity.onDocumentPicked(result);
            } else {
                Toast.makeText(mActivity, R.string.create_error, Toast.LENGTH_SHORT).show();
            }

            mActivity.setPending(false);
        }

