        @Override
        @SuppressWarnings("deprecation")
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            // Check with java.io.File instead of TFile because TFile#exists() will
            // check for password key, which is currently locked
            mNewStorage = !SecureConsole.getSecureStorageRoot().getFile().exists();
            mResetPassword = sResetInProgress;
            mDeleteStorage = sDeleteInProgress;

            // Set the theme before setContentView
            Theme theme = ThemeManager.getCurrentTheme(this);
            theme.setBaseTheme(this, true);

            // Load the dialog's custom layout
            ViewGroup v = (ViewGroup) LayoutInflater.from(this).inflate(
                    R.layout.unlock_dialog_message, null);
            mMessage = (TextView) v.findViewById(R.id.unlock_dialog_message);
            mOldKey = (EditText) v.findViewById(R.id.unlock_old_password);
            mOldKey.addTextChangedListener(this);
            mKey = (EditText) v.findViewById(R.id.unlock_password);
            mKey.addTextChangedListener(this);
            mRepeatKey = (EditText) v.findViewById(R.id.unlock_repeat);
            mRepeatKey.addTextChangedListener(this);
            View oldPasswordLayout = v.findViewById(R.id.unlock_old_password_layout);
            View repeatLayout = v.findViewById(R.id.unlock_repeat_layout);
            mValidationMsg = (TextView) v.findViewById(R.id.unlock_validation_msg);

            // Load resources
            int messageResourceId = R.string.secure_storage_unlock_key_prompt_msg;
            int positiveButtonLabelResourceId = R.string.secure_storage_unlock_button;
            String title = getString(R.string.secure_storage_unlock_title);
            if (mNewStorage) {
                positiveButtonLabelResourceId = R.string.secure_storage_create_button;
                title = getString(R.string.secure_storage_create_title);
                messageResourceId = R.string.secure_storage_unlock_key_new_msg;
            } else if (mResetPassword) {
                positiveButtonLabelResourceId = R.string.secure_storage_reset_button;
                title = getString(R.string.secure_storage_reset_title);
                messageResourceId = R.string.secure_storage_unlock_key_reset_msg;
                TextView passwordLabel = (TextView) v.findViewById(R.id.unlock_password_title);
                passwordLabel.setText(R.string.secure_storage_unlock_new_key_title);
            } else if (mDeleteStorage) {
                positiveButtonLabelResourceId = R.string.secure_storage_delete_button;
                title = getString(R.string.secure_storage_delete_title);
                messageResourceId = R.string.secure_storage_unlock_key_delete_msg;
            }

            // Set the message according to the storage creation status
            mMessage.setText(messageResourceId);
            repeatLayout.setVisibility(mNewStorage || mResetPassword ? View.VISIBLE : View.GONE);
            oldPasswordLayout.setVisibility(mResetPassword ? View.VISIBLE : View.GONE);

            // Set validation msg
            mValidationMsg.setText(getString(R.string.secure_storage_unlock_validation_length,
                    MIN_PASSWORD_LENGTH));
            mValidationMsg.setVisibility(View.VISIBLE);

            // Create the dialog
            mDialog = DialogHelper.createTwoButtonsDialog(this,
                    positiveButtonLabelResourceId, R.string.cancel,
                    theme.getResourceId(this,"ic_secure_drawable"), title, v, this);
            mDialog.setOnDismissListener(new OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    mDialog.dismiss();
                    finish();

                    // Unlock the wait
                    synchronized (WAIT_SYNC) {
                        WAIT_SYNC.notify();
                    }
                }
            });
            mDialog.setOnCancelListener(new OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {
                    sUnlockKeyTemp = null;
                    mDialog.cancel();
                    finish();

                    // Unlock the wait
                    synchronized (WAIT_SYNC) {
                        WAIT_SYNC.notify();
                    }
                }
            });
            mDialog.setCanceledOnTouchOutside(false);

            // Apply the theme to the custom view of the dialog
            applyTheme(this, v);
        }

