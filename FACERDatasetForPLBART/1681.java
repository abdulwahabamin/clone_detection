        @Override
        public void onClick(View v) {


            byte[] send = et2.getText().toString().getBytes();
            mChatService.write(send);


        }

