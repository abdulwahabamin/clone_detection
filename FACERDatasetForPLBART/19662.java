        @Override
        public boolean onPreferenceClick(Preference preference) {
            getActivity().finish();

            Intent intent = new Intent(mContext, WelcomeActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("REFRESH_MUSIC_LIBRARY", true);
            mContext.startActivity(intent);

            return false;
        }

