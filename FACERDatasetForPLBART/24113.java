    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        String currentFolder = PreferenceManager.getDefaultSharedPreferences(this).getString(SettingsActivity.MUSIC_FOLDER,
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC).getAbsolutePath());

        Intent intent = new Intent("org.openintents.action.PICK_DIRECTORY");
        if (getPackageManager().resolveActivity(intent, 0) != null) {
            intent.setData(Uri.fromFile(new File(currentFolder)));
            intent.putExtra("org.openintents.extra.TITLE", getResources().getString(R.string.music_folder));
            intent.putExtra("org.openintents.extra.BUTTON_TEXT", getResources().getString(R.string.pick_music_folder));
            startActivityForResult(intent, PICK_DIRECTORY);
        } else {
            View view = getLayoutInflater().inflate(R.layout.select_music_folder, null);
            final EditText editor = (EditText)view.findViewById(R.id.music_folder);
            editor.setText(currentFolder);

            new AlertDialog.Builder(this)
                   .setTitle(R.string.select_music_folder)
                   .setView(view)
                   .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                   .setPositiveButton(R.string.select_music_folder, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            String value = editor.getText().toString();
                            if (value.length() > 0) {
                                setMusicFolder(value);
                                finish();
                            }
                       }
                    }).show();
        }
    }

