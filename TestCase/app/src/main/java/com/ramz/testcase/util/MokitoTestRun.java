package com.ramz.testcase.util;

import android.content.Context;

import com.ramz.testcase.R;

/**
 * Created by munnaz on 18/12/16.
 */

public class MokitoTestRun {
    Context mContext;
   public  MokitoTestRun(Context mContext)
    {
        this.mContext=mContext;
    }

    public String getHelloWorldString()
    {
     return mContext.getString(R.string.hello_word);
    }
}
