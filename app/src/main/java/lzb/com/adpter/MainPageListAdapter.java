package lzb.com.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import lzb.com.entity.MainPageListEntity;
import lzb.com.loveproferssion.R;

/**
 * Created by lzb92 on 2015/4/11.
 */
public class MainPageListAdapter extends BaseAdapter {

    private List<MainPageListEntity> datas;
    private Context context;

    public MainPageListAdapter(Context context, List<MainPageListEntity> datas) {
        this.datas = datas;
        this.context = context;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = LayoutInflater.from(context).inflate(R.layout.main_page_list_item, null);
        TextView titleTxt = (TextView) convertView.findViewById(R.id.title_txt);
        titleTxt.setText(datas.get(position).titleStr);

        return convertView;
    }
}
