    /** Clear the resize transformation, if any. This will also clear center crop/inside if set. */
    public Builder clearResize() {
      targetWidth = 0;
      targetHeight = 0;
      centerCrop = false;
      centerInside = false;
      return this;
    }

