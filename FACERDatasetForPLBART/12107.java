        private void applyTheme(Context ctx, ViewGroup root) {
            // Apply the current theme
            Theme theme = ThemeManager.getCurrentTheme(ctx);
            theme.setBackgroundDrawable(ctx, root, "background_drawable");
            theme.setTextColor(ctx, mMessage, "text_color");
            theme.setTextColor(ctx, mOldKey, "text_color");
            theme.setTextColor(ctx, (TextView) root.findViewById(R.id.unlock_old_password_title),
                    "text_color");
            theme.setTextColor(ctx, mKey, "text_color");
            theme.setTextColor(ctx, (TextView) root.findViewById(R.id.unlock_password_title),
                    "text_color");
            theme.setTextColor(ctx, mRepeatKey, "text_color");
            theme.setTextColor(ctx, (TextView) root.findViewById(R.id.unlock_repeat_title),
                    "text_color");
            theme.setTextColor(ctx, mValidationMsg, "text_color");
            mValidationMsg.setCompoundDrawablesWithIntrinsicBounds(
                    theme.getDrawable(ctx, "filesystem_dialog_warning_drawable"), //$NON-NLS-1$
                    null, null, null);
        }

