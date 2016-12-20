package com.ramz.mvp;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.ramz.mvp.adaptor.FileExploreAdaptor;
import com.ramz.mvp.presenter.FileView;
import com.ramz.mvp.presenter.FilemanagerPresenterImpl;
import com.ramz.mvp.presenter.MainPresenterImpl;
import com.ramz.mvp.utils.RecyclerItemClickListener;

import java.io.File;

public class MainActivity extends AppCompatActivity implements FileView {

    /*FileView is implemented which retrun the result after the file operation taken place in the presnter to main view*/

    //Declaring the variables
    RecyclerView fileListRecylerView;
    File[] filesList;
    private static final int REQUEST_WRITE_STORAGE = 112;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fileListRecylerView = (RecyclerView) findViewById(R.id.recycler_view);

        fileListRecylerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), fileListRecylerView, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        if (filesList != null) {
                            //Passing the data to the presenter  to perform any action its up to the developer

                            MainPresenterImpl presenter = new MainPresenterImpl(getApplicationContext());
                            presenter.onItemClicked(filesList[position].getAbsolutePath());
                        }


                    }

                    @Override
                    public void onItemLongClick(View view, int position) {

                    }
                })
        );
    }

    @Override
    public void setView(File[] files) {
        //Get the result after the operation performed from presenter
        if (files != null) {
            filesList=files;
            fileListRecylerView.setAdapter(new FileExploreAdaptor(files));
        }
    }


    public void onButtonClick(View v) {

        //Basic request in marshmallow for storage
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            boolean hasPermission = (ContextCompat.checkSelfPermission(getApplicationContext(),
                    Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED);
            if (!hasPermission) {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        REQUEST_WRITE_STORAGE);
            } else {
                /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
                initScreen();

            }
        } else {
            initScreen();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQUEST_WRITE_STORAGE: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //reload my activity with permission granted or use the features what required the permission
                    initScreen();
                } else {
                    Toast.makeText(getApplicationContext(), "The app was not allowed to write to your storage. Hence, it cannot function properly. Please consider granting it this permission", Toast.LENGTH_LONG).show();
                }
            }
        }

    }

    public void initScreen()

    {
        //Calls presenter to list files
        MainPresenterImpl presenter = new MainPresenterImpl(new FilemanagerPresenterImpl(), getApplicationContext(), this);
        presenter.onButtonClicked(new File(Environment.getExternalStorageDirectory().getAbsolutePath()));
    }
}
