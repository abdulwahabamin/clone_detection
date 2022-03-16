		@Override
		public void onClick(DialogInterface dialog, int which) {
			if (which == 0) {
				dialog.dismiss();
		        SharedPreferences prefs = activity.getSharedPreferences("PrettyGoodMusicPlayer", MODE_PRIVATE);

				Log.i(TAG,
						"Preferences update success: "
								+ prefs.edit()
										.putString("ARTIST_DIRECTORY",
												path.getAbsolutePath())
										.commit());
				// reset the positions in the artist list, since we've changed
				// lists
				prefs.edit().putInt("ARTIST_LIST_TOP", Integer.MIN_VALUE)
						.putInt("ARTIST_LIST_INDEX", Integer.MIN_VALUE)
						.commit();
				return;
			}
			if (which == 1) {
				dialog.dismiss(); // TODO use cancel instead? What's the
									// difference?
				if (path.getParentFile() != null) {
					path = path.getParentFile();
				}
				files = Utils.getPotentialSubDirectories(path);
				showDirectoryPicker();
				
			} else {
				dialog.dismiss(); // TODO use cancel instead? What's the
									// difference?
				File f = files.get(which - 2);
				path = new File(path, f.getName());
				files = Utils.getPotentialSubDirectories(path);
				showDirectoryPicker();
			}

		}

