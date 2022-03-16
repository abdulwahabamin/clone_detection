        @Override
        protected void onPostExecute( Boolean succeeded ) {
            pd.cancel();
            if( succeeded ) 
                Editor.this.dirty = false;
            else
                Editor.this.showMessage( Editor.this.getString( R.string.cant_save ) );
        }

