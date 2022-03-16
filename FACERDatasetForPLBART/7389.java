        public DatePickerButton( Context ctx, Button button_ ) {
            df = DateFormat.getDateFormat( ctx );
            button = button_;
            CharSequence cs = button.getText();
            if( cs == null || cs.length() == 0 )
                button.setText( df.format( cal.getTime() ) );
            button.setOnClickListener( this );
        }

