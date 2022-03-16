        /**
         * Method that returns a color from the theme
         *
         * @param ctx The current context
         * @param resource The string resource
         * @return int The color reference
         */
        public int getColor(Context ctx, String resource) {
            String resId = mId + "_" + resource; //$NON-NLS-1$
            int id = this.mResources.getIdentifier(resId, "color", this.mPackage); //$NON-NLS-1$
            if (id != 0) {
                return this.mResources.getColor(id);
            }

            // Default theme
            id = mDefaultTheme.mResources.getIdentifier(
                    resource, "color", mDefaultTheme.mPackage); //$NON-NLS-1$
            return mDefaultTheme.mResources.getColor(id);
        }

