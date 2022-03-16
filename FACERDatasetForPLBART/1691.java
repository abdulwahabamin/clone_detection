        public boolean onEditorAction(TextView view, int actionId, KeyEvent event) {
         
            if (actionId == EditorInfo.IME_NULL && event.getAction() == KeyEvent.ACTION_UP) {
                String message = view.getText().toString();
                sendMessage(message);
            }
           
            return true;
        }

