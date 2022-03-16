        @Override
        public void afterTextChanged(Editable s) {
            // Validations:
            //  * Key must be MIN_PASSWORD_LENGTH characters or more
            //  * Repeat == Key
            String oldkey = mOldKey.getText().toString();
            String key = mKey.getText().toString();
            String repeatKey = mRepeatKey.getText().toString();
            boolean validLength = key.length() >= MIN_PASSWORD_LENGTH &&
                    (!mResetPassword || (mResetPassword && oldkey.length() >= MIN_PASSWORD_LENGTH));
            boolean validEquals = key.equals(repeatKey);

            if (!validLength) {
                mValidationMsg.setText(getString(R.string.secure_storage_unlock_validation_length,
                        MIN_PASSWORD_LENGTH));
                mValidationMsg.setVisibility(View.VISIBLE);
                mUnlock.setEnabled(false);
            } else if ((mNewStorage || mResetPassword) && !validEquals) {
                mValidationMsg.setText(R.string.secure_storage_unlock_validation_equals);
                mValidationMsg.setVisibility(View.VISIBLE);
                mUnlock.setEnabled(false);
            } else {
                mValidationMsg.setVisibility(View.INVISIBLE);
                mUnlock.setEnabled(true);
            }
        }

