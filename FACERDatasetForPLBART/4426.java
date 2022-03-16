	public static void openInstagram(Context myContext, Uri imageUri, String textCaption) {
		  if (isInstagramInstalled(myContext)) {


				Intent instagram = new Intent(android.content.Intent.ACTION_SEND);
				instagram.setType("image/jpg");
			  instagram.putExtra(Intent.EXTRA_STREAM, imageUri);
			  instagram.putExtra(Intent.EXTRA_TEXT, textCaption);
			  instagram.setPackage("com.instagram.android");
				//instagram.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY); //.FLAG_ACTIVITY_NEW_TASK
				myContext.startActivity(instagram);
		  }
	}

