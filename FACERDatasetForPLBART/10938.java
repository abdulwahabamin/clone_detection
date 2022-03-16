    /**package**/ void reloadSyntaxHighlight() {
        synchronized (this.mExecSync) {
            if (this.mSyntaxHighlightProcessor != null) {
                try {
                    this.mSyntaxHighlightProcessor.initialize();
                    this.mSyntaxHighlightProcessor.process(this.mEditor.getText());
                } catch (Exception ex) {
                    // An error in a syntax library, should not break down app.
                    Log.e(TAG, "Syntax highlight failed.", ex); //$NON-NLS-1$
                }
            }
        }
    }

