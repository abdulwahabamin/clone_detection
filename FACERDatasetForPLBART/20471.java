    /**
     * Set the target image resource ID.
     * <p>
     * This will clear an image Uri if one is set.
     */
    public Builder setResourceId(int resourceId) {
      if (resourceId == 0) {
        throw new IllegalArgumentException("Image resource ID may not be 0.");
      }
      this.resourceId = resourceId;
      this.uri = null;
      return this;
    }

