        /**
         * Method that returns the preview image of the current theme
         *
         * @param ctx The current context
         * @return Drawable The drawable
         */
        public Drawable getNoPreviewImage(Context ctx) {
            String resId = mId + "_theme_no_preview_drawable"; //$NON-NLS-1$
            int id = this.mResources.getIdentifier(resId, "drawable", this.mPackage); //$NON-NLS-1$
            if (id != 0) {
                return this.mResources.getDrawable(id);
            }

            // Default theme
            id = mDefaultTheme.mResources.getIdentifier(
                    "theme_no_preview_drawable", //$NON-NLS-1$
                    "drawable", //$NON-NLS-1$
                    mDefaultTheme.mPackage);
            return mDefaultTheme.mResources.getDrawable(id);
        }

