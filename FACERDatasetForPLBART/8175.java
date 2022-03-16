    /**
     * Method that reads the requested file
     */
    private void readFile() {
        // For now editor is not dirty and editable.
        setDirty(false);
        this.mBinary = false;

        // Check for a valid action
        String action = getIntent().getAction();
        if (action == null ||
                (action.compareTo(Intent.ACTION_VIEW) != 0) &&
                (action.compareTo(Intent.ACTION_EDIT) != 0)) {
            DialogHelper.showToast(
                    this, R.string.editor_invalid_file_msg, Toast.LENGTH_SHORT);
            return;
        }
        // This var should be set depending on ACTION_VIEW or ACTION_EDIT action, but for
        // better compatibility, IntentsActionPolicy use always ACTION_VIEW, so we have
        // to ignore this check here
        this.mReadOnly = false;

        // Read the intent and check that is has a valid request
        Intent fileIntent = getIntent();
        if (fileIntent.getData().getScheme().equals("content")) {
            asyncReadContentURI(fileIntent.getData());
            this.mTitle.setText(fileIntent.getDataString());
        } else {
            // File Scheme URI's
            String path = uriToPath(this, getIntent().getData());
            if (path == null || path.length() == 0) {
                DialogHelper.showToast(
                        this, R.string.editor_invalid_file_msg, Toast.LENGTH_SHORT);
                return;
            }

            // Set the title of the dialog
            File f = new File(path);
            this.mTitle.setText(f.getName());

            // Check that the file exists (the real file, not the symlink)
            try {
                this.mFso = CommandHelper.getFileInfo(this, path, true, null);
                if (this.mFso == null) {
                }
            } catch (Exception e) {
                Log.e(TAG, "Failed to get file reference", e); //$NON-NLS-1$
            }

            // Check that we can handle the length of the file (by device)
            if (this.mMaxFileSize < this.mFso.getSize()) {
                DialogHelper.showToast(
                        this, R.string.editor_file_exceed_size_msg, Toast.LENGTH_SHORT);
                return;
            }

            // Get the syntax highlight processor
            SyntaxHighlightFactory shpFactory =
                    SyntaxHighlightFactory.getDefaultFactory(new ResourcesResolver());
            this.mSyntaxHighlightProcessor = shpFactory.getSyntaxHighlightProcessor(f);
            if (this.mSyntaxHighlightProcessor != null) {
                this.mSyntaxHighlightProcessor.initialize();
            }

            // Check that we have read access
            try {
                FileHelper.ensureReadAccess(
                        ConsoleBuilder.getConsole(this),
                        this.mFso,
                        null);

                // Read the file in background
                asyncRead();

            } catch (Exception ex) {
                ExceptionUtil.translateException(
                        this, ex, false, true, new OnRelaunchCommandResult() {
                            @Override
                            public void onSuccess() {
                                // Read the file in background
                                asyncRead();
                            }

                            @Override
                            public void onFailed(Throwable cause) {
                                    finish();
                                }

                            @Override
                            public void onCancelled() {
                                    finish();
                                }
                        });
            }
        }
    }

