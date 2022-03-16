        @Override
        public boolean onPreferenceClick(Preference preference) {

            //Get the current preference.
            int currentPreference = mApp.getSharedPreferences().getInt(Common.ALBUM_ARTISTS_LAYOUT, 0);

            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle(R.string.album_artists_layout);
            builder.setSingleChoiceItems(R.array.layout_preference_items, currentPreference, new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    mApp.getSharedPreferences().edit().putInt(Common.ALBUM_ARTISTS_LAYOUT, which).commit();
                    dialog.dismiss();
                    Toast.makeText(mContext, R.string.changes_saved, Toast.LENGTH_SHORT).show();

                }

            });

            builder.create().show();
            return false;
        }

