        /**
         * Method that sets the base theme of the current context with no actionbar
         *
         * @param ctx
         */
        public void setBaseThemeNoActionBar(Context ctx) {
            String resId = mId + "_base_theme"; //$NON-NLS-1$
            int id = this.mResources.getIdentifier(resId, "string", this.mPackage); //$NON-NLS-1$
            if (id != 0) {
                String base = this.mResources.getString(id, "material_light"); //$NON-NLS-1$
                int themeId = base.compareTo("material") == 0 ? //$NON-NLS-1$
                        R.style.FileManager_Theme_Material_NoActionBar :
                        R.style.FileManager_Theme_Material_Light_NoActionBar;
                ctx.setTheme(themeId);
            }

            // Default theme
            id = mDefaultTheme.mResources.getIdentifier(
                    "base_theme", "string", mDefaultTheme.mPackage); //$NON-NLS-1$ //$NON-NLS-2$
            String base = this.mResources.getString(id, "material_light"); //$NON-NLS-1$
            int themeId = base.compareTo("material") == 0 ? //$NON-NLS-1$
                    R.style.FileManager_Theme_Material_NoActionBar :
                    R.style.FileManager_Theme_Material_Light_NoActionBar;
            ctx.setTheme(themeId);
        }

