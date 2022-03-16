        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                if (intent.getAction().compareTo(Intent.ACTION_PACKAGE_REMOVED) == 0 ||
                    intent.getAction().compareTo(Intent.ACTION_PACKAGE_FULLY_REMOVED) == 0) {
                    // Check that the remove package is not the current theme
                    if (intent.getData() != null) {
                        // --- AIDs
                        try {
                            AIDHelper.getAIDs(getApplicationContext(), true);
                        } catch (Exception e) {
                            Log.w(TAG, "Failed to reload AIDs", e); //$NON-NLS-1$
                        }

                        // --- Themes
                        try {
                            // Get the package name and remove the schema
                            String apkPackage = intent.getData().toString();
                            apkPackage = apkPackage.substring("package:".length()); //$NON-NLS-1$

                            Theme currentTheme = ThemeManager.getCurrentTheme(context);
                            if (currentTheme.getPackage().compareTo(apkPackage) == 0) {
                                // The apk that contains the current theme was remove, change
                                // to default theme
                                String composedId =
                                    (String)FileManagerSettings.SETTINGS_THEME.getDefaultValue();
                                ThemeManager.setCurrentTheme(getApplicationContext(), composedId);
                                try {
                                    Preferences.savePreference(
                                            FileManagerSettings.SETTINGS_THEME, composedId, true);
                                } catch (Throwable ex) {
                                    Log.w(TAG, "can't save theme preference", ex); //$NON-NLS-1$
                                }

                                // Notify the changes to activities
                                try {
                                    Intent broadcastIntent =
                                            new Intent(FileManagerSettings.INTENT_THEME_CHANGED);
                                    broadcastIntent.putExtra(
                                            FileManagerSettings.EXTRA_THEME_ID, composedId);
                                    sendBroadcast(broadcastIntent);
                                } catch (Throwable ex) {
                                    Log.w(TAG, "notify of theme change failed", ex); //$NON-NLS-1$
                                }
                            }
                        } catch (Exception e) {
                            Log.w(TAG, "Failed to reload themes", e); //$NON-NLS-1$
                        }
                    }
                }
            }
        }

