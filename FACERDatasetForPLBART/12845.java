        @Override
        public void onWrite(PageRange[] pages, ParcelFileDescriptor destination,
                CancellationSignal cancellationSignal, WriteResultCallback callback) {
            PrintedPdfDocument pdfDocument = new PrintedPdfDocument(mCtx,
                    mAttributes);
            try {
                Rect pageContentRect = getContentRect(mAttributes);
                int charsPerRow = (int) (pageContentRect.width() / mTextBounds.width());
                int rowsPerPage = rowsPerPage(pageContentRect);

                int currentPage = 0;
                int currentLine = 0;
                Page page = null;
                if (mAdjustedLines.size() > 0) {
                    page = pdfDocument.startPage(currentPage++);
                    printHeader(mCtx, page, pageContentRect, charsPerRow);
                }
                // Top (with margin) + header
                float top = pageContentRect.top + (mTextBounds.height() * 2);
                for (String line : mAdjustedLines) {
                    currentLine++;
                    page.getCanvas().drawText(line, pageContentRect.left,
                            top + (currentLine * mTextBounds.height()), mPaint);

                    if (currentLine >= rowsPerPage) {
                        if (page != null) {
                            printFooter(mCtx, page, pageContentRect, currentPage);
                            pdfDocument.finishPage(page);
                        }
                        currentLine = 0;
                        page = pdfDocument.startPage(currentPage++);
                        printHeader(mCtx, page, pageContentRect, charsPerRow);
                    }
                }

                // Finish the last page
                if (page != null) {
                    printFooter(mCtx, page, pageContentRect, currentPage);
                    pdfDocument.finishPage(page);
                } else {
                    page = pdfDocument.startPage(1);
                    printHeader(mCtx, page, pageContentRect, charsPerRow);
                    printFooter(mCtx, page, pageContentRect, currentPage);
                    pdfDocument.finishPage(page);
                }

                try {
                    // Write the document
                    pdfDocument.writeTo(new FileOutputStream(destination.getFileDescriptor()));

                    // Done
                    callback.onWriteFinished(new PageRange[]{PageRange.ALL_PAGES});
                } catch (IOException ioe) {
                    // Failed.
                    ExceptionUtil.translateException(mCtx, ioe);
                    callback.onWriteFailed("Failed to print image");
                }
            } finally {
                if (destination != null) {
                    try {
                        destination.close();
                    } catch (IOException ioe) {
                        /* ignore */
                    }
                }
            }
        }

