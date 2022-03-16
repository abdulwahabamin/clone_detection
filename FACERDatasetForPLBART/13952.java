    private void play(Uri uri) {
        try {
            final String file = URLDecoder.decode( uri.toString(), "UTF-8");
            final String name = new File(file).getName();

            // Try to resolve the file to a media id
            final long id = MusicUtils.mService.getIdFromPath(file);
            if( id == -1 ) {
                // Open the stream, But we will not have album information
                openFile(file);
            }
            else {
                // Show a dialog asking the user for play or queue the song
                AlertDialog.Builder builder =
                        new AlertDialog.Builder(this, R.style.Theme_Light_Translucent_Dialog);
                builder.setTitle(R.string.butter_name);
                builder.setMessage(getString(R.string.play_external_question_msg, name));

                DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        try {
                            switch (which) {
                                case DialogInterface.BUTTON_POSITIVE:
                                    playOrEnqueuFile(file, id, false);
                                    break;

                                case DialogInterface.BUTTON_NEUTRAL:
                                    playOrEnqueuFile(file, id, true);
                                    break;

                                case DialogInterface.BUTTON_NEGATIVE:
                                    break;

                                default:
                                    break;
                            }
                        } finally {
                            finish();
                        }
                    }
                };
                builder.setPositiveButton(R.string.play_external_question_button_play, listener);
                builder.setNeutralButton(R.string.play_external_question_button_queue, listener);
                builder.setNegativeButton(R.string.play_external_question_button_cancel, listener);

                Dialog dialog = builder.create();
                dialog.setOnCancelListener(this);
                dialog.show();
            }

        } catch (Exception e) {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.play_external_error,
                    Toast.LENGTH_SHORT).show();
            Log.e(TAG, String.format("Failed to play external file: ", uri.toString()), e);
            try {
                Thread.sleep(1000L);
            }catch (Exception e2) {}
            finish();
        }

    }

