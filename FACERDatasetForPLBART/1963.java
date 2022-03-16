    public static void showToast(Context ctx,String msg)
    {
        if(ctx!=null&&!msg.isEmpty())
        {

            Toast.makeText(ctx,msg,Toast.LENGTH_SHORT).show();
        }



    }

