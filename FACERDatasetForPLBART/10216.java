        /**
         * {@inheritDoc}
         */
        @Override
        public void cancel() {
            // Remove the flinger effect
            this.mItemView.setTranslationX(0);
            clearVars();
        }

