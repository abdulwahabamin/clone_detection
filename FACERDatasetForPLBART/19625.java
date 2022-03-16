        @Override
        public boolean onPreferenceClick(Preference preference) {
            //Get the current preference.
            int currentPreference = mApp.getSharedPreferences().getInt(Common.STARTUP_BROWSER, 0);

            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle(R.string.default_browser);
            builder.setSingleChoiceItems(R.array.startup_screen_items, currentPreference, new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    mApp.getSharedPreferences().edit().putInt(Common.STARTUP_BROWSER, which).commit();
                    dialog.dismiss();
                    Toast.makeText(mContext, R.string.changes_saved, Toast.LENGTH_SHORT).show();

                }

            });

            builder.create().show();
            return false;
        }

