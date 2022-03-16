        @Override
        protected void onPostExecute(Boolean result) {
            mProgressDialog.dismiss();

            if (result == false) {
                Toast.makeText(getActivity(), R.string.toast_failed_delete, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getActivity(), R.string.toast_success_delete, Toast.LENGTH_SHORT).show();
            }

            // Reload files in the current folder
            getLoaderManager().restartLoader(mLoaderId, null, mCallbacks);
            updateDisplayState();
        }

