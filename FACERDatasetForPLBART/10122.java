        /**
         * Method that apply the current style to a button
         *
         * @param ctx The current context
         * @param button The button which apply the style
         */
        private void applyButtonStyle(Context ctx, Button button) {
            if (button != null) {
                setTextColor(ctx, button, "dialog_text_color"); //$NON-NLS-1$
            }
        }

