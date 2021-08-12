package com.ini.myword.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.ini.myword.R;
import com.ini.myword.databinding.MyWordItemBinding;
import com.ini.myword.model.WordDTO;

/**
 * 대부분.. LiveData와 연동하여 사용
 *
 * RecyclerView.Adapter를 상속받은 Adapter를 만들지만 LiveData와 연동하기 위하여 확장된 ListAdapter를 상속받아서 Class를 선언한다.
 *
 * ListAdapter는 RecyclerView를 확장한 Class로 Adapter를 선언할 때 상속을 받으면서 Generic으로 RecyclerView.ViewHolder와 함께
 *      'DTO class를 지정해주어야 한다'
 *
 * getItems() method는 포함하지 않는다
 * 자동으로 생성되는 생성자자

 */
public class WordViewAdapter extends ListAdapter<WordDTO, RecyclerView.ViewHolder> {

    protected WordViewAdapter(@NonNull DiffUtil.ItemCallback<WordDTO> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        MyWordItemBinding wordItemBinding = MyWordItemBinding.inflate(layoutInflater, parent, false);
        return new WordViewHolder(wordItemBinding);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        WordViewHolder wordHolder = (WordViewHolder) holder;
        wordHolder.itemBiding.itemKorea.setText("");
        wordHolder.itemBiding.itemKorea.setText("");
    }

    public static class WordViewHolder extends  RecyclerView.ViewHolder {

        public MyWordItemBinding itemBiding;
        public WordViewHolder(@NonNull MyWordItemBinding itemView) {
            super(itemView.getRoot());
            itemBiding = itemView;
        }
        public void bind(MyWordItemBinding wordItemBinding) {
            itemBiding = wordItemBinding;
        }
    }

}
