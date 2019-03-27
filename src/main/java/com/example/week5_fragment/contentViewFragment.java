package com.example.week5_fragment;

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

    int curPosition = 0;

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

        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                curPosition = 0;

                LoadData();

                main.onMsgFromFragToMain("FRAG_CONTENT", curPosition);
            }
        });

        btnPrev = (Button) layout_content.findViewById(R.id.btnPrev);

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (curPosition > 0)
                {
                    curPosition--;
                }

                LoadData();

                main.onMsgFromFragToMain("FRAG_CONTENT", curPosition);
            }
        });

        btnNext = (Button) layout_content.findViewById(R.id.btnNext);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (curPosition < listStudent.size() - 1)
                {
                    curPosition++;
                }

                LoadData();

                main.onMsgFromFragToMain("FRAG_CONTENT", curPosition);
            }
        });

        btnLast = (Button) layout_content.findViewById(R.id.btnLast);

        btnLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                curPosition = listStudent.size() - 1;

                LoadData();

                main.onMsgFromFragToMain("FRAG_CONTENT", curPosition);
            }
        });


        // load data vao cac TextView
        this.LoadData();

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
        curPosition = position;

        this.LoadData();
    }

    private void LoadData()
    {
        if (curPosition >= 0)
        {
            txtID.setText(listStudent.get(curPosition).get_id());

            String classID = listStudent.get(curPosition).get_id().substring(0, listStudent.get(curPosition).get_id().indexOf("_"));

            String strTemp = "Họ tên: " + listStudent.get(curPosition).get_name() + "\nLớp: " + classID +
                    "\nĐiểm trung bình: " + listStudent.get(curPosition).get_score().toString();

            txtInfo.setText(strTemp);
        }

        // update trang thai cua cac button
        this.UpdateButton();
    }

    private void UpdateButton()
    {
        btnFirst.setEnabled(true);
        btnPrev.setEnabled(true);
        btnNext.setEnabled(true);
        btnLast.setEnabled(true);

        if (curPosition <= 0)
        {
            // btn first bi mo
            // btn prev bi mo

            btnFirst.setEnabled(false);
            btnPrev.setEnabled(false);
        }

        if (curPosition >= listStudent.size() - 1)
        {
            // btn last bi mo
            // btn next bi mo

            btnNext.setEnabled(false);
            btnLast.setEnabled(false);
        }
    }

}
