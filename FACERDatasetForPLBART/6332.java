        @Override
        protected void onPostExecute(Void result) {
            mProgressDialog.dismiss();

             // Notify that files were copied
            final Resources r = getResources();
            Toast.makeText(DocumentsActivity.this,
                r.getQuantityString(R.plurals.files_pasted, mDocs.length, mDocs.length),
                Toast.LENGTH_SHORT).show();

            // Update the action bar buttons
            invalidateOptionsMenu();

            // Hack to refresh the contents.
            DirectoryFragment.get(getFragmentManager()).onUserSortOrderChanged();
        }

