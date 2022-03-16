        @Override
        public boolean onPreferenceChange(final Preference preference, final Object newValue) {
            boolean ret = true;

            String key = preference.getKey();
            if (DEBUG) {
                Log.d(TAG,
                    String.format("New value for %s: %s",  //$NON-NLS-1$
                            key,
                            String.valueOf(newValue)));
            }

            if (isColorSchemePreference(preference)) {
                // Unify the color schemes property. Save the property here
                int color = ((Integer)newValue).intValue();
                try {
                    String colorScheme = toColorSchemeSet(preference, color);
                    Preferences.savePreference(
                            FileManagerSettings.SETTINGS_EDITOR_SH_COLOR_SCHEME,
                            colorScheme,
                            true);
                } catch (Exception e) {
                    ExceptionUtil.translateException(getActivity(), e);
                }
                ((ColorPickerPreference)preference).setColor(color);

                // Change the key to get notifications of color scheme
                key = FileManagerSettings.SETTINGS_EDITOR_SH_COLOR_SCHEME.getId();
            }

            // Notify the change (only if fragment is loaded. Default values are loaded
            // while not in loaded mode)
            if (EditorSHColorSchemePreferenceFragment.this.mLoaded && ret) {
                Intent intent = new Intent(FileManagerSettings.INTENT_SETTING_CHANGED);
                intent.putExtra(
                        FileManagerSettings.EXTRA_SETTING_CHANGED_KEY, key);
                getActivity().sendBroadcast(intent);
            }

            return ret;
        }

