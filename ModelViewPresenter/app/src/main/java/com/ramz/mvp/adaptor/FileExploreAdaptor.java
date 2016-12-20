package com.ramz.mvp.adaptor;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ramz.mvp.R;

import java.io.File;

/**
 * Created by munnaz on 20/12/16.
 */

public class FileExploreAdaptor extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    File[]fileList;
    public FileExploreAdaptor(File[]fileList)
    {
        this.fileList=fileList;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.file_explore_row_base, parent, false);

            return new FolderExploreBaseViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof FolderExploreBaseViewHolder) {
            FolderExploreBaseViewHolder folderExploreBaseViewHolder = (FolderExploreBaseViewHolder) holder;
            folderExploreBaseViewHolder.fileFolderTextView.setText(fileList[position].getName());
        }

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public class FolderExploreBaseViewHolder extends RecyclerView.ViewHolder {


        public TextView fileFolderTextView;


        public FolderExploreBaseViewHolder(View itemView) {
            super(itemView);
          fileFolderTextView=(TextView)itemView.findViewById(R.id.file_folder_name_text_view);
        }
    }
}
