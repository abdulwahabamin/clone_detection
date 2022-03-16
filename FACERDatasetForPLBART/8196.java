    private void finishOnCreate() {

        // Register the broadcast receiver
        IntentFilter filter = new IntentFilter();
        filter.addAction(FileManagerSettings.INTENT_SETTING_CHANGED);
        filter.addAction(FileManagerSettings.INTENT_FILE_CHANGED);
        filter.addAction(FileManagerSettings.INTENT_THEME_CHANGED);
        filter.addAction(Intent.ACTION_DATE_CHANGED);
        filter.addAction(Intent.ACTION_TIME_CHANGED);
        filter.addAction(Intent.ACTION_TIMEZONE_CHANGED);
        filter.addAction(Intent.ACTION_LOCALE_CHANGED);
        filter.addAction(FileManagerSettings.INTENT_MOUNT_STATUS_CHANGED);
        registerReceiver(this.mNotificationReceiver, filter);

        // This filter needs the file data scheme, so it must be defined separately.
        IntentFilter newFilter = new IntentFilter();
        newFilter.addAction(Intent.ACTION_MEDIA_MOUNTED);
        newFilter.addAction(Intent.ACTION_MEDIA_UNMOUNTED);
        newFilter.addDataScheme(ContentResolver.SCHEME_FILE);
        registerReceiver(mNotificationReceiver, newFilter);

        //the input manager service
        mImm = (InputMethodManager) this.getSystemService(
                Context.INPUT_METHOD_SERVICE);

        //Initialize nfc adapter
        NfcAdapter mNfcAdapter = NfcAdapter.getDefaultAdapter(this);
        if (mNfcAdapter != null) {
            mNfcAdapter.setBeamPushUrisCallback(new NfcAdapter.CreateBeamUrisCallback() {
                @Override
                public Uri[] createBeamUris(NfcEvent event) {
                    List<FileSystemObject> selectedFiles =
                            getCurrentNavigationView().getSelectedFiles();
                    if (selectedFiles.size() > 0) {
                        List<Uri> fileUri = new ArrayList<Uri>();
                        for (FileSystemObject f : selectedFiles) {
                            //Beam ignores folders and system files
                            if (!FileHelper.isDirectory(f) && !FileHelper.isSystemFile(f)) {
                                fileUri.add(Uri.fromFile(new File(f.getFullPath())));
                            }
                        }
                        if (fileUri.size() > 0) {
                            return fileUri.toArray(new Uri[fileUri.size()]);
                        }
                    }
                    return null;
                }
            }, this);
        }

        //Initialize activity
        init();

        //Navigation views
        initNavigationViews();

        // As we're using a Toolbar, we should retrieve it and set it
        // to be our ActionBar
        mToolBar = (Toolbar) findViewById(R.id.material_toolbar);
        setActionBar(mToolBar);

        //Initialize action bars
        initTitleActionBar();
        initStatusActionBar();
        initSelectionBar();

        // Initialize navigation drawer
        initDrawer();
        initBookmarks();

        // Adjust layout (only when start on landscape mode)
        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            onLayoutChanged();
        }
        this.mOrientation = orientation;

        // Apply the theme
        applyTheme();

        // Show welcome message
        showWelcomeMsg();

        this.mHandler = new Handler();
        this.mHandler.post(new Runnable() {
            @Override
            public void run() {
                // Initialize console
                initConsole();

                //Initialize navigation
                int cc = NavigationActivity.this.mNavigationViews.length;
                for (int i = 0; i < cc; i++) {
                    initNavigation(i, false, getIntent());
                }

                //Check the intent action
                checkIntent(getIntent());
            }
        });

        MIME_TYPE_LOCALIZED_NAMES = MimeTypeCategory.getFriendlyLocalizedNames(NavigationActivity
            .this);

        EASY_MODE_ICONS.put(MimeTypeCategory.NONE, getResources().getDrawable(R.drawable
                .ic_em_all));
        EASY_MODE_ICONS.put(MimeTypeCategory.IMAGE, getResources().getDrawable(R.drawable
                .ic_em_image));
        EASY_MODE_ICONS.put(MimeTypeCategory.VIDEO, getResources().getDrawable(R.drawable
                .ic_em_video));
        EASY_MODE_ICONS.put(MimeTypeCategory.AUDIO, getResources().getDrawable(R.drawable
                .ic_em_music));
        EASY_MODE_ICONS.put(MimeTypeCategory.DOCUMENT, getResources().getDrawable(R.drawable
                .ic_em_document));
        EASY_MODE_ICONS.put(MimeTypeCategory.APP, getResources().getDrawable(R.drawable
                .ic_em_application));

    }

