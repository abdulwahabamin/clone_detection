        @Override
        public boolean onPreferenceClick(Preference preference) {
            if (preference.getKey().compareTo(REMOVE_SEARCH_TERMS_KEY) == 0) {
                // Remove search terms
                clearRecentSearchTerms();

                // Advise the user
                DialogHelper.showToast(
                        getActivity(),
                        getActivity().getString(R.string.pref_remove_saved_search_terms_msg),
                        Toast.LENGTH_SHORT);
            }
            return false;
        }

