        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which) {
                case DialogInterface.BUTTON_POSITIVE:
                    // Create the AES parameter and set to the prompting view
                    if (mResetPassword) {
                        AesCipherParameters params = new AesCipherParameters();
                        params.setPassword(mOldKey.getText().toString().toCharArray());
                        params.setKeyStrength(KeyStrength.BITS_128);
                        sOldUnlockKeyTemp = params;
                    }
                    AesCipherParameters params = new AesCipherParameters();
                    params.setPassword(mKey.getText().toString().toCharArray());
                    params.setKeyStrength(KeyStrength.BITS_128);
                    sUnlockKeyTemp = params;

                    // We ended with this dialog
                    dialog.dismiss();
                    break;

                case DialogInterface.BUTTON_NEGATIVE:
                    // User had cancelled the dialog
                    dialog.cancel();

                    break;

                default:
                    break;
            }
        }

