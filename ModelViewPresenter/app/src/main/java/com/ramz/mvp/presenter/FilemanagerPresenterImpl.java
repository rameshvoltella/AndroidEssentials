package com.ramz.mvp.presenter;

import android.os.AsyncTask;
import android.util.Log;


import com.ramz.mvp.utils.AsyncResult;
import com.ramz.mvp.utils.GetFilesUtil;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by munnaz on 26/10/16.
 */

public class FilemanagerPresenterImpl implements FilemanagerPresenter {
    public static final int
            SORT_BY_NAME = 0,
            SORT_BY_TYPE = 1,
            SORT_BY_SIZE = 2;
    @Override
    public void getDiretory(final OnFinishedListener onFinishedListener, final File path) {

        new AsyncTask<File, Void, AsyncResult<File[]>>() {
            @Override
            protected AsyncResult<File[]> doInBackground(File... params) {
                try
                {
                    Log.d("MainParent","-------"+params[0].getParentFile().getPath());

                    File[] files =params[0].listFiles(GetFilesUtil.DEFAULT_FILE_FILTER);
                  /*  for(int i=0;i<files.length;i++)
                    {
                        Log.d(i+"FILES AND FOLDER","-------"+files[i].getName());
                        Log.d(i+"Is director","-------"+files[i].isDirectory());
                        Log.d(i+"PATH","-------"+files[i].getAbsolutePath());
                        Log.d(i+"Parent","-------"+files[i].getParentFile().getAbsolutePath());

                    }
*/
                    Log.d("FileSize","---"+files.length);
                    if (files == null)
                        throw new NullPointerException(params[0].getName());

//                        throw new NullPointerException(getString(R.string.cannot_read_directory_s, params[0].getName()));
                    if (isCancelled())
                        throw new Exception("Task cancelled");
                    Arrays.sort(files, getFileSortingComparator());
                    return new AsyncResult<File[]>(files);
                }
                catch (Exception e)
                {
                    return new AsyncResult<File[]>(e);
                }
            }

            @Override
            protected void onPostExecute(AsyncResult<File[]> asyncResult) {
                super.onPostExecute(asyncResult);
                try {
                    onFinishedListener.onFinishedFileOperation(asyncResult.getResult());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, path);




    }

    public Comparator<File> getFileSortingComparator()
    {
        int sortBy=SORT_BY_NAME;
        switch (sortBy)
        {
            case SORT_BY_SIZE:
                return new GetFilesUtil.FileSizeComparator();

            case SORT_BY_TYPE:
                return new GetFilesUtil.FileExtensionComparator();

            default:
                return new GetFilesUtil.FileNameComparator();
        }
    }


}
