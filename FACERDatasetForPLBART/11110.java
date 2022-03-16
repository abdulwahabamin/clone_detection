        @Override
        public boolean onPreferenceClick(Preference preference) {
            if (preference.equals(mResetPassword)) {
                getSecureConsole().requestReset(getActivity());
            } else if (preference.equals(mDeleteStorage)) {
                getSecureConsole().requestDelete(getActivity());
            }
            return false;
        }

