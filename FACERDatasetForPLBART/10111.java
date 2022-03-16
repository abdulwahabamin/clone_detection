        /**
         * Method that sets the base theme of the current context
         *
         * @param ctx The current context
         * @param overlay Indicates if the theme should be the overlay one
         */
        public void setBaseTheme(Context ctx, boolean overlay) {
            String resId = mId + "_base_theme"; //$NON-NLS-1$
            int id = this.mResources.getIdentifier(resId, "string", this.mPackage); //$NON-NLS-1$
            if (id != 0) {
                String base = this.mResources.getString(id, "material_light"); //$NON-NLS-1$
                int themeId = base.compareTo("material") == 0 ? //$NON-NLS-1$
                                R.style.FileManager_Theme_Material :
                                R.style.FileManager_Theme_Material_Light;
                if (overlay) {
                    themeId = base.compareTo("material") == 0 ? //$NON-NLS-1$
                            R.style.FileManager_Theme_Material_Overlay :
                            R.style.FileManager_Theme_Material_Light_Overlay;
                }
                ctx.setTheme(themeId);
                return;
            }

            // Default theme
            id = mDefaultTheme.mResources.getIdentifier(
                    "base_theme", "string", mDefaultTheme.mPackage); //$NON-NLS-1$ //$NON-NLS-2$
            String base = this.mResources.getString(id, "material_light"); //$NON-NLS-1$
            int themeId = base.compareTo("material") == 0 ? //$NON-NLS-1$
                            R.style.FileManager_Theme_Material :
                            R.style.FileManager_Theme_Material_Light;
            if (overlay) {
                themeId = base.compareTo("material") == 0 ? //$NON-NLS-1$
                        R.style.FileManager_Theme_Material_Overlay :
                        R.style.FileManager_Theme_Material_Light_Overlay;
            }
            ctx.setTheme(themeId);
        }

