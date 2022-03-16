        @Override
        public int getInteger(String id, String resid, int def) {
            return EditorActivity.this.getResources().
                    getInteger(
                        ResourcesHelper.getIdentifier(
                            EditorActivity.this.getResources(), "integer", resid)); //$NON-NLS-1$
        }

