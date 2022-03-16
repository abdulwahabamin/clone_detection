        @Override
        public boolean onPreferenceChange(final Preference preference, Object newValue) {
            boolean ret = true;
            boolean notify = false;

            String key = preference.getKey();
            if (DEBUG) {
                Log.d(TAG,
                    String.format("New value for %s: %s",  //$NON-NLS-1$
                            key,
                            String.valueOf(newValue)));
            }

            // Filetime format mode
            if (FileManagerSettings.SETTINGS_FILETIME_FORMAT_MODE.
                    getId().compareTo(key) == 0) {
                String value = (String)newValue;
                int valueId = Integer.valueOf(value).intValue();
                String[] labels = getResources().getStringArray(
                        R.array.filetime_format_mode_labels);
                                    preference.setSummary(labels[valueId]);
            }

            // Disk usage warning level
            else if (FileManagerSettings.SETTINGS_DISK_USAGE_WARNING_LEVEL.
                    getId().compareTo(key) == 0) {
                String value = (String)newValue;
                preference.setSummary(
                        getResources().getString(
                                R.string.pref_disk_usage_warning_level_summary, value));
            }

            // Access mode
            else if (FileManagerSettings.SETTINGS_ACCESS_MODE.getId().compareTo(key) == 0) {
                Activity activity = GeneralPreferenceFragment.this.getActivity();

                String value = (String)newValue;
                AccessMode oldMode = FileManagerApplication.getAccessMode();
                AccessMode newMode = AccessMode.fromId(value);

                // Denied change to root if su command is not present
                if (newMode.compareTo(AccessMode.ROOT) == 0 &&
                        !FileManagerApplication.isDeviceRooted()) {
                    DialogHelper.showToast(activity, R.string.root_not_available_msg,
                            Toast.LENGTH_SHORT);
                    return false;
                }
                if (oldMode.compareTo(newMode) != 0) {
                    // The mode was changes. Change the console
                    if (newMode.compareTo(AccessMode.ROOT) == 0) {
                        if (!ConsoleBuilder.changeToPrivilegedConsole(
                                activity.getApplicationContext())) {
                            value = String.valueOf(oldMode.ordinal());
                            ret = false;
                        }
                    } else {
                        if (!ConsoleBuilder.changeToNonPrivilegedConsole(
                                activity.getApplicationContext())) {
                            value = String.valueOf(oldMode.ordinal());
                            ret = false;
                        }
                    }
                }

                int valueId = Integer.valueOf(value).intValue();
                String[] summary = getResources().getStringArray(
                        R.array.access_mode_summaries);
                                    preference.setSummary(summary[valueId]);
            }

            // Restricted secondary users access
            else if (FileManagerSettings.SETTINGS_RESTRICT_SECONDARY_USERS_ACCESS.getId().
                    compareTo(key) == 0) {
                String value = String.valueOf(newValue);
                if (Preferences.writeWorldReadableProperty(getActivity(), key, value)) {
                    ((SwitchPreference) preference).setChecked((Boolean) newValue);
                    updateAccessModeStatus();
                    notify = true;
                }
                ret = false;
            }

            // Notify the change (only if fragment is loaded. Default values are loaded
            // while not in loaded mode)
            if (GeneralPreferenceFragment.this.mLoaded && (ret || notify)) {
                Intent intent = new Intent(FileManagerSettings.INTENT_SETTING_CHANGED);
                intent.putExtra(
                        FileManagerSettings.EXTRA_SETTING_CHANGED_KEY, preference.getKey());
                getActivity().sendBroadcast(intent);
            }

            return ret;
        }

