    public static Intent searchForCategory(CharSequence categoryName, String contentType, Resources resources) {
        Intent intent = new Intent(MediaStore.INTENT_ACTION_MEDIA_SEARCH);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        intent.putExtra(MediaStore.EXTRA_MEDIA_FOCUS, contentType);
        intent.putExtra(SearchManager.QUERY, categoryName);

        return Intent.createChooser(intent, resources.getString(R.string.mediasearch, categoryName));
    }

