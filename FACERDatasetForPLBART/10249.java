        /**
         * {@inheritDoc}
         */
        @Override
        public void afterTextChanged(Editable s) {
            // Enter and Tab are not allowed, and have their own treatment
            final String orig = s.toString();
            String text = orig;
            final int start = this.mStart;
            final int count = this.mCount;

            // Avoid recursive calls
            if (this.mText != null && this.mText.compareTo(orig) == 0) {
                return;
            }

            // Force to ignore Tab and Enter keys
            text = replaceKeyEvent(text, '\t', true);
            text = replaceKeyEvent(text, '\r', false);
            text = replaceKeyEvent(text, '\n', false);
            if (text.compareTo(orig) != 0) {
                // Some key has internally changed
                this.mText = text;
                s.replace(0, orig.length(), text);
            }

            // Does the user input enter or tab keys?
            boolean tab = false;
            boolean enter = false;
            String userInput = orig.substring(start, start + count);
            tab = (userInput.indexOf("\t") != -1); //$NON-NLS-1$
            enter = (userInput.indexOf("\r") != -1 ||  //$NON-NLS-1$
                     userInput.indexOf("\n") != -1); //$NON-NLS-1$

            // Check events
            if (enter) {
                // Broadcast enter event
                doDone(false);
                return;
            }
            if (tab) {
                // Broadcast enter event
                doTab();
                return;
            }

            // Broadcast the new text value
            InlineAutocompleteTextView.this.onTextChanged(text);
        }

