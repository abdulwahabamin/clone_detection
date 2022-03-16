    /**
     * Method that returns to previous activity.
     *
     * @param cancelled Indicates if the activity was cancelled
     * @param item The fso
     * @param isChecked If the fso was fully retrieve previously to this call. Otherwise, a
     * getFileInfo call is done to complete the fso information
     * @hide
     */
    void back(final boolean cancelled, FileSystemObject item, boolean isChecked) {
        final Context ctx = SearchActivity.this;
        boolean finish = true;
        if (cancelled) {
            final Intent intent =  new Intent();
            if (this.mRestoreState != null) {
                Bundle bundle = new Bundle();
                bundle.putParcelable(NavigationActivity.EXTRA_SEARCH_LAST_SEARCH_DATA,
                        (Parcelable)this.mRestoreState);
                intent.putExtras(bundle);
            }
            setResult(RESULT_CANCELED, intent);
        } else {
            // Check that the bookmark exists
            FileSystemObject fso = item;
            try {
                if (!isChecked) {
                    fso = CommandHelper.getFileInfo(ctx, item.getFullPath(), null);
                }
                finish = navigateTo(fso);

            } catch (Exception e) {
                // Capture the exception
                final FileSystemObject fFso = fso;
                final OnRelaunchCommandResult relaunchListener = new OnRelaunchCommandResult() {
                    @Override
                    public void onSuccess() {
                        if (navigateTo(fFso)) {
                            exit();
                        }
                    }
                    @Override
                    public void onFailed(Throwable cause) {
                        ExceptionUtil.translateException(ctx, cause, false, false);
                    }
                    @Override
                    public void onCancelled() { /** NON BLOCK**/}
                };
                ExceptionUtil.translateException(ctx, e, false, true, relaunchListener);
                if (!(e instanceof RelaunchableException)) {
                    if (e instanceof NoSuchFileOrDirectory || e instanceof FileNotFoundException) {
                        // The fso not exists, delete the fso from the search
                        try {
                            removeItem(fso);
                        } catch (Exception ex) {/**NON BLOCK**/}
                    }
                }
                return;
            }
        }

        // End this activity
        if (finish) {
            exit();
        }
    }

