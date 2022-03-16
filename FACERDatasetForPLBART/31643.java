	private void CheckDBFile() {
		File f = new File(Config.DB_PATH);
		if (!f.exists()) {
			f.mkdir();
		}

		// Open the .db file in your assets directory
		try {
			InputStream is = getBaseContext().getAssets().open(Config.DB_NAME);
			// Copy the database into the destination
			OutputStream os = new FileOutputStream(Config.DB_PATH + Config.DB_NAME);
			byte[] buffer = new byte[1024];
			int length;
			while ((length = is.read(buffer)) > 0) {
				os.write(buffer, 0, length);
			}

			os.flush();
			os.close();
			is.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
		}
	}

