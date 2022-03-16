        /**
         * Method that returns an image drawable of the current theme
         *
         * @param ctx The current context
         * @param resource The string resource
         * @return Drawable The drawable
         */
        public Drawable getDrawable(Context ctx, String resource) {
            String resId = mId + "_" + resource; //$NON-NLS-1$
            int id = this.mResources.getIdentifier(resId, "drawable", this.mPackage); //$NON-NLS-1$
            if (id != 0) {
                return this.mResources.getDrawable(id);
            }

            // Default theme
            id = mDefaultTheme.mResources.getIdentifier(
                    resource, "drawable", mDefaultTheme.mPackage); //$NON-NLS-1$
            return mDefaultTheme.mResources.getDrawable(id);
        }

