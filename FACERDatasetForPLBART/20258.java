  private InputStream getInputStream() throws IOException {
    ContentResolver contentResolver = context.getContentResolver();
    Uri uri = getData().uri;
    switch (matcher.match(uri)) {
      case ID_LOOKUP:
        uri = ContactsContract.Contacts.lookupContact(contentResolver, uri);
        if (uri == null) {
          return null;
        }
        // Resolved the uri to a contact uri, intentionally fall through to process the resolved uri
      case ID_CONTACT:
        if (SDK_INT < ICE_CREAM_SANDWICH) {
          return openContactPhotoInputStream(contentResolver, uri);
        } else {
          return ContactPhotoStreamIcs.get(contentResolver, uri);
        }
      case ID_THUMBNAIL:
      case ID_DISPLAY_PHOTO:
        return contentResolver.openInputStream(uri);
      default:
        throw new IllegalStateException("Invalid uri: " + uri);
    }
  }

