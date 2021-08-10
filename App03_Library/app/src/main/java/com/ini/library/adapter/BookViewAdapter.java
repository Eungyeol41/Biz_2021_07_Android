package com.ini.library.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/*
 * RecyclerView에 데이터를 보여주기 위한 Helper Class
 *      - 도움을 주는 Class
 *      - 필수 Class ( 이걸 사용할 때 코드가 간소해진다... )
 *
 * extends RecyclerView.Adapter
 *  -> Alt + Insert -> Implement method
 */
public class BookViewAdapter extends RecyclerView.Adapter {

    /*
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    /*
     * onCreateViewHolder
     * item을 그리는 item.xml 파일을 읽어서 사용할 준비하기
     * item.xml 파일을 view로 생성하고 데이터와 연결할 준비
     */
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    /*
     * @param holder
     * @param position
     */
    @Override
    /*
     * 생성된 Holder와 실제 데이터(1개)를 연결하는 작업
     * 1개의 데이터를 연결하는 작업을 수행하지만 RecyclerView에 의해서
     *  데이터들의 개수만큼 반복적으로 표출되어 화면에 데이터를 그리는 작업 수행
     */
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    /*
     * @return
     */
    @Override
    /*
     * 'onCreateViewHolder에서 생성된 Holder를 사용하여 onBindViewHolder가 데이터 1개 그리기를 수행하면
     *      RecyclerView에게 지금 데이터가 몇 개인지 알려주고 데이터 개수만큼 반복적으로 Holder를 그려라'
     *
     * 라는 값을 알려주는 method
     */
    public int getItemCount() {
        return 0;
    }

    /*
     * onCreateViewHolder() method가 사용하는 Class
     *
     * 실제 item.xml에 작성된 각각의 view component를 실제적으로 사용할 수 있도록
     *      각각 개별 View 객체로 생성하기 위한 보조 Class
     *
     * 초기 RecyclerVIew인 ListView 시절에는 선택 사항으로 만들지 않아도 됐었다...
     * RecyclerView에서는 반드시 있어야 하는 필수 클래스
     *
     * extends RecyclerView.ViewHolder
     *  -> Alt + Insert -> Constructor 생성
     */
    public static class BookItemHolder extends RecyclerView.ViewHolder{

        public BookItemHolder(@NonNull View itemView) {
            super(itemView);
        }

    }

}
