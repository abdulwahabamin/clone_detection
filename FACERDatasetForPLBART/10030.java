    /**
     * Method that opens a {@link FileSystemObject} with the default registered application
     * by the system, or ask the user for select a registered application.
     *
     * @param ctx The current context
     * @param fso The file system object
     * @param choose If allow the user to select the application to open with
     * @param onDismissListener The dismiss listener
     */
    public static void openFileSystemObject(
            final Context ctx, final FileSystemObject fso, final boolean choose,
            final OnDismissListener onDismissListener) {
        try {
            // Create the intent to open the file
            final Intent intent = new Intent();
            intent.setAction(android.content.Intent.ACTION_VIEW);

            // [NOTE][MSB]: Short circuit to pop up dialog informing user we need to copy out the
            // file until we find a better solution.
            if (fso.isSecure()) {
                // [TODO][MSB]: Check visible cache for existing file but I need to split up
                // resolveIntent function properly for this to be successful
                DialogHelper.createTwoButtonsQuestionDialog(
                        ctx,
                        R.string.ok,
                        R.string.cancel,
                        R.string.warning_title,
                        ctx.getResources().getString(R.string.secure_storage_open_file_warning),
                        new SecureChoiceClickListener(ctx, fso,
                                new ISecureChoiceCompleteListener() {
                                    private boolean isCancelled = false;
                                    @Override
                                    public void onComplete(File cacheFile) {
                                        if (isCancelled) {
                                            return;
                                        }
                                        // Schedule cleanup alarm
                                        SecureCacheCleanupService.scheduleCleanup(ctx);

                                        FileSystemObject cacheFso = FileHelper
                                                .createFileSystemObject(cacheFile);
                                        // Obtain the mime/type and passed it to intent
                                        String mime = MimeTypeHelper.getMimeType(ctx, cacheFso);
                                        if (mime != null) {
                                            intent.setDataAndType(getUriFromFile(ctx, cacheFso),
                                                    mime);
                                        } else {
                                            intent.setData(getUriFromFile(ctx, cacheFso));
                                        }
                                        // Resolve the intent
                                        resolveIntent(
                                                ctx,
                                                intent,
                                                choose,
                                                onDismissListener);
                                    }

                                    @Override
                                    public void onCancelled() {
                                        isCancelled = true;
                                        Toast.makeText(ctx, R.string.cancelled_message, Toast
                                                .LENGTH_SHORT).show();
                                    }
                                }))
                        .show();
                return;
            }

            // Obtain the mime/type and passed it to intent
            String mime = MimeTypeHelper.getMimeType(ctx, fso);
            if (mime != null) {
                intent.setDataAndType(getUriFromFile(ctx, fso), mime);
            } else {
                intent.setData(getUriFromFile(ctx, fso));
            }

            // Resolve the intent
            resolveIntent(ctx, intent, choose, onDismissListener);
        } catch (Exception e) {
            ExceptionUtil.translateException(ctx, e);
        }
    }

