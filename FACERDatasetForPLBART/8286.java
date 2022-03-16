    /**
     * {@inheritDoc}
     */
    @Override
    public void onDismiss(DialogInterface dialog) {
        if (this.mFso != null) {
            File src = new File(this.mFso.getFullPath());
            if (getIntent().getExtras() != null) {
                // Some AOSP applications use the gallery to edit and crop the selected image
                // with the Gallery crop editor. In this case pass the picked file to the
                // CropActivity with the requested parameters
                // Expected result is on onActivityResult
                Bundle extras = getIntent().getExtras();
                String crop = extras.getString(EXTRA_CROP);
                if (Boolean.parseBoolean(crop)) {
                    // We want to use the Gallery3d activity because we know about it, and his
                    // parameters. At least we have a compatible one.
                    Intent intent = new Intent(ACTION_CROP);
                    if (getIntent().getType() != null) {
                        intent.setType(getIntent().getType());
                    }
                    intent.setData(Uri.fromFile(src));
                    intent.putExtras(extras);
                    intent.setComponent(CROP_COMPONENT);
                    try {
                        startActivityForResult(intent, RESULT_CROP_IMAGE);
                        return;
                    } catch (ActivityNotFoundException e) {
                        Log.w(TAG, "Failed to find crop activity!");
                    }
                    intent.setComponent(null);
                    try {
                        startActivityForResult(intent, RESULT_CROP_IMAGE);
                        return;
                    } catch (ActivityNotFoundException e) {
                        Log.w(TAG, "Failed to find any crop activity!");
                    }
                }
            }

            if (INTENT_FOLDER_SELECT.equals(getIntent().getAction())) {
                Intent result = new Intent();
                result.putExtra(EXTRA_FOLDER_PATH, src.getAbsolutePath());
                setResult(Activity.RESULT_OK, result);
                finish();
                return;
            }

            // Return the picked file, as expected (this activity should fill the intent data
            // and return RESULT_OK result)
            Intent result = new Intent();
            result.setData(getResultUriForFileFromIntent(this, src, getIntent()));
            setResult(Activity.RESULT_OK, result);
            finish();

        } else {
            cancel();
        }
    }

