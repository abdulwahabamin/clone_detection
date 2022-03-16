        @Override
        public void onClick( View v ) {
              Date d = null;
              try {
                   d = df.parse( button.getText().toString() );
              } catch( Exception e ) {}                                
              cal.setTime( d == null ? new Date() : d );
              new DatePickerDialog( owner, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet( DatePicker vw, int y, int m, int d ) {
                        Calendar cda = new GregorianCalendar( y, m, d );
                        button.setText( df.format( cda.getTime() ) );
                    }
              }, cal.get(  Calendar.YEAR ) , 
                 cal.get(  Calendar.MONTH ), 
                 cal.get(  Calendar.DAY_OF_MONTH ) ).show();
        }

