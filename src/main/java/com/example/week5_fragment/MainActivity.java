package com.example.week5_fragment;

import android.os.Bundle;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;


import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements MainCallbacks{

    ArrayList<Student> listStudent;

    FragmentTransaction ft;

    listViewFragment lvFragment;

    contentViewFragment contentFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listStudent = new ArrayList<Student>();

        listStudent.add(new Student("A1_9834", "Le A", 7.0, R.drawable.female));
        listStudent.add(new Student("A1_9826", "Le B", 8.0, R.drawable.male));
        listStudent.add(new Student("A2_9736", "Nguyen C", 6.0, R.drawable.female));
        listStudent.add(new Student("A2_9714", "Huynh D", 7.5, R.drawable.male));
        listStudent.add(new Student("A2_9801", "Nguyen E", 5.3, R.drawable.female));
        listStudent.add(new Student("A3_9903", "Hoang F", 7.0, R.drawable.male));
        listStudent.add(new Student("A3_9902", "Ngo G", 6.0, R.drawable.female));
        listStudent.add(new Student("A4_9614", "Tran H", 9.0, R.drawable.male));
        listStudent.add(new Student("A4_9624", "Nguyen I", 10.0, R.drawable.female));
        listStudent.add(new Student("A4_9654", "Pham K", 6.5, R.drawable.male));


        ft = getSupportFragmentManager().beginTransaction();

        // fragment listview
        lvFragment = listViewFragment.newInstance(listStudent);

        ft.replace(R.id.FragmentListView, lvFragment);

//        ft.commit();

        // fragment content
        contentFragment = contentViewFragment.newInstance(listStudent);

        ft.replace(R.id.FragmentContent, contentFragment);

        ft.commit();

    }



    public void onMsgFromFragToMain (String sender, int position)
    {
        if (sender.equals("FRAG_LIST") == true)
        {
            // gui position sang cho fragment content

            contentFragment.onMsgFromMainToFragment(position);
        }
    }
}
