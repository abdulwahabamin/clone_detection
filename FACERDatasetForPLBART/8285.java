    /**
     * {@inheritDoc}
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case RESULT_CROP_IMAGE:
                // Return what the callee activity returns
                setResult(resultCode, data);
                finish();
                return;

            default:
                break;
        }

        // The response is not understood
        Log.w(TAG,
                String.format(
                        "Ignore response. requestCode: %s, resultCode: %s, data: %s", //$NON-NLS-1$
                        Integer.valueOf(requestCode),
                        Integer.valueOf(resultCode),
                        data));
        DialogHelper.showToast(this, R.string.msgs_operation_failure, Toast.LENGTH_SHORT);
    }

