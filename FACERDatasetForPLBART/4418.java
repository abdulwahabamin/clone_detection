	public static void openBriefApp(Context context) {
	    Intent intent = new Intent(context, Main.class);
	    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
	    context.startActivity(intent);
        //context.removeStickyBroadcast(intent);
	}

