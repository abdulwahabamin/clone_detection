        @Override
        public void onClick(View v) {
            final DocumentsActivity activity = DocumentsActivity.get(SaveFragment.this);
            if (mReplaceTarget != null) {
                activity.onSaveRequested(mReplaceTarget);
            } else {
                final String mimeType = getArguments().getString(EXTRA_MIME_TYPE);
                final String displayName = mDisplayName.getText().toString();
                activity.onSaveRequested(mimeType, displayName);
            }
        }

