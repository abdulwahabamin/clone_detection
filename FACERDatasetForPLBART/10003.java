    /**
     * Method that checks if it is necessary to display a warning dialog because
     * the privileged extraction of a zip file.
     *
     * @param ctx The current context
     * @param task The task
     * @param fso The zip file
     * @hide
     */
    static void checkZipSecurityWarning(
            final Context ctx, final BackgroundAsyncTask task, FileSystemObject fso) {
        // WARNING! Extracting a ZIP file with relatives or absolutes path could break
        // the system and is need a security alert that the user can confirm prior to
        // make the extraction
        String ext = FileHelper.getExtension(fso);
        if (ConsoleBuilder.isPrivileged() && ext.compareToIgnoreCase("zip") == 0) { //$NON-NLS-1$
            AlertDialog dialog = DialogHelper.createYesNoDialog(
                ctx,
                R.string.confirm_overwrite,
                R.string.security_warning_extract,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface alertDialog, int which) {
                        if (which == DialogInterface.BUTTON_POSITIVE) {
                            // Execute background task
                            task.execute(task);
                        }
                    }
               });
            dialog.show();
        } else {
            // Execute background task
            task.execute(task);
        }
    }

