        /**
         * Method that returns the preview image of the current theme
         *
         * @param ctx The current context
         * @return Drawable The drawable
         */
        public Drawable getPreviewImage(Context ctx) {
            String resId = "theme_preview_drawable"; //$NON-NLS-1$
            if (this.compareTo(ThemeManager.getDefaultTheme(ctx)) != 0) {
                resId = mId + "_theme_preview_drawable"; //$NON-NLS-1$
            }
            int id = this.mResources.getIdentifier(resId, "drawable", this.mPackage); //$NON-NLS-1$
            if (id != 0) {
                return this.mResources.getDrawable(id);
            }
            return null;
        }

