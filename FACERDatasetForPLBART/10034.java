    /**
     * Method that resolve
     *
     * @param ctx The current context
     * @param intent The intent to resolve
     * application. If no preferred app or more than one exists the dialog is shown.
     * @param onDismissListener The dismiss listener
     */
    private static void resolveIntent(
            Context ctx, Intent intent, boolean choose, OnDismissListener onDismissListener) {
        if (choose) {
            PackageManager pm = ctx.getPackageManager();
            List<ResolveInfo> infos = pm.queryIntentActivities(intent, 0);

            Intent editor = new Intent(intent);
            editor.setClass(ctx, EditorActivity.class);

            if (infos.size() > 0) {
                // Try to only show the chooser when we have multiple items
                Intent i = Intent.createChooser(intent,
                        ctx.getString(R.string.associations_dialog_openwith_title));
                if (!handledByEditorInManifest(ctx, intent)) {
                    i.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[]{
                            editor,
                    });
                }
                try {
                    ctx.startActivity(i);
                } catch (ActivityNotFoundException e) {
                    try {
                        ctx.startActivity(editor);
                    } catch (ActivityNotFoundException e1) {
                        // Do nothing, this should never happen
                    }
                }
            } else {
                try {
                    ctx.startActivity(editor);
                } catch (ActivityNotFoundException e) {
                    // Do nothing, this should never happen
                }
            }
        } else {
            try {
                ctx.startActivity(intent);
            } catch (ActivityNotFoundException e) {
                intent.setClass(ctx, EditorActivity.class);
                try {
                    ctx.startActivity(intent);
                } catch (ActivityNotFoundException e2) {
                    // This should never happen unless the editor is removed.
                }
            }
        }
        if (onDismissListener != null) {
            onDismissListener.onDismiss(null);
        }
    }

