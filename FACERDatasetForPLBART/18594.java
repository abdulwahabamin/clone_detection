	@Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        parentActivity = getActivity();
        dialogFragment = (DialogFragment) getFragmentManager().findFragmentByTag("colorSchemesDialog");

        final SharedPreferences sharedPreferences = parentActivity.
                getSharedPreferences("com.aniruddhc.acemusic.player", Context.MODE_PRIVATE);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        //Check which theme is currently selected and set the appropriate flag.
        if (sharedPreferences.getString(NOW_PLAYING_COLOR, BLUE).equals(WHITE)) {
            selectedThemeIndex = 0;
        } else if (sharedPreferences.getString(NOW_PLAYING_COLOR, BLUE).equals(GRAY)) {
            selectedThemeIndex = 1;

        } else if (sharedPreferences.getString(NOW_PLAYING_COLOR, BLUE).equals(BLUE)) {
            selectedThemeIndex = 2;

        } else if (sharedPreferences.getString(NOW_PLAYING_COLOR, BLUE).equals(RED)) {
            selectedThemeIndex = 3;

        } else if (sharedPreferences.getString(NOW_PLAYING_COLOR, BLUE).equals(GREEN)) {
            selectedThemeIndex = 4;

        } else if (sharedPreferences.getString(NOW_PLAYING_COLOR, BLUE).equals(ORANGE)) {
            selectedThemeIndex = 5;

        } else if (sharedPreferences.getString(NOW_PLAYING_COLOR, BLUE).equals(PURPLE)) {
            selectedThemeIndex = 6;

        } else if (sharedPreferences.getString(NOW_PLAYING_COLOR, BLUE).equals(MAGENTA)) {
            selectedThemeIndex = 7;

        } else if (sharedPreferences.getString(NOW_PLAYING_COLOR, BLUE).equals(BLACK)) {
            selectedThemeIndex = 8;

        } else {
            selectedThemeIndex = 0;
        }

        //Set the dialog title.
        builder.setTitle(R.string.now_playing_color_scheme);
        builder.setSingleChoiceItems(R.array.now_playing_color_schemes, selectedThemeIndex, new OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                if (which == 0) {
                    sharedPreferences.edit().putString(NOW_PLAYING_COLOR, WHITE).commit();
                    dialog.dismiss();
                } else if (which == 1) {
                    sharedPreferences.edit().putString(NOW_PLAYING_COLOR, GRAY).commit();
                    dialog.dismiss();
                } else if (which == 2) {
                    sharedPreferences.edit().putString(NOW_PLAYING_COLOR, BLUE).commit();
                    dialog.dismiss();
                } else if (which == 3) {
                    sharedPreferences.edit().putString(NOW_PLAYING_COLOR, RED).commit();
                    dialog.dismiss();
                } else if (which == 4) {
                    sharedPreferences.edit().putString(NOW_PLAYING_COLOR, GREEN).commit();
                    dialog.dismiss();
                } else if (which == 5) {
                    sharedPreferences.edit().putString(NOW_PLAYING_COLOR, ORANGE).commit();
                    dialog.dismiss();
                } else if (which == 6) {
                    sharedPreferences.edit().putString(NOW_PLAYING_COLOR, PURPLE).commit();
                    dialog.dismiss();
                } else if (which == 7) {
                    sharedPreferences.edit().putString(NOW_PLAYING_COLOR, MAGENTA).commit();
                    dialog.dismiss();
                } else if (which == 8) {
                    sharedPreferences.edit().putString(NOW_PLAYING_COLOR, BLACK).commit();
                    dialog.dismiss();
                }

                getActivity().getActionBar().setBackgroundDrawable(UIElementsHelper.getGeneralActionBarBackground(getActivity()));
                getActivity().getWindow().setBackgroundDrawable(UIElementsHelper.getGeneralActionBarBackground(getActivity()));

            }

        });

        return builder.create();
    }

