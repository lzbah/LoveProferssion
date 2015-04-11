package lzb.com.loveproferssion;

import android.app.Activity;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.view.LayoutInflater;

import java.util.ArrayList;
import java.util.List;

import lzb.com.adpter.MainPageListAdapter;
import lzb.com.entity.MainPageListEntity;

/**
 * Created by lzb92 on 2015/4/11.
 */
public class MainPageFragment extends Fragment {

    private ListAdapter adapter;
    private List<MainPageListEntity> datas = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    private void getMainPageListData() {
        MainPageListEntity entity = new MainPageListEntity();
        entity.titleStr = "第一次爱";
        datas.add(entity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.mainpage_layout,container,false);


        getMainPageListData();
        ListView listView=(ListView)rootView.findViewById(R.id.main_page_list);

        adapter = new MainPageListAdapter(getActivity().getApplicationContext(), datas);
        listView.setAdapter(adapter);

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(
                getArguments().getInt(AppConfig.ARG_SECTION_NUMBER));
    }
}
