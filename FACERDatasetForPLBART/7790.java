        @Override
        public void onClick( DialogInterface idialog, int whichButton ) {
            if( whichButton == DialogInterface.BUTTON_POSITIVE )
                owner.executeToViewer( ctv.getText().toString(), bbc.isChecked() );
            idialog.dismiss();
        }

