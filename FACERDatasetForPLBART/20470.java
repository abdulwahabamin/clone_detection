    /**
     * Set the target image Uri.
     * <p>
     * This will clear an image resource ID if one is set.
     */
    public Builder setUri(Uri uri) {
      if (uri == null) {
        throw new IllegalArgumentException("Image URI may not be null.");
      }
      this.uri = uri;
      this.resourceId = 0;
      return this;
    }

