    /**
     * @param artistName
     */
    public static void shopFor(Context mContext, String artistName) {
        String str = "https://market.android.com/search?q=%s&c=music&featured=MUSIC_STORE_SEARCH";
        Intent shopIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(String.format(str,
                Uri.encode(artistName))));
        shopIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        shopIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        mContext.startActivity(shopIntent);
    }

