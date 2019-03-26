package com.example.week5_fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class listViewFragment extends Fragment{

    MainActivity main;
    Context context = null;

    private static ArrayList<Student> listStudent;

    public static listViewFragment newInstance(ArrayList<Student> temp) {
        listViewFragment fragment = new listViewFragment();

        listStudent = new ArrayList<Student>();

        listStudent.addAll(temp);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            context = getActivity(); // use this reference to invoke main callbacks
            main = (MainActivity) getActivity();
        } catch (IllegalStateException e) {
            throw new IllegalStateException(
                    "MainActivity must implement callbacks");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        LinearLayout layout_listview = (LinearLayout) inflater.inflate(R.layout.fragment_list_view, null);

        final TextView txtView = (TextView) layout_listview.findViewById(R.id.txtShow);

        ListView listView = (ListView) layout_listview.findViewById(R.id.listView);

        listView.setAdapter(new CustomAdapter(context, R.layout.custom_listview, listStudent));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                txtView.setText("Mã số: " + listStudent.get(position).get_id());

                main.onMsgFromFragToMain("FRAG_LIST", position);
           }
        });

        return layout_listview;
    }


    class CustomAdapter extends ArrayAdapter{
        Context context;
        ArrayList<Student> list = new ArrayList<>();
        public CustomAdapter(Context context, int resource, ArrayList<Student> temp)
        {
            super(context, resource, temp);

            this.list.addAll(temp);

            this.context = context;
        }

        @Override
        public View getView(int position, View contextView, ViewGroup parent)
        {
            LayoutInflater inflated = ((Activity) context).getLayoutInflater();

            View row = inflated.inflate(R.layout.custom_listview, null);

            TextView label = (TextView) row.findViewById(R.id.label);

            label.setText(list.get(position).get_name());

            ImageView imgView = (ImageView) row.findViewById(R.id.imgView);

            imgView.setImageResource(list.get(position).get_img());

            return row;
        }
    }

}
