    public static void loadArt(@NonNull final Context context, @NonNull final ImageView artView,
                               @NonNull MediaDescriptionCompat description) {
        FireLog.e(TAG, "(++) loadArt: context=" + context + ", artView=" + artView + ", description=" + description);

        String artUrl = null;
        Uri iconUri = description.getIconUri();
        if (iconUri != null) {
            artUrl = iconUri.toString();
        }
        Glide.with(context)
                .load(artUrl)
                .error(R.drawable.ic_default_art)
                .into(artView);
    }

