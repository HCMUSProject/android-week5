package com.example.week5_fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class contentViewFragment extends Fragment implements FragmentCallbacks{

    private static ArrayList<Student> listStudent;

    TextView txtID, txtInfo;

    Button btnFirst, btnPrev, btnNext, btnLast;

    MainActivity main;

    public static contentViewFragment newInstance(ArrayList<Student> temp) {
        contentViewFragment fragment = new contentViewFragment();

        listStudent = new ArrayList<>();

        listStudent.addAll(temp);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (!(getActivity() instanceof MainCallbacks)) {
            throw new IllegalStateException( " Activity must implement MainCallbacks");
        }
        main = (MainActivity) getActivity(); // use this reference to invoke main callbacks
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        LinearLayout layout_content = (LinearLayout) inflater.inflate(R.layout.fragment_content_view, null);

        txtID = (TextView) layout_content.findViewById(R.id.txtViewID);

        txtInfo = (TextView) layout_content.findViewById(R.id.txtShowInfo);

        btnFirst = (Button) layout_content.findViewById(R.id.btnFirst);

        btnPrev = (Button) layout_content.findViewById(R.id.btnPrev);

        btnNext = (Button) layout_content.findViewById(R.id.btnNext);

        btnLast = (Button) layout_content.findViewById(R.id.btnLast);


        return layout_content;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public void onMsgFromMainToFragment(int position)
    {

    }
}
