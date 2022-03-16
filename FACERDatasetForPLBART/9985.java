        @Override
        protected void onPreExecute() {
            // Create the waiting dialog while doing some stuff on background
            final BackgroundAsyncTask task = this;
            this.mDialog = new MessageProgressDialog(
                    this.mCtx,
                    this.mCallable.getDialogIcon(),
                    this.mCallable.getDialogTitle(),
                    R.string.waiting_dialog_msg,
                    this.mCallable.isDialogCancellable());
            this.mDialog.setOnCancelListener(new MessageProgressDialog.OnCancelListener() {
                @Override
                public boolean onCancel() {
                    mCallable.onCancel();
                    task.cancel(true);
                    return true;
                }
            });
            Spanned progress = this.mCallable.requestProgress();
            this.mDialog.setProgress(progress);
            this.mDialog.show();
        }

