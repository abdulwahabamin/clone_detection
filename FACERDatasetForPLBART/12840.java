    /**
     * Method that prints the passed document
     *
     * @param ctx The current context
     * @param fso The document to print
     */
    public static void printDocument(final Context ctx, FileSystemObject fso) {
        MimeTypeCategory category = MimeTypeHelper.getCategory(ctx, fso);
        if (category.equals(MimeTypeCategory.TEXT)) {
            printTextDocument(ctx, fso);
            return;
        }
        if (category.equals(MimeTypeCategory.IMAGE)) {
            printImage(ctx, fso);
            return;
        }
        String ext = FileHelper.getExtension(fso);
        if (ext != null && ext.toLowerCase().equals(PDF_FILE_EXT)) {
            printPdfDocument(ctx, fso);
            return;
        }
        DialogHelper.showToast(ctx, R.string.print_unsupported_document, Toast.LENGTH_SHORT);
    }

