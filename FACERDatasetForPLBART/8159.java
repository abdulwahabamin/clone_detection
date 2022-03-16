        @Override
        public int getColor(String id, String resid, int def) {
            final Context ctx = EditorActivity.this;
            try {
                // Use the user-defined settings
                int[] colors = getUserColorScheme();
                HighlightColors[] schemeColors = HighlightColors.values();
                int cc = schemeColors.length;
                int cc2 = colors.length;
                for (int i = 0; i < cc; i++) {
                    if (schemeColors[i].getId().compareTo(id) == 0) {
                        if (cc2 >= i) {
                            // User-defined
                            return colors[i];
                        }

                        // Theme default
                        return ThemeManager.getCurrentTheme(ctx).getColor(ctx, resid);
                    }

                }

            } catch (Exception ex) {
                // Resource not found
            }
            return def;
        }

