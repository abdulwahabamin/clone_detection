	public static void openNaverLineClient(Context context, File imageFile) {
		/*
		 *
		 * compress file
		 *
		 InputStream iStream = context.getContentResolver().openInputStream(Uri.parse(imageFile.getPath()));
		 ByteArrayOutputStream os = new ByteArrayOutputStream();
		 Bitmap bm = BitmapFactory.decodeStream(iStream);
		 bm.compress(Bitmap.CompressFormat.JPEG, 100, os);
		 os.flush();
		 byte[] w = os.toByteArray();
		 os.close();
		 iStream.close();
		 FileOutputStream out = new FileOutputStream(imageFile.getPath());
		 out.write(w, 0, w.length);
		 out.flush();
		  */
		 Uri uri = Uri.fromFile(new File(imageFile.getPath()));
		  
		 Intent intent = new Intent(Intent.ACTION_SEND);
		  
		 intent.setClassName(PACKAGE_NAME, CLASS_NAME);
		 intent.setType("image/jpeg");
		 intent.putExtra(Intent.EXTRA_STREAM, uri);
		 intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		 context.startActivity(intent); 
	}

