        @Override
        protected void onPostExecute(Throwable result) {
            // Close the waiting dialog
            this.mDialog.dismiss();

            // Check the result (no relaunch, this is responsibility of callable doInBackground)
            if (result != null) {
                ExceptionUtil.translateException(this.mCtx, result, false, false);
            } else {
                //Operation complete.
                this.mCallable.onSuccess();
            }
        }

