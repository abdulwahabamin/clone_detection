        @Override
        public void onAttachedToWindow() {
            super.onAttachedToWindow();

            DialogHelper.delegateDialogShow(this, mDialog);
            mUnlock = mDialog.getButton(DialogInterface.BUTTON_POSITIVE);
            mUnlock.setEnabled(false);
        }

