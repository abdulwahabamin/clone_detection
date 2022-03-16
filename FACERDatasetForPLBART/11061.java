    /**
     * Method that displays a dialog with a {@link NavigationView} to select the
     * proposed file
     */
    private void init() {
        final boolean pickingDirectory;
        final Intent intent = getIntent();

        if (isFilePickIntent(intent)) {
            // ok
            Log.d(TAG, "PickerActivity: got file pick intent: " + String.valueOf(intent)); //$NON-NLS-1$
            pickingDirectory = false;
        } else if (isDirectoryPickIntent(getIntent())) {
            // ok
            Log.d(TAG, "PickerActivity: got folder pick intent: " + String.valueOf(intent)); //$NON-NLS-1$
            pickingDirectory = true;
        } else {
            Log.d(TAG, "PickerActivity got unrecognized intent: " + String.valueOf(intent)); //$NON-NLS-1$
            setResult(Activity.RESULT_CANCELED);
            finish();
            return;
        }

        // Display restrictions
        Bundle extras = getIntent().getExtras();
        Map<DisplayRestrictions, Object> restrictions = new HashMap<DisplayRestrictions, Object>();
        //- Mime/Type restriction
        String mimeType = getIntent().getType();
        if (mimeType != null) {
            if (!MimeTypeHelper.isMimeTypeKnown(this, mimeType) &&
                !MimeTypeHelper.isAndroidCursorMimeType(mimeType)) {
                Log.i(TAG,
                        String.format(
                                "Mime type %s unknown, falling back to wildcard.", //$NON-NLS-1$
                                mimeType));
                mimeType = MimeTypeHelper.ALL_MIME_TYPES;
            }
            restrictions.put(DisplayRestrictions.MIME_TYPE_RESTRICTION, mimeType);
        } else {
            String[] mimeTypes = getIntent().getStringArrayExtra(Intent.EXTRA_MIME_TYPES);
            if (mimeTypes != null && mimeTypes.length > 0) {
                restrictions.put(DisplayRestrictions.MIME_TYPE_RESTRICTION, mimeTypes);
            }
        }
        // Other restrictions
        Log.d(TAG, "PickerActivity. extras: " + String.valueOf(extras)); //$NON-NLS-1$
        if (extras != null) {
            //-- File size
            if (extras.containsKey(android.provider.MediaStore.Audio.Media.EXTRA_MAX_BYTES)) {
                long size =
                        extras.getLong(android.provider.MediaStore.Audio.Media.EXTRA_MAX_BYTES);
                restrictions.put(DisplayRestrictions.SIZE_RESTRICTION, Long.valueOf(size));
            }
            //-- Local filesystems only
            if (extras.containsKey(Intent.EXTRA_LOCAL_ONLY)) {
                boolean localOnly = extras.getBoolean(Intent.EXTRA_LOCAL_ONLY);
                restrictions.put(
                        DisplayRestrictions.LOCAL_FILESYSTEM_ONLY_RESTRICTION,
                        Boolean.valueOf(localOnly));
            }
        }
        if (pickingDirectory) {
            restrictions.put(DisplayRestrictions.DIRECTORY_ONLY_RESTRICTION, Boolean.TRUE);
        }

        // Create or use the console
        if (!initializeConsole()) {
            // Something when wrong. Display a message and exit
            DialogHelper.showToast(this, R.string.msgs_cant_create_console, Toast.LENGTH_SHORT);
            cancel();
            return;
        }

        // Create the root file
        this.mRootView = getLayoutInflater().inflate(R.layout.picker, null, false);
        this.mRootView.post(new Runnable() {
            @Override
            public void run() {
                measureHeight();
            }
        });

        // Breadcrumb
        Breadcrumb breadcrumb = (Breadcrumb)this.mRootView.findViewById(R.id.breadcrumb_view);
        // Set the free disk space warning level of the breadcrumb widget
        String fds = Preferences.getSharedPreferences().getString(
                FileManagerSettings.SETTINGS_DISK_USAGE_WARNING_LEVEL.getId(),
                (String)FileManagerSettings.SETTINGS_DISK_USAGE_WARNING_LEVEL.getDefaultValue());
        breadcrumb.setFreeDiskSpaceWarningLevel(Integer.parseInt(fds));

        // Navigation view
        this.mNavigationView =
                (NavigationView)this.mRootView.findViewById(R.id.navigation_view);
        this.mNavigationView.setRestrictions(restrictions);
        this.mNavigationView.setOnFilePickedListener(this);
        this.mNavigationView.setOnDirectoryChangedListener(this);
        this.mNavigationView.setBreadcrumb(breadcrumb);

        // Apply the current theme
        applyTheme();

        // Create the dialog
        this.mDialog = DialogHelper.createDialog(
            this, R.mipmap.ic_launcher_filemanager,
            pickingDirectory ? R.string.directory_picker_title : R.string.picker_title,
            this.mRootView);

        this.mDialog.setButton(
                DialogInterface.BUTTON_NEGATIVE,
                getString(R.string.cancel),
                new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dlg, int which) {
                dlg.cancel();
            }
        });
        if (pickingDirectory) {
            this.mDialog.setButton(
                    DialogInterface.BUTTON_POSITIVE,
                    getString(R.string.select),
                    new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dlg, int which) {
                    PickerActivity.this.mFso = PickerActivity.this.mCurrentDirectory;
                    dlg.dismiss();
                }
            });
        }
        this.mDialog.setCancelable(true);
        this.mDialog.setOnCancelListener(this);
        this.mDialog.setOnDismissListener(this);
        DialogHelper.delegateDialogShow(this, this.mDialog);

        // Set content description of storage volume button
        ButtonItem fs = (ButtonItem)this.mRootView.findViewById(R.id.ab_filesystem_info);
        fs.setContentDescription(getString(R.string.actionbar_button_storage_cd));

        final File initialDir = getInitialDirectoryFromIntent(getIntent());
        final String rootDirectory;

        if (initialDir != null) {
            rootDirectory = initialDir.getAbsolutePath();
        } else {
            rootDirectory = FileHelper.ROOT_DIRECTORY;
        }

        this.mHandler = new Handler();
        this.mHandler.post(new Runnable() {
            @Override
            public void run() {
                // Navigate to. The navigation view will redirect to the appropriate directory
                PickerActivity.this.mNavigationView.changeCurrentDir(rootDirectory);
            }
        });

    }

