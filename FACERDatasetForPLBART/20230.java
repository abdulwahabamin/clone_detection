  static BitmapHunter forRequest(Context context, Picasso picasso, Dispatcher dispatcher,
      Cache cache, Stats stats, Action action, Downloader downloader) {
      if (action.getRequest().resourceId != 0) {
          return new ResourceBitmapHunter(context, picasso, dispatcher, cache, stats, action);
      }
      Uri uri = action.getRequest().uri;
      String scheme = uri.getScheme();
    if (("byte").equals(scheme)) {
      return new ByteStreamBitmapHunter(context, picasso, dispatcher, cache, stats, action);
    } else if (SCHEME_FILE.equals(scheme)) {
        if (!uri.getPathSegments().isEmpty() && ANDROID_ASSET.equals(uri.getPathSegments().get(0))) {
            return new AssetBitmapHunter(context, picasso, dispatcher, cache, stats, action);
        }
        return new FileBitmapHunter(context, picasso, dispatcher, cache, stats, action);
    } else if (SCHEME_CONTENT.equals(scheme)) {
      if (Contacts.CONTENT_URI.getHost().equals(uri.getHost()) //
          && !uri.getPathSegments().contains(Contacts.Photo.CONTENT_DIRECTORY)) {
        return new ContactsPhotoBitmapHunter(context, picasso, dispatcher, cache, stats, action);
      } else if (MediaStore.AUTHORITY.equals(uri.getAuthority())) {
        return new MediaStoreBitmapHunter(context, picasso, dispatcher, cache, stats, action);
      } else {
        return new ContentStreamBitmapHunter(context, picasso, dispatcher, cache, stats, action);
      }
    } else if (SCHEME_ANDROID_RESOURCE.equals(scheme)) {
      return new ResourceBitmapHunter(context, picasso, dispatcher, cache, stats, action);
    } else {
      return new NetworkBitmapHunter(picasso, dispatcher, cache, stats, action, downloader);
    }
  }

