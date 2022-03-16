    /**package**/ void toggleNoSuggestions() {
        synchronized (this.mExecSync) {
            int type = InputType.TYPE_CLASS_TEXT |
                       InputType.TYPE_TEXT_FLAG_MULTI_LINE |
                       InputType.TYPE_TEXT_FLAG_IME_MULTI_LINE;
            if (!this.mNoSuggestions) {
                type |= InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS;
            }
            this.mEditor.setInputType(type);
            this.mNoSuggestions = !this.mNoSuggestions;
        }
    }

