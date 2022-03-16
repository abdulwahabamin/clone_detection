        @Override
        public CharSequence getString(String id, String resid) {
            return EditorActivity.this.getString(
                        ResourcesHelper.getIdentifier(
                            EditorActivity.this.getResources(), "string", resid)); //$NON-NLS-1$
        }

