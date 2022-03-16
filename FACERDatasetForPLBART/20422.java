    /**
     * Specify a transformer for all incoming requests.
     * <p>
     * <b>NOTE:</b> This is a beta feature. The API is subject to change in a backwards
     * incompatible
     * way at any time.
     */
    public Builder requestTransformer(RequestTransformer transformer) {
      if (transformer == null) {
        throw new IllegalArgumentException("Transformer must not be null.");
      }
      if (this.transformer != null) {
        throw new IllegalStateException("Transformer already set.");
      }
      this.transformer = transformer;
      return this;
    }

