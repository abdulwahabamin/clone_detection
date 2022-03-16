    /**package**/ void toggleSyntaxHighlight() {
        synchronized (this.mExecSync) {
            if (this.mSyntaxHighlightProcessor != null) {
                try {
                    if (this.mSyntaxHighlight) {
                        this.mSyntaxHighlightProcessor.clear(this.mEditor.getText());
                    } else {
                        this.mSyntaxHighlightProcessor.process(this.mEditor.getText());
                    }
                } catch (Exception ex) {
                    // An error in a syntax library, should not break down app.
                    Log.e(TAG, "Syntax highlight failed.", ex); //$NON-NLS-1$
                }
            }

            this.mSyntaxHighlight = !this.mSyntaxHighlight;
        }
    }

