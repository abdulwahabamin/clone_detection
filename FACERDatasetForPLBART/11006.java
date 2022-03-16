    /**
     * Method that applies the user-defined initial directory
     *
     * @param navigationView The navigation view
     * @param intent The current intent
     * @hide
     */
    void applyInitialDir(final NavigationView navigationView, final Intent intent) {
        //Load the user-defined initial directory
        String initialDir =
                Preferences.getSharedPreferences().getString(
                    FileManagerSettings.SETTINGS_INITIAL_DIR.getId(),
                    (String)FileManagerSettings.
                        SETTINGS_INITIAL_DIR.getDefaultValue());

        // Check if request navigation to directory (use as default), and
        // ensure chrooted and absolute path
        String navigateTo = intent.getStringExtra(EXTRA_NAVIGATE_TO);
        String intentAction = intent.getAction();
        if (navigateTo != null && navigateTo.length() > 0) {
            initialDir = navigateTo;
        } else if (intentAction != null && intentAction.equals(Intent.ACTION_VIEW)) {
            Uri data = intent.getData();
            if (data != null && (FileHelper.FILE_URI_SCHEME.equals(data.getScheme())
                    || FileHelper.FOLDER_URI_SCHEME.equals(data.getScheme())
                    || FileHelper.DIRECTORY_URI_SCHEME.equals(data.getScheme()))) {
                File path = new File(data.getPath());
                if (path.isDirectory()) {
                    initialDir = path.getAbsolutePath();
                }
            }
        }

        // Add to history
        final boolean addToHistory = intent.getBooleanExtra(EXTRA_ADD_TO_HISTORY, true);

        // We cannot navigate to a secure console if it is unmounted. So go to root in that case
        VirtualConsole vc = VirtualMountPointConsole.getVirtualConsoleForPath(initialDir);
        if (vc != null && vc instanceof SecureConsole && !((SecureConsole) vc).isMounted()) {
            initialDir = FileHelper.ROOT_DIRECTORY;
        }

        if (this.mChRooted) {
            // Initial directory is the first external sdcard (sdcard, emmc, usb, ...)
            if (!StorageHelper.isPathInStorageVolume(initialDir)) {
                StorageVolume[] volumes =
                        StorageHelper.getStorageVolumes(this, false);
                if (volumes != null && volumes.length > 0) {
                    initialDir = volumes[0].getPath();
                    int count = volumes.length;
                    for (int i = 0; i < count; i++) {
                        StorageVolume volume = volumes[i];
                        if (Environment.MEDIA_MOUNTED.equalsIgnoreCase(volume.getState())) {
                            initialDir = volume.getPath();
                            break;
                        }
                    }
                    //Ensure that initial directory is an absolute directory
                    initialDir = FileHelper.getAbsPath(initialDir);
                } else {
                    // Show exception and exit
                    DialogHelper.showToast(
                            this,
                            R.string.msgs_cant_create_console, Toast.LENGTH_LONG);
                    exit();
                    return;
                }
            }
        } else {
            //Ensure that initial directory is an absolute directory
            final String userInitialDir = initialDir;
            initialDir = FileHelper.getAbsPath(initialDir);
            final String absInitialDir = initialDir;
            File f = new File(initialDir);
            boolean exists = f.exists();
            if (!exists) {
                // Fix for /data/media/0. Libcore doesn't detect it correctly.
                try {
                    exists = CommandHelper.getFileInfo(this, initialDir, false, null) != null;
                } catch (InsufficientPermissionsException ipex) {
                    ExceptionUtil.translateException(
                            this, ipex, false, true, new OnRelaunchCommandResult() {
                        @Override
                        public void onSuccess() {
                            navigationView.changeCurrentDir(absInitialDir, addToHistory);
                        }
                        @Override
                        public void onFailed(Throwable cause) {
                            showInitialInvalidDirectoryMsg(userInitialDir);
                            navigationView.changeCurrentDir(FileHelper.ROOT_DIRECTORY,
                                    addToHistory);
                        }
                        @Override
                        public void onCancelled() {
                            showInitialInvalidDirectoryMsg(userInitialDir);
                            navigationView.changeCurrentDir(FileHelper.ROOT_DIRECTORY,
                                    addToHistory);
                        }
                    });

                    // Asynchronous mode
                    return;
                } catch (Exception ex) {
                    // We are not interested in other exceptions
                    ExceptionUtil.translateException(this, ex, true, false);
                }

                // Check again the initial directory
                if (!exists) {
                    showInitialInvalidDirectoryMsg(userInitialDir);
                    initialDir = FileHelper.ROOT_DIRECTORY;
                }

                // Weird, but we have a valid initial directory
            }
        }

        boolean needsEasyMode = false;
        if (mSdBookmarks != null ) {
            for (Bookmark bookmark :mSdBookmarks) {
                if (bookmark.mPath.equalsIgnoreCase(initialDir)) {
                    needsEasyMode = true;
                    break;
                }
            }
        }

        mNeedsEasyMode = getResources().getBoolean(R.bool.cmcc_show_easy_mode);

        needsEasyMode = needsEasyMode && mNeedsEasyMode;
        if (needsEasyMode) {
            performShowEasyMode();
        } else {
            performHideEasyMode();
        }
        // Change the current directory to the user-defined initial directory
        navigationView.changeCurrentDir(initialDir, addToHistory);
    }

