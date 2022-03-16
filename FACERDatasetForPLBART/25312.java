    public static void resetMusicDataAlert(final Context context) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context, R.style.RhythmAlertDialog);

        alertDialogBuilder.setTitle("Reset Music Data");
        alertDialogBuilder
                .setMessage("Including Most Played, Last Played and your Personal Playlists ?");
        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                MusicDataUtility.resetMusicStats(context);
                SharedPreferences sharedPreferences = context
                        .getSharedPreferences("com.laithlab.rhythm", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean(context.getString(R.string.first_time_pref_key), true);
                editor.apply();
            }
        });
        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

