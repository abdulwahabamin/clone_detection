    private static Intent createEditorIntent(Context ctx, FileSystemObject fso) {
        Intent editorIntent = null;
        MimeTypeCategory category = MimeTypeHelper.getCategory(ctx, fso);

        editorIntent = new Intent();
        editorIntent.setAction(Intent.ACTION_VIEW);
        editorIntent.addCategory(CATEGORY_INTERNAL_VIEWER);
        editorIntent.addCategory(CATEGORY_EDITOR);
        return editorIntent;
    }

