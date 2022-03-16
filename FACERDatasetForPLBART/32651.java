        private void setDetailedSummary(CharSequence prefKey) {
            Preference updatePref = findPreference(prefKey);
            ListPreference updateListPref = (ListPreference) updatePref;
            switch (updateListPref.getValue()) {
                case "preference_display_update_value":
                    updatePref.setSummary(R.string.preference_display_update_value_info);
                    break;
                case "preference_display_update_location_source":
                    updatePref.setSummary(R.string.preference_display_update_location_source_info);
                    break;
                case "preference_display_update_nothing":
                default:
                    updatePref.setSummary(updateListPref.getEntry());
                    break;
            }
        }

